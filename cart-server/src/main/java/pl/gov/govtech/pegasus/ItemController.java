package pl.gov.govtech.pegasus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.gov.govtech.pegasus.items.model.Department;
import pl.gov.govtech.pegasus.items.model.DepartmentId;
import pl.gov.govtech.pegasus.items.model.Item;

import static validator.Validator.requireNonNull;

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = requireNonNull(itemService, "item service");
    }

    @GetMapping("/{department}/{id}")
    public Item listItems(@PathVariable("department") String department, @PathVariable("id") Long id) {
        logger.info("Get item with id: " + DepartmentId.of(Department.fromString(department), id));
        return itemService.getItem(DepartmentId.of(Department.fromString(department), id));
    }

}
