package com.ab.shortened.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.ab.shortened.repository.entity.UrlEntity;

@Repository
public interface ShortUrlRepository extends PagingAndSortingRepository<UrlEntity, Long> {

    public UrlEntity findByKey(String key);

}
