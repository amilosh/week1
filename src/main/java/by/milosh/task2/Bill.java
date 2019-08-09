package by.milosh.task2;

public enum Bill {
    BILL_25(25),
    BILL_50(50),
    BILL_100(100);

    int value;

    Bill(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
