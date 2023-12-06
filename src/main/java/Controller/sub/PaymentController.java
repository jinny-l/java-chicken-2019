package Controller.sub;

import Controller.Controller;
import domain.Payment;
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
        OutputView.printTables(orderService.findTables());
        Table table = readTable();

        OutputView.printOrders(paymentService.findOrdersByTable(table));

        Payment payment = readPayment(table);
        OutputView.printOrderValue(paymentService.pay(table, payment));
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

    private Payment readPayment(Table table) {
        try {
            return InputView.readPayment(table);

        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return readPayment(table);
        }
    }
}
