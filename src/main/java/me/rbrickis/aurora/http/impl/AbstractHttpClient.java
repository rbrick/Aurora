package me.rbrickis.aurora.http.impl;

import lombok.SneakyThrows;
import me.rbrickis.aurora.http.HttpClient;
import me.rbrickis.aurora.http.HttpResponse;
import me.rbrickis.aurora.http.RequestType;
import me.rbrickis.aurora.http.impl.builder.HttpResponseBuilder;
import me.rbrickis.aurora.utils.Callback;

import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class AbstractHttpClient implements HttpClient {

    private URL url;
    private RequestType type;
    private Map<String, String> requestProperties;
    private byte[] body;
    private HttpParameters parameters;
    private String contentType;

    public AbstractHttpClient(URL url, RequestType type, Map<String, String> requestProperties, HttpParameters parameters, byte[] body) {
        this.url = url;
        this.type = type;
        this.requestProperties = requestProperties;
        this.body = body;
        this.parameters = parameters;
    }

    private FutureTask<HttpResponse> call() {
        Callable<HttpResponse> caller = () -> {
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(type.name());
            connection.setDoOutput(type == RequestType.POST);
            requestProperties.forEach(connection::addRequestProperty);

            if (connection.getDoOutput()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                // write to the body
                if (contentType.equalsIgnoreCase("application/x-www-form-urlencoded")) {
                     baos.write(parameters.toString().getBytes());
                } else {
                    baos.write(body);
                }
                baos.writeTo(connection.getOutputStream());
                connection.getOutputStream().flush();
            }
            return new HttpResponseBuilder()
                    .withHeaders(connection.getHeaderFields())
                    .withInputStream(connection.getInputStream())
                    .build();
        };
        return new FutureTask<>(caller);
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public HttpResponse execute() {
        return execute((result) -> {
            if (result == null) {
                throw new IllegalArgumentException("Request failed!");
            }
            return result;
        });
    }

    @SneakyThrows
    public HttpResponse execute(Callback<Future<HttpResponse>> callback) {
        FutureTask<HttpResponse> response = call();
        response.run();
        return callback.call(response).get();
    }
}
