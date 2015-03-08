package me.rbrickis.aurora.requests;

/**
 * Created by Ryan on 3/6/2015
 * <p/>
 * Project: Aurora
 *
 * Returned after calling {@method Request#execute}
 */
public class Response {
    String body; // the body of the response
    Header[] headers; // headers of the response
}
