package shortened.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import shortened.Application;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ShortenedUrlControllerTest {

    private static final MediaType CONTENT_TYPE_JSON = MediaType.APPLICATION_JSON_UTF8;
private final String url = "/shortUrl";
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void getContext() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
        assertNotNull(mockMvc);
    }

    @Test
    public void createAnShortUrl() throws Exception {
        mockMvc.perform(post(url)
                .contentType(CONTENT_TYPE_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void forwardingAnShortUrlToOriginal() throws Exception {
        mockMvc.perform(get(url)
                .contentType(CONTENT_TYPE_JSON))
                .andExpect(status().isOk());
    }
}