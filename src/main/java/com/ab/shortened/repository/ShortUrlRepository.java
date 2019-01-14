package com.ab.shortened.repository;

import com.ab.shortened.repository.entity.UrlEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepository extends PagingAndSortingRepository<UrlEntity, Long> {

    public UrlEntity findByKey(String key);

}
