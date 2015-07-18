package me.rbrickis.aurora.http.impl;

import me.rbrickis.aurora.http.HttpResponse;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class AbstractHttpResponse implements HttpResponse {

    private InputStream stream;
    private Map<String, List<String>> headers;

    public AbstractHttpResponse(Map<String, List<String>> headers, InputStream stream) {
        this.stream = stream;
        this.headers = headers;
    }


    /**
     * @return The response as a {@code String}
     */
    @Override
    public String asString() {
        return new String(asByteArray(), StandardCharsets.UTF_8);
    }

    /**
     * @return The response as a {@code byte[]}
     */
    @Override
    public byte[] asByteArray() {
        try {
            byte[] bastream = new byte[stream.available()];
            DataInputStream disstream = new DataInputStream(stream);
            disstream.readFully(bastream);
            return bastream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /**
     * @return The headers of the response
     */
    @Override
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    @Override
    public InputStream getInputStream() {
        return stream;
    }
}
