package com.ab.shortened.service;

import com.ab.shortened.model.UrlEncode;
import org.springframework.stereotype.Component;
import com.ab.shortened.repository.entity.UrlEntity;

@Component
public class UrlConverter {

    public UrlEntity toEntity(UrlEncode urlEncode, String longUrl) {
        UrlEntity entity = new UrlEntity();

        entity.setKey(urlEncode.getKey());
        entity.setLongUrl(longUrl);
        entity.setShortUrl(urlEncode.getUrl());

        return entity;
    }
}
