package shortened.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import shortened.model.UrlModel;

@Controller
public class ShortenedUrlController {

    @PostMapping("/shortUrl")
    @ResponseBody
    public UrlModel createAnShortUrl(){
        return UrlModel.builder().longUrl("test long").shortUrl("test shrot").build();
    }

    @GetMapping("/shortUrl")
    @ResponseBody
    public UrlModel forwardingAnShortUrlToOriginal(){
        return UrlModel.builder().longUrl("test long f").shortUrl("test shrot f").build();
    }
}
