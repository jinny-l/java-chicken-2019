package service.Config;

import service.OrderService;
import service.PaymentService;

public final class ServiceConfig {

    private ServiceConfig() {
    }

    public static PaymentService paymentService() {
        return PaymentService.getInstance();
    }

    public static OrderService orderService() {
        return OrderService.getInstance();
    }
}
