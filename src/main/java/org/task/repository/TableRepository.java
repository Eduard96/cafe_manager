package org.task.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.task.domains.Table;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {

    @EntityGraph(attributePaths = {"waiter"})
    Table findDistinctById(Long id);
}
