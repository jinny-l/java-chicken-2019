package Controller.sub;

import Controller.Controller;
import domain.Menu;
import domain.Order;
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

        OutputView.printMenus(orderService.findMenus());
        Menu menu = readMenu();
        Order order = readMenuQuantitiyAndCreateOrder(menu);

        orderService.order(table, order);
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

    private Menu readMenu() {
        try {
            int menuNumber = InputView.readMenuNumber();
            return orderService.findMenusByNumber(menuNumber);

        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return readMenu();
        }
    }

    private Order readMenuQuantitiyAndCreateOrder(Menu menu) {
        try {
            int menuQuantity = InputView.readMenuQuantity();
            return new Order(menu, menuQuantity);

        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return readMenuQuantitiyAndCreateOrder(menu);
        }
    }
}
