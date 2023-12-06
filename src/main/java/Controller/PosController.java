package Controller;

import domain.Command;
import view.InputView;
import view.OutputView;

public class PosController implements Controller {

    private final OrderController orderController;
    private final PaymentController paymentController;

    public PosController(OrderController orderController, PaymentController paymentController) {
        this.orderController = orderController;
        this.paymentController = paymentController;
    }

    @Override
    public void run() {
        Command command;

        do {
            OutputView.printCommand(Command.values());
            command = InputView.readCommand();

            if (command == Command.ORDER) {
                orderController.run();
            }

            if (command == Command.PAYMENT) {
                paymentController.run();
            }

        } while (command != Command.EXIT);
    }
}
