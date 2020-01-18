package application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialController {

    @RequestMapping("/material")
    public Material material(@RequestParam(value="material", defaultValue="Fehler") String[] material) {
        return new Material(material);
    }
}
