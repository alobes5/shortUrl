package shortened.service.handler;

import org.springframework.stereotype.Component;
import shortened.model.UrlEncode;

import java.time.Instant;

@Component
public class Encode {

    public UrlEncode encodeUrl() {
        String key = Integer.toHexString(Instant.now().getNano());
        String url = "http://localhost:8080/shortUrl/" + key;

        return UrlEncode.builder().key(key).url(url).build();
    }
}
