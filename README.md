# Aurora
An asynchronous, easy to use, HTTP client 

```java 
 HttpClient client = new HttpClientBuilder()
                .url("https://api.mojang.com/users/profiles/minecraft/" + name)
                .method(RequestType.GET)
                .agent("Aurora HttpClient v0.1").build();
 HttpResponse response = client.execute();
 
 InputStream stream = response.getInputStream();
 byte[] responseBytes = response.asByteArray();
 String responseString = response.asString();
 Map<String, List<String>> headers = response.getHeaders();
```
