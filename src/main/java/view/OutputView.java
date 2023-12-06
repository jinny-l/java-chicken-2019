package view;

import domain.Command;
import java.util.Arrays;
import java.util.stream.Collectors;

public class OutputView {

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

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
}
