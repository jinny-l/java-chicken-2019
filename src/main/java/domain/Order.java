package domain;

public class Order {

    private static final int MAX_QUANTITY = 99;

    private final Menu menu;
    private final int quantity;

    public Order(Menu menu, int quantity) {
        this.menu = menu;
        validateQuantity(quantity);
        this.quantity = quantity;
    }

    private void validateQuantity(int quantity) {
        if (quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("최대 주문 수량은 99개입니다.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", menu.getName(), quantity, menu.getPrice());
    }
}
