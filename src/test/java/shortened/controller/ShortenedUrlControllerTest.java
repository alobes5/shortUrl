package shortened.controller;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import shortened.Application;
import shortened.model.UrlModel;
import shortened.service.ShortUrlService;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ShortenedUrlControllerTest {

    @MockBean
    private ShortUrlService service;

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
        String longUrl = "http://google.com";
        String shortUrl = "http://localhost:8080/12345";
        UrlModel expected = UrlModel.builder().longUrl(longUrl).shortUrl(shortUrl).build();
        Mockito.when(service.createShortUrl(Mockito.anyString())).thenReturn(expected);

        mockMvc.perform(post(url).content("{\"longUrl\":\"https://scholar.google.com.br/schhp?hl=en\"}")
                .contentType(CONTENT_TYPE_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(CoreMatchers.containsString(shortUrl)));
    }

    @Test
    public void forwardingAnShortUrlToOriginal() throws Exception {
        String key = "12345";
        String longUrl = "http://google.com";
        Mockito.when(service.getUrl(Mockito.anyString())).thenReturn(longUrl);

        mockMvc.perform(get(url + "/" + key)
                .contentType(CONTENT_TYPE_JSON))
                .andExpect(status().isFound());
    }
}