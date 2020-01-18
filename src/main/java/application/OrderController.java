package application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderController {

    @RequestMapping(value="/order", method = RequestMethod.POST)
    public String postOrder(
            @RequestParam(value = "griff", defaultValue = "") String griff,
            @RequestParam(value = "lenkertyp", defaultValue = "") String lenkertyp,
            @RequestParam(value = "material", defaultValue = "") String material,
            @RequestParam(value = "schaltung", defaultValue = "") String schaltung ) {
        return "Bestellung "+lenkertyp+" "+material+" "+schaltung+" "+griff+" erfolgreich erstellt.";
    }
}
