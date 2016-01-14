package controllers;


import play.mvc.SimpleResult;

import java.io.InputStream;

/**
 * Created by chriswoodrow on 14/01/2016.
 */
public class InputStreamResult extends SimpleResult{
    private final play.api.mvc.SimpleResult wrappedResult;

    public InputStreamResult(InputStream is) {
        this.wrappedResult = play.core.j.JavaResults.Ok().feed(
                play.core.j.JavaResults.chunked(is, 8192),
                play.core.j.JavaResults.writeBytes());
    }

    @Override
    public play.api.mvc.SimpleResult getWrappedSimpleResult() {
        return this.wrappedResult;
    }
}
