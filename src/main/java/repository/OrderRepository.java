package repository;

import domain.Order;
import domain.Table;
import java.util.ArrayList;
import java.util.Collections;
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

    public static List<Order> findOrdersByTable(Table table) {
        return ORDERS.getOrDefault(table, Collections.emptyList());
    }

    public static int countChickenOrdersBy(Table table) {
        List<Order> orders = findOrdersByTable(table);

        return (int) orders.stream()
                .filter(Order::isChicken)
                .count();
    }

    public static int sumMenuPriceBy(Table table) {
        List<Order> orders = findOrdersByTable(table);

        return orders.stream()
                .mapToInt(order -> order.getValue() * order.getQuantity())
                .sum();
    }

    public static void removeBy(Table table) {
        ORDERS.remove(table);
    }
}
