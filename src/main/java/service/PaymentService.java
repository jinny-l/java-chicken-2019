package service;

import domain.Order;
import domain.Payment;
import domain.Table;
import java.util.List;
import repository.OrderRepository;

public class PaymentService {

    public List<Order> findOrdersByTable(Table table) {
        return OrderRepository.findOrdersByTable(table);
        // 주문 내역이 없을 때 처리
    }

    public int pay(Table table, Payment payment) {
        int chickenMenuCount = OrderRepository.countChickenOrdersBy(table);
        int chickenDiscountAmount = chickenMenuCount / 10 * 10000;

        int ordersValue = OrderRepository.sumMenuPriceBy(table);
        double paymentDiscountAmount = payment.calculateDiscountValue(ordersValue);

        OrderRepository.removeBy(table);

        return (int) (ordersValue - chickenDiscountAmount - paymentDiscountAmount);
    }
}
