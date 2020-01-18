package application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CostumerController {

    @RequestMapping(value="/costumer", method = RequestMethod.POST)
    public String createCostumer(@RequestParam(value = "name", defaultValue = "") String name, @RequestParam(value = "surname", defaultValue = "") String surname ) {
        return "Kunde "+name+" "+surname+" wurde erfasst.";
    }
}
