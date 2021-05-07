package org.task.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.task.domains.users.Waiter;

@Repository
public interface WaiterRepository extends JpaRepository<Waiter, Long> {

    @EntityGraph(attributePaths = {"tables"})
    Waiter findDistinctById(Long id);
}
