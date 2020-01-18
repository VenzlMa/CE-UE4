package application;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GriffeController {

    @RequestMapping("/griffe")
    public Griffe griffe(@RequestParam(value="griffe", defaultValue="Fehler") String[] griffe) {
        return new Griffe(griffe);
    }
}