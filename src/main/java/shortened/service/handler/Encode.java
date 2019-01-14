package shortened.service.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import shortened.model.UrlEncode;

import java.time.Instant;

@Component
public class Encode {

    @Value("${ip}")
    private String ip;

    @Value("${server.port}")
    private String port;

    public UrlEncode encodeUrl() {
        String key = Integer.toHexString(Instant.now().getNano());
        String url = "http://" + ip + ":" + port + "/shortUrl/" + key;

        return UrlEncode.builder().key(key).url(url).build();
    }
}
