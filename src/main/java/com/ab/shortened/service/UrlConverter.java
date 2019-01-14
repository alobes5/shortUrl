package com.ab.shortened.service;

import com.ab.shortened.model.UrlEncode;
import com.ab.shortened.repository.entity.UrlEntity;
import org.springframework.stereotype.Component;

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
