package org.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.task.domains.users.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    boolean existsByNameAndSurname(String name, String surname);
}
