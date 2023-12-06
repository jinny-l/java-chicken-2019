package Controller;

import domain.Table;
import service.OrderService;
import service.PaymentService;
import view.InputView;
import view.OutputView;

public class PaymentController implements Controller {

    private final OrderService orderService;
    private final PaymentService paymentService;

    public PaymentController() {
        this.orderService = new OrderService();
        this.paymentService = new PaymentService();
    }

    @Override
    public void run() {
        Table table = readTable();
        OutputView.printTables(orderService.findTables());

        OutputView.printOrders(paymentService.findOrdersByTable(table));
    }

    private Table readTable() {
        try {
            int number = InputView.readTableNumber();
            return orderService.findTablesByNumber(number);

        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return readTable();
        }
    }
}
