package pl.gov.govtech.pegasus.generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gov.govtech.pegasus.items.model.Department;
import pl.gov.govtech.pegasus.items.model.DepartmentId;
import pl.gov.govtech.pegasus.items.model.Item;
import pl.gov.govtech.pegasus.items.model.ItemType;
import pl.gov.govtech.pegasus.items.repo.ItemRepository;

import static validator.Validator.requireNonNull;
import static validator.Validator.requirePositive;

@Service
public class ItemsBuilder {

    private final ItemRepository itemRepository;

    private Department department;

    private long itemNumber;

    private ItemType type;

    @Autowired
    public ItemsBuilder(ItemRepository itemRepository) {
        this.itemRepository = requireNonNull(itemRepository, "item repository");
    }

    public ItemsBuilder department(Department department) {
        this.department = requireNonNull(department, "department");
        return this;
    }

    public ItemsBuilder itemNumber(long number) {
        this.itemNumber = requirePositive(number, "number");
        return this;
    }

    public ItemsBuilder itemType(ItemType type) {
        this.type = requireNonNull(type, "type");
        return this;
    }

    public void build() {
        validate();
        DepartmentId departmentId = DepartmentId.of(department, itemNumber);
        Item item = new Item(departmentId, type);
        itemRepository.save(item);
        reset();
    }

    private void validate() {
        requireNonNull(department, "department");
        requirePositive(itemNumber, "item number");
        requireNonNull(type, "type");
    }

    private void reset() {
        department = null;
        itemNumber = 0;
        type = null;
    }

}
