package repository;

import domain.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TableRepository {

    private static final List<Table> TABLES = new ArrayList<>();

    static {
        TABLES.addAll(
                List.of(
                        new Table(1),
                        new Table(2),
                        new Table(3),
                        new Table(5),
                        new Table(6),
                        new Table(8)
                )
        );
    }

    public static List<Table> findAll() {
        return Collections.unmodifiableList(TABLES);
    }

    public static Optional<Table> findByNumber(int number) {
        return TABLES.stream()
                .filter(table -> table.isSameNumber(number))
                .findAny();
    }
}
