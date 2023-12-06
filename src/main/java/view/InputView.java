package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Command;

public class InputView {

    private InputView() {
    }

    public static Command readCommand() {
        System.out.printf("%n## 원하는 기능을 선택하세요.%n");

        return Command.from(Integer.parseInt(readLine()));
    }

    private static String readLine() {
        String input = Console.readLine().strip();
        validateBlank(input);
        return input;
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }
}
