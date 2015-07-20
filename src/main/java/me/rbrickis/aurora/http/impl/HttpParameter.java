package me.rbrickis.aurora.http.impl;

public class HttpParameter {

    private String key, value;

    public HttpParameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
