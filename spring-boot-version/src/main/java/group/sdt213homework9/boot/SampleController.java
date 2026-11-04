package group.sdt213homework9.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The same controller as in the main project. With Thymeleaf the view name "sample"
 * is turned into src/main/resources/templates/sample.html automatically.
 */
@Controller
public class SampleController {

    @GetMapping("/sample")
    public String showForm() {
        return "sample";
    }

}
