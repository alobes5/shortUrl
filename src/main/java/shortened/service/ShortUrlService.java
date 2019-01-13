package shortened.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shortened.model.UrlEncode;
import shortened.model.UrlModel;
import shortened.service.handler.Encode;
import shortened.service.validator.ValidateUrl;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShortUrlService {

    private final Map<String, String> tinyUrls;
    private final ValidateUrl validate;
    private final Encode encode;

    @Autowired
    public ShortUrlService(ValidateUrl validate, Encode encode) {
        this.validate = validate;
        this.encode = encode;
        tinyUrls = new HashMap<>();
    }

    public UrlModel createShortUrl(String longUrl) {
        if (validate.isAValidUrl(longUrl)) {
            UrlEncode urlEncode = encode.encodeUrl();
            tinyUrls.put(urlEncode.getKey(), longUrl);

            return UrlModel.builder()
                    .shortUrl(urlEncode.getUrl())
                    .longUrl(longUrl)
                    .build();
        }
        throw new IllegalArgumentException();
    }

    public String getUrl(String urlId) {
        return (tinyUrls.get(urlId) == null ? Strings.EMPTY : tinyUrls.get(urlId));
    }
}
