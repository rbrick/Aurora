package me.rbrickis.aurora;

/**
 * Created by Ryan on 3/5/2015
 * <p/>
 * Project: Aurora
 */
public interface HttpClient {

    /*
      This is eventually how i would like this to become. So lets do this :)

       HttpClient client = new HttpClientBuilder()
                              .method(MethodType.POST)
                              .body(
                              // Writes data to the body of the response in a POST request
                              new HttpBodyBuilder()
                              .add("data", "test"))
                              .build()

       HttpResponse response = client.execute();

     */
}
