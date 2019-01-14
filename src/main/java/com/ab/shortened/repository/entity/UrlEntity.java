package com.ab.shortened.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "url_table")
public class UrlEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "KEY_CODE", unique = true)
    private String key;

    @Column(name = "SHORT_URL", unique = true)
    private String shortUrl;

    @Column(name = "LONG_URL", unique = true)
    private String longUrl;
}
