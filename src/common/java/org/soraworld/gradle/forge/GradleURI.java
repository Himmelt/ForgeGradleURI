package org.soraworld.gradle.forge;

import org.gradle.api.invocation.Gradle;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.util.function.Function;

/**
 * @author Himmelt
 */
public final class GradleURI {

    private static final Function<URL, URL> postURLRequest;
    private static final Function<URI, URI> postURIRequest;
    private static final Function<String, String> postRequest;

    static {
        Function function = null;
        try {
            Field field = Gradle.class.getDeclaredField("postRequest");
            field.setAccessible(true);
            function = (Function) field.get(Gradle.class);
        } catch (Throwable ignored) {
        }
        postRequest = function;
        function = null;
        try {
            Field field = Gradle.class.getDeclaredField("postURIRequest");
            field.setAccessible(true);
            function = (Function) field.get(Gradle.class);
        } catch (Throwable ignored) {
        }
        postURIRequest = function;
        function = null;
        try {
            Field field = Gradle.class.getDeclaredField("postURLRequest");
            field.setAccessible(true);
            function = (Function) field.get(Gradle.class);
        } catch (Throwable ignored) {
        }
        postURLRequest = function;
    }

    public static String postRequest(String origin) {
        return postRequest == null ? origin : postRequest.apply(origin);
    }

    public static URI postURIRequest(URI originURI) {
        return postURIRequest == null ? originURI : postURIRequest.apply(originURI);
    }

    public static URL postURLRequest(URL originURL) {
        return postURLRequest == null ? originURL : postURLRequest.apply(originURL);
    }
}
