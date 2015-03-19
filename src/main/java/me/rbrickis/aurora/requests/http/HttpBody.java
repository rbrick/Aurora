package me.rbrickis.aurora.requests.http;

import me.rbrickis.aurora.requests.Header;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ryan on 3/18/2015
 * <p/>
 * Project: Aurora
 */
public class HttpBody {

    List<Header> headers;
    Map<String, String> content;


    /**
     * The default constructor
     */
    public HttpBody() {
        this(new ArrayList<Header>(), new HashMap<String, String>());
    }


    /**
     * The all arguments constructor
     *
     * @param headers The headers of the body
     * @param content The data written to the body
     */
    public HttpBody(List<Header> headers, Map<String, String> content) {
        this.headers = headers;
        this.content = content;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public Map<String, String> getContent() {
        return content;
    }
}
