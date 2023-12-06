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

    public static int readTableNumber() {
        System.out.printf("%n## 테이블을 선택하세요.%n");

        return readInt();
    }

    private static int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("테이블 번호는 숫자만 입력 가능합니다.");
        }
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
