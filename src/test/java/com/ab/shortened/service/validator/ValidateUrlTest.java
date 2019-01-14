package com.ab.shortened.service.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidateUrlTest {

    private ValidateUrl validate;

    @Before
    public void setUp() throws Exception {
        validate = new ValidateUrl();
    }

    @Test
    public void isAValidUrl_validUrlHttp() {
        Assert.assertTrue(validate.isAValidUrl("http://google.com"));
    }

    @Test
    public void isAValidUrl_validUrlHttps() {
        Assert.assertTrue(validate.isAValidUrl("https://scholar.google.com.br/schhp?hl=en"));
    }

    @Test
    public void isAValidUrl_invalidUrl() {
        Assert.assertFalse(validate.isAValidUrl("google.com"));
    }

    @Test
    public void isAValidUrl_invalidProtocol() {
        Assert.assertFalse(validate.isAValidUrl("xpto://google.com"));
    }
}