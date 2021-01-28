package pl.gov.govtech.pegasus.generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gov.govtech.pegasus.customer.model.Customer;
import pl.gov.govtech.pegasus.customer.repo.CustomerRepository;
import pl.gov.govtech.pegasus.orders.model.Order;
import pl.gov.govtech.pegasus.orders.repo.OrderRepository;
import pl.gov.govtech.pegasus.items.model.Department;
import pl.gov.govtech.pegasus.items.model.DepartmentId;
import pl.gov.govtech.pegasus.items.model.Item;
import pl.gov.govtech.pegasus.items.repo.ItemRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static validator.Validator.*;

@Service
public class OrdersBuilder {

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final ItemRepository itemRepository;

    private Customer customer;

    private Department department;

    private long number;

    private LocalDateTime from;

    private LocalDateTime to;

    @Autowired
    public OrdersBuilder(OrderRepository orderRepository,
                         CustomerRepository customerRepository,
                         ItemRepository itemRepository) {
        this.orderRepository = requireNonNull(orderRepository, "order repository");
        this.customerRepository = requireNonNull(customerRepository, "customer repository");
        this.itemRepository = requireNonNull(itemRepository, "item repository");
    }

    public OrdersBuilder customer(String firstName, String lastName) {
        requireNonEmpty(firstName, "first name");
        requireNonEmpty(lastName, "last name");
        customer = getItem(firstName, lastName);
        return this;
    }

    public OrdersBuilder department(Department department) {
        this.department = requireNonNull(department, "department");
        return this;
    }

    public OrdersBuilder itemNumber(long number) {
        this.number = requirePositive(number, "item number");
        return this;
    }

    public OrdersBuilder from(String from) {
        requireNonEmpty(from, "from");
        this.from = LocalDateTime.parse(from+  " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return this;
    }

    public OrdersBuilder to(String to) {
        requireNonEmpty(to, "to");
        this.to = LocalDateTime.parse(to + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return this;
    }

    public void build() {
        validate();
        Item item = getItem(DepartmentId.of(department, number));
        Order order = new Order(customer, item, from, to);
        orderRepository.save(order);
    }

    private Customer getItem(String firstName, String lastName) {
        return customerRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new IllegalArgumentException("There is no customer with first name: " + firstName + " and last name: " + lastName));
    }

    private void validate() {
        requireNonNull(customer, "customer");
        requireNonNull(department, "department");
        requirePositive(number, "number");
    }

    private Item getItem(DepartmentId departmentId) {
        return itemRepository.findByDepartmentId(departmentId)
                .orElseThrow(() -> new IllegalArgumentException("There is no item with id: " + departmentId));
    }

}
