package pl.gov.govtech.pegasus;

import org.springframework.stereotype.Service;
import pl.gov.govtech.pegasus.customer.model.Customer;
import pl.gov.govtech.pegasus.customer.repo.CustomerRepository;
import pl.gov.govtech.pegasus.orders.model.Order;
import pl.gov.govtech.pegasus.orders.repo.OrderRepository;
import pl.gov.govtech.pegasus.items.model.Department;
import pl.gov.govtech.pegasus.items.model.Item;
import pl.gov.govtech.pegasus.items.model.ItemType;
import pl.gov.govtech.pegasus.items.repo.ItemRepository;

import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;
import static validator.Validator.requireNonNegative;

@Service
public class ShoppingService {

    private final ItemRepository itemRepository;

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    public ShoppingService(ItemRepository itemRepository,
                           CustomerRepository customerRepository,
                           OrderRepository orderRepository) {
        this.itemRepository = requireNonNull(itemRepository, "item repository");
        this.customerRepository = requireNonNull(customerRepository, "customers repository");
        this.orderRepository = requireNonNull(orderRepository, "order repository");
    }

    public void add(long customerId, Department department, ItemType itemType, LocalDateTime startDay, LocalDateTime endDay) {
        validate(customerId, department, itemType, startDay, endDay);
        Customer customer = getItem(customerId);
        Item item = getFirstFreeItem(department, itemType, startDay, endDay);
        Order order = new Order(customer, item, startDay, endDay);
        orderRepository.save(order);
    }

    private void validate(long customerId, Department department, ItemType itemType, LocalDateTime startDay, LocalDateTime endDay) {
        requireNonNegative(customerId, "customer id");
        requireNonNull(department, "department");
        requireNonNull(itemType, "item type");
        requireNonNull(startDay, "start day");
        requireNonNull(endDay, "end day");
    }

    private Item getFirstFreeItem(Department department, ItemType itemType, LocalDateTime startDay, LocalDateTime endDay) {
        return itemRepository.getFirstFreeItem(department, itemType, startDay, endDay)
                .orElseThrow(() -> new IllegalArgumentException("There is no free item"));
    }

    private Customer getItem(long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("There is no customer with id: " + customerId));
    }

}
