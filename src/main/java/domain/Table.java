package domain;

public class Table {

    private final int number;
    private boolean hasPeople;

    public Table(int number, boolean hasPeople) {
        this.number = number;
        this.hasPeople = hasPeople;
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    public void order() {
        hasPeople = true;
    }

    public void pay() {
        hasPeople = false;
    }

    public boolean hasPeople() {
        return hasPeople;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
