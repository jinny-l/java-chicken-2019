package view;

import domain.Command;
import java.util.Arrays;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printCommand(Command[] commands) {
        String format = "## 메인화면%n%s%n";
        String text = Arrays.stream(commands)
                .map(Command::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.printf(format, text);
    }
}
