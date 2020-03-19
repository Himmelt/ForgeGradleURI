package org.gradle.api.invocation;

import groovy.lang.Closure;
import org.gradle.StartParameter;
import org.gradle.api.Action;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * @author Himmelt
 */
public interface Gradle {

    StartParameter getStartParameter();

    File getGradleUserHomeDir();

    void projectsEvaluated(Closure closure);

    void projectsEvaluated(Action<? super Gradle> action);

    static URI postURIRequest(URI originURI) {
        String origin = originURI.toString();
        String target = postURIRequest(origin);
        return target.equals(origin) ? originURI : URI.create(target);
    }

    static URL postURLRequest(URL originURL) throws MalformedURLException {
        String origin = originURL.toString();
        String target = postURIRequest(origin);
        return target.equals(origin) ? originURL : new URL(target);
    }

    static String postURIRequest(String originURI) {
        return originURI;
    }
}
