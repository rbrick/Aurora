package me.rbrickis.aurora.http;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface HttpResponse {

    /**
     * @return The response as a {@code String}
     */
    String asString();


    /**
     * @return The response as a {@code byte[]}
     */
    byte[] asByteArray();


    /**
     * @return The headers of the response
     */
    Map<String, List<String>> getHeaders();


    InputStream getInputStream();
}
