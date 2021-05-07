package org.task.domains;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "cafe_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_status")
    private Status orderStatus;

    @Column
    private int bill;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_order_id")
    private Set<ProductInOrder> productInOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ProductInOrder> getProductInOrder() {
        return productInOrder;
    }

    public void setProductInOrder(Set<ProductInOrder> productInOrder) {
        this.productInOrder = productInOrder;
    }
}
