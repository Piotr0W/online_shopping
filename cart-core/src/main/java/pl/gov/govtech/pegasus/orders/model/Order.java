package pl.gov.govtech.pegasus.orders.model;

import pl.gov.govtech.pegasus.customer.model.Customer;
import pl.gov.govtech.pegasus.items.model.Item;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static validator.Validator.requireNonNull;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Customer customer;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "item_department"),
            @JoinColumn(name = "item_id")
    })
    private Item item;

    @Column
    private LocalDateTime startDay;

    @Column
    private LocalDateTime endDay;

    protected Order() {
        // JPA
    }

    public Order(Customer customer, Item item, LocalDateTime startDay, LocalDateTime endDay) {
        this.customer = requireNonNull(customer, "customer");
        this.startDay = requireNonNull(startDay, "from");
        this.endDay = requireNonNull(endDay, "to");
        this.item = requireNonNull(item, "item");
    }

    public long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Item getItem() {
        return item;
    }

    public LocalDateTime getStartDate() {
        return startDay;
    }

    public LocalDateTime getEndDate() {
        return endDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order that = (Order) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{id = " + id + ", from = " + startDay + ", to = " + endDay + "}";
    }
}
