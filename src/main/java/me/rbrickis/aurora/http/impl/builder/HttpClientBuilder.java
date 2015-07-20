package me.rbrickis.aurora.http.impl.builder;

import me.rbrickis.aurora.http.HttpClient;
import me.rbrickis.aurora.http.RequestType;
import me.rbrickis.aurora.http.impl.AbstractHttpClient;
import me.rbrickis.aurora.http.impl.HttpParameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpClientBuilder {

    private RequestType type;
    private URL url;
    private byte[] data;
    private HttpParameters parameters;
    private String contentType = "application/x-www-form-urlencoded";

    private Map<String, String> requestProperty = new HashMap<>();
    {
        requestProperty.put("Content-Type", contentType);
    }

    public HttpClientBuilder method(RequestType type) {
        this.type = type;
        return this;
    }

    public HttpClientBuilder body(byte[] data) {
        this.data = data;
        return this;
    }

    public HttpClientBuilder parameters(HttpParameterBuilder builder) {
        this.parameters = builder.build();
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

    public HttpClientBuilder contentType(String contentType) {
        this.contentType = contentType;
        requestProperty.put("Content-Type", contentType);
        return this;
    }

    public HttpClientBuilder agent(String agent) {
        requestProperty.put("User-Agent", agent);
        return this;
    }

    public HttpClient build() {
        AbstractHttpClient httpClient = new AbstractHttpClient(url, type, requestProperty, parameters, data);
        httpClient.setContentType(contentType);
        return httpClient;
    }

}
