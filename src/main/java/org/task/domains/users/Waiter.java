package org.task.domains.users;

import org.task.domains.Table;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@javax.persistence.Table(name = "waiters")
public class Waiter extends User {


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "waiter_id")
    private Set<Table> tables;

    public Set<Table> getTables() {
        return tables;
    }

    public void setTables(Set<Table> tables) {
        this.tables = tables;
    }
}
