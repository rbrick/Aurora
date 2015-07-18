package me.rbrickis.aurora.http.impl.builder;

import me.rbrickis.aurora.http.HttpClient;
import me.rbrickis.aurora.http.RequestType;
import me.rbrickis.aurora.http.impl.AbstractHttpClient;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpClientBuilder {

    private RequestType type;
    private URL url;

    private Map<String, String> requestProperty = new HashMap<>();

    public HttpClientBuilder method(RequestType type) {
        this.type = type;
        return this;
    }

    public HttpClientBuilder url(String string) {
        try {
            this.url = new URI(string).toURL();
        } catch (MalformedURLException | URISyntaxException e) {/* Ignored */}
        return this;
    }

    public HttpClientBuilder property(String key, String value) {
        requestProperty.put(key, value);
        return this;
    }

    public HttpClientBuilder agent(String agent) {
        requestProperty.put("User-Agent", agent);
        return this;
    }

    public HttpClient build() {
        return new AbstractHttpClient(url, type, requestProperty, new byte[0]);
    }

}
