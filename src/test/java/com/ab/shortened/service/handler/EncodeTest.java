package com.ab.shortened.service.handler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EncodeTest {

    private Encode encode;

    @Before
    public void setUp() throws Exception {
        encode = new Encode();
    }

    @Test
    public void encodeUrl() {
        Assert.assertNotNull(encode.encodeUrl());
    }
}