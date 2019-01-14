package com.ab.shortened.service;

import com.ab.shortened.model.UrlEncode;
import com.ab.shortened.model.UrlModel;
import com.ab.shortened.repository.ShortUrlRepository;
import com.ab.shortened.repository.entity.UrlEntity;
import com.ab.shortened.service.handler.Encode;
import com.ab.shortened.service.validator.ValidateUrl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
