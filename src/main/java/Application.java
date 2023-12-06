import Controller.OrderController;
import Controller.PaymentController;
import Controller.PosController;

public class Application {

    public static void main(String[] args) {
        PosController controller = new PosController(
                new OrderController(),
                new PaymentController()
        );
        controller.run();
    }
}
