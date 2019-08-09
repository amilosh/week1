package by.milosh.task2;

public class Visitor {
    private Bill bill;

    public Visitor(Bill bill) {
        this.bill = bill;
    }

    public Bill getBill() {
        return bill;
    }
}
