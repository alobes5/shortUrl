package shortened.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UrlEncode {
    String key;
    String url;
}
