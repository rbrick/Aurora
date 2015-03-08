package me.rbrickis.aurora.requests;

import java.util.concurrent.Future;

/**
 * Created by Ryan on 3/6/2015
 * <p/>
 * Project: Aurora
 */
public interface Request {

    /**
     * Executes the Request and returns an {@code Response}
     *
     * @return {@code Future} with a type of {@code Response}
     */
    public Future<Response> execute();

}
