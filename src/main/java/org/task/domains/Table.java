package org.task.domains;

import org.task.domains.users.Waiter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@javax.persistence.Table(name = "cafe_table")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value=2, message="must be equal or greater than 2")
    @Max(value=10, message="must be equal or less than 10")
    @Column(name = "number_of_chairs")
    private int numberOfChairs;

    @Column(name = "table_is_taken")
    private boolean tableIsTaken;

    @ManyToOne(fetch = FetchType.LAZY)
    private Waiter waiter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfChairs() {
        return numberOfChairs;
    }

    public void setNumberOfChairs(int numberOfChairs) {
        this.numberOfChairs = numberOfChairs;
    }

    public boolean isTableIsTaken() {
        return tableIsTaken;
    }

    public void setTableIsTaken(boolean tableIsTaken) {
        this.tableIsTaken = tableIsTaken;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }


}
