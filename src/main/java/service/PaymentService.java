package service;

import domain.Order;
import domain.Table;
import java.util.List;
import repository.OrderRepository;

public class PaymentService {

    public List<Order> findOrdersByTable(Table table) {
        return OrderRepository.findOrdersByTable(table);
        // 주문 내역이 없을 때 처리
    }
}
