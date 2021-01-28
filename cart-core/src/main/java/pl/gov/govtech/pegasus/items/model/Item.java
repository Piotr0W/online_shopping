package pl.gov.govtech.pegasus.items.model;

import javax.persistence.*;
import java.util.Objects;

import static validator.Validator.requireNonNull;

@Entity
@Table(name = "items")
public class Item {

    @EmbeddedId
    private DepartmentId departmentId;

    private ItemType itemType;

    protected Item() {
        // JPA
    }

    public Item(DepartmentId departmentId, ItemType itemType) {
        this.departmentId = requireNonNull(departmentId, "department");
        this.itemType = requireNonNull(itemType, "item type");
    }

    public DepartmentId getDepartmentId() {
        return departmentId;
    }

    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return departmentId.equals(item.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId);
    }
}
