package pl.gov.govtech.pegasus;

import pl.gov.govtech.pegasus.items.model.Department;
import pl.gov.govtech.pegasus.items.model.ItemType;

import java.time.LocalDateTime;

public class CreateShoppingDto {

    private long customerId;

    private Department department;

    private ItemType itemType;

    private LocalDateTime startDay;

    private LocalDateTime endDay;

    private CreateShoppingDto() {
        // mapper
    }

    public CreateShoppingDto(long customerId, Department department,
                             ItemType itemType, LocalDateTime startDay,
                             LocalDateTime endDay) {
        this.customerId = customerId;
        this.department = department;
        this.itemType = itemType;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public long getCustomerId() {
        return customerId;
    }

    public Department getDepartment() {
        return department;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public LocalDateTime getStartDay() {
        return startDay;
    }

    public LocalDateTime getEndDay() {
        return endDay;
    }
}
