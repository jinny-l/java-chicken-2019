package domain;

import java.util.Arrays;
import java.util.function.Function;

public enum Payment {

    CARD(
            1,
            "신용 카드",
            ordersValue -> ordersValue * 0d
    ),
    CASH(
            2,
            "현금",
            ordersValue -> ordersValue * 0.05
    );

    private final int value;
    private final String text;
    private final Function<Integer, Double> discountFormula;

    Payment(int value, String text, Function<Integer, Double> discountFormula) {
        this.value = value;
        this.text = text;
        this.discountFormula = discountFormula;
    }

    public static Payment from(int value) {
        return Arrays.stream(Payment.values())
                .filter(command -> command.value == value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 결제 방법입니다."));
    }

    public double calculateDiscountValue(int ordersValue) {
        return discountFormula.apply(ordersValue);
    }
}
