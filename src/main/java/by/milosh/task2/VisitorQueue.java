package by.milosh.task2;

import java.util.ArrayList;
import java.util.List;

public class VisitorQueue {
    private List<Visitor> visitors;

    public VisitorQueue() {
        this.visitors = new ArrayList<>();
    }

    public void initialize(List<Integer> queue) {
        for (int i = 0; i < queue.size(); i++) {
            visitors.add(new Visitor(Bill.valueOf("BILL_" + queue.get(i))));
        }
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }
}
