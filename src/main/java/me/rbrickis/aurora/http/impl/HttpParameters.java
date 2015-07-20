package me.rbrickis.aurora.http.impl;

import java.util.List;

public class HttpParameters {

    private List<HttpParameter> parameters;

    public HttpParameters(List<HttpParameter> parameters) {
        this.parameters = parameters;
    }

    public List<HttpParameter> getParameters() {
        return parameters;
    }

    /**
     * returns an encoded string.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (HttpParameter parameter : parameters) {
            builder.append(parameter.getKey()).append('=').append(parameter.getValue())
                    .append('&');
        }

        String result = builder.toString();

        if (result.endsWith("&")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
