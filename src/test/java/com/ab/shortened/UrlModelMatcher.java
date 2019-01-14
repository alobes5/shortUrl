package com.ab.shortened;

import com.ab.shortened.model.UrlModel;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

public class UrlModelMatcher extends TypeSafeMatcher<UrlModel> {

    private final UrlModel model;

    private UrlModelMatcher(UrlModel model) {
        this.model = model;
    }

    @Override
    public boolean matchesSafely(UrlModel urlModel) {
        if (urlModel.getShortUrl().equalsIgnoreCase(model.getShortUrl())
                && urlModel.getLongUrl().equalsIgnoreCase(model.getLongUrl())) {
            return true;
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(model);
    }

    @Factory
    public static UrlModelMatcher matcher(UrlModel model) {
        return new UrlModelMatcher(model);
    }
}
