package com.ab.shortened.controller;

import com.ab.shortened.model.UrlModel;
import com.ab.shortened.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ShortenedUrlController {

    private final ShortUrlService service;

    @Autowired
    public ShortenedUrlController(final ShortUrlService service) {
        this.service = service;
    }

    @PostMapping("/shortUrl")
    @ResponseBody
    public UrlModel createAnShortUrl(@RequestBody final UrlModel model) {
        return service.createShortUrl(model.getLongUrl());
    }

    @GetMapping("/shortUrl/{id}")
    @ResponseBody
    public void forwardingAnShortUrlToOriginal(@PathVariable String id, HttpServletResponse resp) throws IOException {
        String originalUrl = service.getLongUrl(id);
        resp.sendRedirect(originalUrl);
    }
}
