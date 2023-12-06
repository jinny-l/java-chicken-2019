package view;

import domain.Command;
import domain.Table;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    private OutputView() {
    }

    public static void printError(Exception e) {
        System.out.printf("%s%s%n", ERROR_MESSAGE_PREFIX, e.getMessage());
    }

    public static void printCommand(Command[] commands) {
        String format = "## 메인화면%n%s%n";
        String text = Arrays.stream(commands)
                .map(Command::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.printf(format, text);
    }

    public static void printTables(List<Table> tables) {
        int tablesSize = tables.size();

        System.out.printf("%n## 테이블 목록%n");
        printLines(TOP_LINE, tablesSize);
        printTableNumbers(tables);
        printLines(BOTTOM_LINE, tablesSize);
    }

    private static void printTableNumbers(List<Table> tables) {
        String text = tables.stream()
                .map(table -> String.format(TABLE_FORMAT, table.toString()))
                .collect(Collectors.joining());
        System.out.println(text);
    }

    private static void printLines(String line, int count) {
        System.out.println(line.repeat(count));
    }
}
