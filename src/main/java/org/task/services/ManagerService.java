package org.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.task.domains.Product;
import org.task.domains.Table;
import org.task.domains.users.Manager;
import org.task.domains.users.Waiter;
import org.task.repository.ManagerRepository;
import org.task.repository.ProductRepository;
import org.task.repository.TableRepository;
import org.task.repository.WaiterRepository;
import org.task.utils.AssignForm;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final TableRepository tableRepository;
    private final WaiterRepository waiterRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository,
                          TableRepository tableRepository,
                          WaiterRepository waiterRepository, ProductRepository productRepository) {
        this.managerRepository = managerRepository;
        this.tableRepository = tableRepository;
        this.waiterRepository = waiterRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public void saveWaiter(Waiter waiter) {
        waiterRepository.save(waiter);
    }

    @Transactional
    public void saveTable(Table table) {
        tableRepository.save(table);
    }

    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void assignTableToWaiter(AssignForm assignForm) {
        Table table = tableRepository.findDistinctById(assignForm.getTable_id());
        Waiter waiter = waiterRepository.findDistinctById(assignForm.getWaiter_id());
        table.setWaiter(waiter);
        tableRepository.save(table);
    }

    public boolean exists(Manager manager) {
        return managerRepository.existsByNameAndSurname(manager.getName(), manager.getSurname());
    }
}
