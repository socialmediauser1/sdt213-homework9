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

@SpringJUnitWebConfig(WebConfig.class)
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
                .andExpect(view().name("sample"))
                .andExpect(forwardedUrl("/WEB-INF/view/sample.jsp"));
    }

    @Test
    void rootUrlShowsIndexJsp() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(forwardedUrl("/WEB-INF/view/index.jsp"));
    }

    @Test
    void unknownUrlReturns404() throws Exception {
        mockMvc.perform(get("/unknown"))
                .andExpect(status().isNotFound());
    }
}
