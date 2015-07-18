package me.rbrickis.aurora.http.impl.builder;

import me.rbrickis.aurora.http.HttpResponse;
import me.rbrickis.aurora.http.impl.AbstractHttpResponse;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class HttpResponseBuilder {

    private Map<String, List<String>> headers;
    private InputStream stream;


    public HttpResponseBuilder withHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
        return this;
    }

    public HttpResponseBuilder withInputStream(InputStream stream) {
        this.stream = stream;
        return this;
    }

    public HttpResponse build() {
        return new AbstractHttpResponse(headers, stream);
    }

}
