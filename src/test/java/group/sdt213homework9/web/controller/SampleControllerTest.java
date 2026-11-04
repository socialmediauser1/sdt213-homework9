package group.sdt213homework9.web.controller;

import group.sdt213homework9.config.WebConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Checks the Java configuration without starting a server.
 * MockMvc sends fake requests through the DispatcherServlet.
 */
@SpringJUnitWebConfig(WebConfig.class) // load WebConfig into a test web context
class SampleControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(WebApplicationContext context) {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void sampleUrlShowsSampleJsp() throws Exception {
        mockMvc.perform(get("/sample"))
                .andExpect(status().isOk())
                .andExpect(view().name("sample")) // name returned by SampleController
                .andExpect(forwardedUrl("/WEB-INF/view/sample.jsp")); // file chosen by the view resolver
    }

    @Test
    void rootUrlShowsIndexJsp() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index")) // set by the view controller in WebConfig
                .andExpect(forwardedUrl("/WEB-INF/view/index.jsp"));
    }

    @Test
    void unknownUrlReturns404() throws Exception {
        mockMvc.perform(get("/unknown"))
                .andExpect(status().isNotFound());
    }
}
