package repository;

import domain.Order;
import domain.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {

    private static final Map<Table, List<Order>> ORDERS = new HashMap<>();

    public static void add(Table table, Order order) {
        List<Order> tableOrders = ORDERS.getOrDefault(table, new ArrayList<>());
        tableOrders.add(order);
        ORDERS.put(table, tableOrders);
    }
}
