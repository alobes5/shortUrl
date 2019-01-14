package com.ab.shortened.service;

import com.ab.shortened.UrlEntityMatcher;
import com.ab.shortened.model.UrlEncode;
import com.ab.shortened.repository.entity.UrlEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UrlConverterTest {

    private UrlConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new UrlConverter();
    }

    @Test
    public void toEntity_validInput() {
        String longUrl = "http://google.com";
        String key = "12345";
        String shortUrl = "http://localhost:8080/12345";
        UrlEncode urlEncode = UrlEncode.builder().key(key).url(shortUrl).build();
        UrlEntity expected = new UrlEntity();

        expected.setShortUrl(shortUrl);
        expected.setLongUrl(longUrl);
        expected.setKey(key);

        UrlEntity entity = converter.toEntity(urlEncode, longUrl);

        Assert.assertThat(expected, UrlEntityMatcher.matcher(entity));
    }
}