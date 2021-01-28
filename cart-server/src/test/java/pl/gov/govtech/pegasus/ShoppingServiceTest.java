package pl.gov.govtech.pegasus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.gov.govtech.pegasus.customer.model.Customer;
import pl.gov.govtech.pegasus.customer.repo.CustomerRepository;
import pl.gov.govtech.pegasus.orders.model.Order;
import pl.gov.govtech.pegasus.orders.repo.OrderRepository;
import pl.gov.govtech.pegasus.items.model.Department;
import pl.gov.govtech.pegasus.items.model.Item;
import pl.gov.govtech.pegasus.items.model.ItemType;
import pl.gov.govtech.pegasus.items.repo.ItemRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShoppingService.class})
public class ShoppingServiceTest {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private ShoppingService shoppingService;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private ItemRepository itemRepository;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    public void add_givenExistingCustomerCorrectDepartmentCorrectFromDayCorrectEndDay_shouldAddItem() {
        // given
        long itemId = 1L;
        Customer customer = mock(Customer.class);
        Item item = mock(Item.class);
        Department department = Department.HEALTH;
        ItemType itemType = ItemType.PRODUCT_4;
        LocalDateTime startDay = LocalDateTime.parse("2022-01-01 00:00:00", dateFormatter);
        LocalDateTime endDay = LocalDateTime.parse("2022-12-31 00:00:00", dateFormatter);
        Order order = new Order(customer, item, startDay, endDay);

        given(customerRepository.findById(itemId)).willReturn(Optional.of(customer));
        given(itemRepository.getFirstFreeItem(department, itemType, startDay, endDay)).willReturn(Optional.of(item));
        given(orderRepository.save(order)).willReturn(order);

        // when
        shoppingService.add(itemId, department, itemType, startDay, endDay);

        // then
        verify(customerRepository, times(1)).findById(itemId);
        verify(itemRepository, times(1)).getFirstFreeItem(department, itemType, startDay, endDay);
        verify(orderRepository, times(1)).save(order);
        verifyNoMoreInteractions(customerRepository);
        verifyNoMoreInteractions(itemRepository);
        verifyNoMoreInteractions(orderRepository);
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_givenIncorrectCustomerIdNullDepartmentNullItemTypeNullStartDayNullEndDay_shouldThrowIAE() {
        // given
        long guestId = -1;
        Department department = null;
        ItemType itemType = null;
        LocalDateTime startDay = null;
        LocalDateTime endDay = null;

        // when
        shoppingService.add(guestId, department, itemType, startDay, endDay);

        // then
        // throw IAE
        throw new IllegalArgumentException(guestId + "can't be negative");
    }

}
