package shortened.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
public class UrlModel {

    public String shortUrl;
    public String longUrl;
}
