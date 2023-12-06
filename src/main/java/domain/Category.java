package domain;

import java.util.Arrays;
import java.util.Objects;

public enum Category {

    CHICKEN("치킨"),
    BEVERAGE("음료");

    private final String name;

    Category(final String name) {
        this.name = name;
    }

    public static Category from(String name) {
        return Arrays.stream(Category.values())
                .filter(category -> Objects.equals(category.name, name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("내부 데이터 오류"));
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
