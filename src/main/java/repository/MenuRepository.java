package repository;

import domain.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import util.FileReader;

public class MenuRepository {

    private static final List<Menu> MENUS = new ArrayList<>();

    static {
        List<String> csvData = FileReader.read("src/main/resources/menu.csv");
        MENUS.addAll(
                Menu.parseFromCsvFile(csvData)
        );
    }

    public static List<Menu> findAll() {
        return Collections.unmodifiableList(MENUS);
    }

    public static Optional<Menu> findByNumber(int number) {
        return MENUS.stream()
                .filter(menu -> menu.isSameNumber(number))
                .findAny();
    }
}
