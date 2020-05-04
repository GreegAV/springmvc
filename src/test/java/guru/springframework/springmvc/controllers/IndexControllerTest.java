package guru.springframework.springmvc.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class IndexControllerTest {
    private MockMvc mockMvc;
    private IndexController indexController;

    @Before
    public void setup() {
        indexController = new IndexController();
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    public void test() {

    }

    @Test
    public void testIndexPageName() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view().name("index"));
    }

    @Test
    public void testIndexStatus() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}