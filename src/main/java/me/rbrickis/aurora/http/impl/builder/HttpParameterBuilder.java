package me.rbrickis.aurora.http.impl.builder;

import me.rbrickis.aurora.http.impl.HttpParameter;
import me.rbrickis.aurora.http.impl.HttpParameters;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HttpParameterBuilder {

    private List<HttpParameter> parameters = new ArrayList<>();

    /**
     * Adds a parameter to the request
     */
    public HttpParameterBuilder addParameter(String key, String value) {
        try {
            parameters.add(new HttpParameter(key, URLEncoder.encode(value, StandardCharsets.UTF_8.displayName())));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this;
    }

    public HttpParameters build() {
        return new HttpParameters(parameters);
    }


}
