package domain;

import java.util.List;

public class Menu {

    private static final int CATEGORY_INDEX = 0;
    private static final int NUMBER_INDEX = 1;
    private static final int NAME_INDEX = 2;
    private static final int PRICE_INDEX = 3;

    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    private Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public static List<Menu> parseFromCsvFile(List<String> data) {
        return data.stream()
                .map(Menu::parseMenu)
                .toList();
    }

    private static Menu parseMenu(String line) {
        String[] values = line.split(",");
        return new Menu(
                Integer.parseInt(values[NUMBER_INDEX]),
                values[NAME_INDEX],
                Category.from(values[CATEGORY_INDEX]),
                Integer.parseInt(values[PRICE_INDEX])
        );
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s : %d원", category, number, name, price);
    }
}
