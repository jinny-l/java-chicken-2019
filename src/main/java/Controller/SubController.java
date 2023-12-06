package Controller;

import Controller.sub.OrderController;
import Controller.sub.PaymentController;
import domain.Command;
import java.util.Arrays;
import service.Config.ServiceConfig;

public enum SubController {

    ORDER(
            Command.ORDER,
            new OrderController(ServiceConfig.orderService())
    ),
    PAY(
            Command.PAYMENT,
            new PaymentController(
                    ServiceConfig.orderService(),
                    ServiceConfig.paymentService()
            )
    );

    private final Command command;
    private final Controller controller;

    SubController(Command command, Controller controller) {
        this.command = command;
        this.controller = controller;
    }

    public static void run(Command command) {
        Arrays.stream(SubController.values())
                .filter(subController -> subController.command == command)
                .findAny()
                .ifPresentOrElse(
                        subController -> subController.controller.run(),
                        () -> {
                            throw new IllegalArgumentException("매칭되는 컨트롤러가 없습니다.");
                        }
                );
    }
}
