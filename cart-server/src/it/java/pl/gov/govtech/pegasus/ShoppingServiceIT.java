package pl.gov.govtech.pegasus;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import pl.gov.govtech.pegasus.items.model.Department;
import pl.gov.govtech.pegasus.items.model.ItemType;
import pl.gov.govtech.pegasus.orders.model.Order;
import pl.gov.govtech.pegasus.orders.repo.OrderRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShopITConfiguration.class})
@AutoConfigureMockMvc
@Transactional
public class ShoppingServiceIT {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Before
    public void initialize() {

    }

    @Test
    public void order_givenCorrectCustomerIdCorrectDepartmentCorrectItemTypeCorrectOrderDayCorrectFinishDay_shouldReturnStatusOkAndOrderItem() throws Exception {
        // given
        long customerId = 10L;
        Department department = Department.HEALTH;
        ItemType itemType = ItemType.PRODUCT_20;
        LocalDateTime startDay = LocalDateTime.parse("2022-01-01 00:00:00", dateFormatter); // czy bedzie juz produkt w sprzedazy
        LocalDateTime endDay = LocalDateTime.parse("2022-01-02 00:00:00", dateFormatter);

        String json = getJson(customerId, department, itemType, startDay, endDay);

        // when
        ResultActions result = mockMvc.perform(post("/shopping/order")
                .contentType(APPLICATION_JSON_UTF8)
                .content(json));

        // then
        Order actualOrder = orderRepository.findLastOrder();
        long actualCustomerId = actualOrder.getCustomer().getId();
        Department actualDepartment = actualOrder.getItem().getDepartmentId().getDepartment();
        ItemType actualItemType = actualOrder.getItem().getItemType();
        LocalDateTime actualStartDay = actualOrder.getStartDate();
        LocalDateTime actualEndDay = actualOrder.getEndDate();

        result.andExpect(status().isOk());
        assertEquals(customerId, actualCustomerId);
        assertEquals(department, actualDepartment);
        assertEquals(itemType, actualItemType);
        assertEquals(startDay, actualStartDay);
        assertEquals(endDay, actualEndDay);
    }

    private String getJson(long customerId, Department department,
                           ItemType itemType, LocalDateTime startDay,
                           LocalDateTime endDay) throws JsonProcessingException {
        CreateShoppingDto createShoppingDto = new CreateShoppingDto(customerId, department, itemType, startDay, endDay);
        return objectMapper.writeValueAsString(createShoppingDto);
    }

    @After
    public void clean() {
        orderRepository.deleteLast();
    }

}
