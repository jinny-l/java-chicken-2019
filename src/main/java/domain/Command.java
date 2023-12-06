package domain;

import java.util.Arrays;

public enum Command {

    ORDER(1, "주문등록"),
    PAYMENT(2, "결제하기"),
    EXIT(3, "프로그램 종료");

    private final int value;
    private final String text;

    Command(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Command from(int value) {
        return Arrays.stream(Command.values())
                .filter(command -> command.value == value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 기능입니다."));
    }

    @Override
    public String toString() {
        return String.format("%d - %s", value, text);
    }
}
