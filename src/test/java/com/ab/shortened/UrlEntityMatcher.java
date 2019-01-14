package com.ab.shortened;

import com.ab.shortened.repository.entity.UrlEntity;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

public class UrlEntityMatcher extends TypeSafeMatcher<UrlEntity> {

    private final UrlEntity entity;

    private UrlEntityMatcher(UrlEntity entity) {
        this.entity = entity;
    }

    @Override
    public boolean matchesSafely(UrlEntity urlEntity) {
        if (urlEntity.getShortUrl().equalsIgnoreCase(entity.getShortUrl())
                && urlEntity.getLongUrl().equalsIgnoreCase(entity.getLongUrl())
                && urlEntity.getKey().equalsIgnoreCase(entity.getKey())) {
            return true;
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(entity);
    }

    @Factory
    public static UrlEntityMatcher matcher(UrlEntity entity) {
        return new UrlEntityMatcher(entity);
    }
}
