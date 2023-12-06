package service;

import domain.Table;
import java.util.List;
import java.util.Optional;
import repository.TableRepository;

public class OrderService {

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
}
