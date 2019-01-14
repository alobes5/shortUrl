package com.ab.shortened.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UrlModel {

    @JsonProperty
    public String shortUrl;

    @JsonProperty
    public String longUrl;
}
