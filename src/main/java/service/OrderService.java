package service;

import domain.Menu;
import domain.Order;
import domain.Table;
import java.util.List;
import java.util.Optional;
import repository.MenuRepository;
import repository.OrderRepository;
import repository.TableRepository;

public class OrderService {

    public void order(Table table, Order order) {
        OrderRepository.add(table, order);
    }

    public List<Table> findTables() {
        return TableRepository.findAll();
    }

    public Table findTablesByNumber(int number) {
        Optional<Table> table = TableRepository.findByNumber(number);

        if (table.isEmpty()) {
            throw new IllegalArgumentException("없는 테이블 번호입니다.");
        }

        return table.get();
    }

    public List<Menu> findMenus() {
        return MenuRepository.findAll();
    }

    public Menu findMenusByNumber(int number) {
        Optional<Menu> menu = MenuRepository.findByNumber(number);

        if (menu.isEmpty()) {
            throw new IllegalArgumentException("없는 메뉴 번호입니다.");
        }

        return menu.get();
    }

}
