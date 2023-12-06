package Controller;

import domain.Command;
import view.InputView;
import view.OutputView;

public class PosController implements Controller {

    @Override
    public void run() {
        Command command;

        do {
            OutputView.printCommand(Command.values());
            command = readCommand();

            SubController.run(command);

        } while (command != Command.EXIT);
    }

    private Command readCommand() {
        try {
            return InputView.readCommand();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return readCommand();
        }
    }
}
