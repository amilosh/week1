package by.milosh.task2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Clerk {
    Map<Bill, Integer> cashBox;

    public Clerk() {
        this.cashBox = new LinkedHashMap<Bill, Integer>();
        Bill[] bills = Bill.values();
        for (int i = 0; i < bills.length; i++) {
            cashBox.put(bills[i], 0);
        }
    }

    public boolean checkQueue(VisitorQueue visitorQueue) {
        List<Visitor> visitors = visitorQueue.getVisitors();

        for (Visitor visitor : visitors) {
            int billValue = visitor.getBill().value;
            if (billValue == 25) {
                checkAndChange25();
            } else if (billValue == 50) {
                if (!checkAndChange50()) return false;
            } else if (billValue == 100) {
                if (!checkAndChange100()) return false;
            }
        }
        return true;
    }

    private void checkAndChange25() {
        int cashBoxValue = cashBox.get(Bill.BILL_25);
        cashBox.put(Bill.BILL_25, cashBoxValue + 1);
    }

    private boolean checkAndChange50() {
        int cashBoxValue25 = cashBox.get(Bill.BILL_25);
        int cashBoxValue50 = cashBox.get(Bill.BILL_50);
        if (cashBoxValue25 > 0) {
            cashBox.put(Bill.BILL_25, cashBoxValue25 - 1);
            cashBox.put(Bill.BILL_50, cashBoxValue50 + 1);
            return true;
        } else return false;
    }

    private boolean checkAndChange100() {
        int cashBoxValue25 = cashBox.get(Bill.BILL_25);
        int cashBoxValue50 = cashBox.get(Bill.BILL_50);
        int cashBoxValue100 = cashBox.get(Bill.BILL_100);
        if (cashBoxValue50 > 0 && cashBoxValue25 > 0) {
            cashBox.put(Bill.BILL_25, cashBoxValue25 - 1);
            cashBox.put(Bill.BILL_50, cashBoxValue50 - 1);
            cashBox.put(Bill.BILL_100, cashBoxValue100 + 1);
            return true;
        } else if (cashBoxValue25 > 2) {
            cashBox.put(Bill.BILL_25, cashBoxValue25 - 3);
            cashBox.put(Bill.BILL_100, cashBoxValue100 + 1);
            return true;
        } else return false;
    }
}
