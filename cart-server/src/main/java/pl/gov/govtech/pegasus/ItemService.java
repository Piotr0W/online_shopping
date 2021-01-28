package pl.gov.govtech.pegasus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gov.govtech.pegasus.items.model.DepartmentId;
import pl.gov.govtech.pegasus.items.model.Item;
import pl.gov.govtech.pegasus.items.repo.ItemRepository;

import static validator.Validator.requireNonNull;

@Service
public class ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemService.class); //

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = requireNonNull(itemRepository, "item repository");
    }

    public Item getItem(DepartmentId departmentId) {
        return itemRepository.findByDepartmentId(departmentId)
                .orElseThrow(() -> new IllegalArgumentException("There is no item with department id: " + departmentId));
    }

}
