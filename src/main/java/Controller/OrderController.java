package Controller;

import domain.Table;
import service.OrderService;
import view.InputView;
import view.OutputView;

public class OrderController implements Controller {

    private final OrderService orderService;

    public OrderController() {
        this.orderService = new OrderService();
    }

    @Override
    public void run() {
        OutputView.printTables(orderService.findTables());

        Table table = readTable();

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
