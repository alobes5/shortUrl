package shortened.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UrlModel {

    public String shortUrl;
    public String longUrl;
}
