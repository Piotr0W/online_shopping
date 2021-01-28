package pl.gov.govtech.pegasus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static validator.Validator.requireNonNull;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    private final ShoppingService shoppingService;

    @Autowired
    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = requireNonNull(shoppingService, "shopping service");
    }

    @PostMapping("/order")
    public void order(@RequestBody CreateShoppingDto createBookingDto) {
        shoppingService.add(createBookingDto.getCustomerId(), createBookingDto.getDepartment(),
                createBookingDto.getItemType(), createBookingDto.getStartDay(), createBookingDto.getEndDay());
    }

}
