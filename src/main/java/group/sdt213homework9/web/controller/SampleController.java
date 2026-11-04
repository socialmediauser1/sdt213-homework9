package group.sdt213homework9.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Basic controller from section 5 of the tutorial.
 */
@Controller // Spring creates this bean and uses it to handle web requests
public class SampleController {

    /**
     * Handles GET /sample and returns the view name "sample".
     * The view resolver turns it into /WEB-INF/view/sample.jsp.
     */
    @GetMapping("/sample")
    public String showForm() {
        return "sample";
    }

}
