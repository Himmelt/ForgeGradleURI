package org.soraworld.gradle.forge;

import org.gradle.api.invocation.Gradle;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;

/**
 * @author Himmelt
 */
public final class GradleURI {

    private static final Method postURIRequest, postURLRequest, postStringRequest;

    static {
        Method method = null;
        try {
            method = Gradle.class.getDeclaredMethod("postURIRequest", URI.class);
            method.setAccessible(true);
        } catch (Throwable ignored) {
        }
        postURIRequest = method;
        method = null;
        try {
            method = Gradle.class.getDeclaredMethod("postURLRequest", URL.class);
            method.setAccessible(true);
        } catch (Throwable ignored) {
        }
        postURLRequest = method;
        method = null;
        try {
            method = Gradle.class.getDeclaredMethod("postURIRequest", String.class);
            method.setAccessible(true);
        } catch (Throwable ignored) {
        }
        postStringRequest = method;
    }

    public static URI postURIRequest(URI originURI) {
        try {
            return (URI) postURIRequest.invoke(null, originURI);
        } catch (Throwable ignored) {
            return originURI;
        }
    }

    public static URL postURLRequest(URL originURL) {
        try {
            return (URL) postURLRequest.invoke(null, originURL);
        } catch (Throwable ignored) {
            return originURL;
        }
    }

    public static String postURIRequest(String originURI) {
        try {
            return (String) postStringRequest.invoke(null, originURI);
        } catch (Throwable ignored) {
            return originURI;
        }
    }
}
