package me.rbrickis.aurora.http;

import me.rbrickis.aurora.utils.Callback;

import java.util.concurrent.Future;

/**
 * Created by Ryan on 3/5/2015
 * <p/>
 * Project: Aurora
 */
public interface HttpClient {

    /*
      This is eventually how i would like this to become. So lets do this :)

       HttpClient client = new HttpClientBuilder()
                              .method(RequestType.POST)
                              .url("mojang.com")
                              .body(
                              // Writes data to the body of the response in a POST request
                              new HttpBodyBuilder()
                              .add("data", "test").build())
                              .build()

       HttpResponse response = client.execute();

       response.asString()
       response.asBytes();
       response.asInputStream();
       response.getHeaders().forEach(k, v -> System.out.println("{k} - {v}"));
     */

    HttpResponse execute();

    HttpResponse execute(Callback<Future<HttpResponse>> callback);

}
