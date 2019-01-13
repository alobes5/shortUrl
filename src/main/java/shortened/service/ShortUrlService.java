package shortened.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shortened.model.UrlEncode;
import shortened.model.UrlModel;
import shortened.repository.ShortUrlRepository;
import shortened.repository.entity.UrlEntity;
import shortened.service.handler.Encode;
import shortened.service.validator.ValidateUrl;

@Service
public class ShortUrlService {

    private final ValidateUrl validate;
    private final ShortUrlRepository repository;
    private final Encode encode;
    private final UrlConverter converter;

    @Autowired
    public ShortUrlService(ValidateUrl validate, ShortUrlRepository repository, Encode encode, UrlConverter converter) {
        this.validate = validate;
        this.repository = repository;
        this.encode = encode;
        this.converter = converter;
    }

    public UrlModel createShortUrl(String longUrl) {
        if (validate.isAValidUrl(longUrl)) {
            UrlEncode urlEncode = encode.encodeUrl();
            repository.save(converter.toEntity(urlEncode, longUrl));

            return UrlModel.builder()
                    .shortUrl(urlEncode.getUrl())
                    .longUrl(longUrl)
                    .build();
        }
        throw new IllegalArgumentException();
    }

    public String getLongUrl(String key) {
        UrlEntity entity = repository.findByKey(key);
        return (entity == null ? Strings.EMPTY : entity.getLongUrl());
    }
}
