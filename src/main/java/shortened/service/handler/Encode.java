package shortened.service.handler;

import shortened.model.UrlEncode;

import java.time.Instant;

public class Encode {

    public UrlEncode encodeUrl() {
        String key = Integer.toHexString(Instant.now().getNano());
        String url = "http://localhost:8080/shortUrl/" + key;

        return UrlEncode.builder().key(key).url(url).build();
    }
}
