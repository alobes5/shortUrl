package shortened.service;

import org.apache.logging.log4j.util.Strings;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import shortened.UrlModelMatcher;
import shortened.model.UrlEncode;
import shortened.model.UrlModel;
import shortened.service.handler.Encode;
import shortened.service.validator.ValidateUrl;

import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class ShortUrlServiceTest {

    private ShortUrlService service;

    @Mock
    private ValidateUrl validate;

    @Mock
    Encode encode;

    @Before
    public void setUp() throws Exception {

        service = new ShortUrlService(validate, encode);
    }

    @Test
    public void getShortUrl_validUrl() {
        String longUrl = "http://google.com";
        String shortUrl = "http://localhost:8080/12345";
        UrlModel expected = UrlModel.builder().longUrl(longUrl).shortUrl(shortUrl).build();

        UrlEncode urlEncode = UrlEncode.builder().key("12345").url(shortUrl).build();
        Mockito.when(validate.isAValidUrl(Mockito.anyString())).thenReturn(true);
        Mockito.when(encode.encodeUrl()).thenReturn(urlEncode);

        UrlModel urlModel = service.createShortUrl(longUrl);

        Assert.assertThat(expected, UrlModelMatcher.matcher(urlModel));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getShortUrl_invalidUrl() {
        String longUrl = "xpto://google.com";

        Mockito.when(validate.isAValidUrl(Mockito.anyString())).thenReturn(false);

        service.createShortUrl(longUrl);
    }

    @Test
    public void getUrl_validUrl() {
        String longUrl = "http://google.com";
        String key = "12345";
        String shortUrl = "http://localhost:8080/12345";

        UrlEncode urlEncode = UrlEncode.builder().key(key).url(shortUrl).build();
        Mockito.when(validate.isAValidUrl(Mockito.anyString())).thenReturn(true);
        Mockito.when(encode.encodeUrl()).thenReturn(urlEncode);

        service.createShortUrl(longUrl);
        String url = service.getUrl(key);

        Assert.assertThat(longUrl, is(url));
    }


    @Test
    public void getUrl_invalidKey() {
        String key = "12345";

        String url = service.getUrl(key);

        Assert.assertThat(Strings.EMPTY, is(url));
    }
}