package me.rbrickis.aurora;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import me.rbrickis.aurora.http.HttpClient;
import me.rbrickis.aurora.http.HttpResponse;
import me.rbrickis.aurora.http.RequestType;
import me.rbrickis.aurora.http.impl.builder.HttpClientBuilder;
import me.rbrickis.aurora.http.impl.builder.HttpParameterBuilder;
import org.json.simple.JSONArray;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

public class Example {

    @SneakyThrows
    public static void main(String... args) {
        JsonObject object1 = uploadImage(new File("blazedswordsman.jpg"),"REDACTED");
        System.out.println("Your image has been uploaded at " + object1.get("data").getAsJsonObject().get("link").getAsString());
    }

    // Uploads image to imgur
    //https://api.imgur.com/3/upload.json
    @SneakyThrows
    public static JsonObject uploadImage(File file, String client_id) {
        FileInputStream stream = new FileInputStream(file);
        byte[] bastream = new byte[stream.available()];
        DataInputStream disstream = new DataInputStream(stream);
        disstream.readFully(bastream);

        String base64 = Base64.getEncoder().encodeToString(bastream);

        HttpClient client = new HttpClientBuilder()
                .url("https://api.imgur.com/3/upload")
                .agent("Aurora HttpClient v0.1")
                .property("Authorization", "Client-ID " + client_id)
                .parameters(new HttpParameterBuilder()
                        .addParameter("image", base64)
                        .addParameter("client_id", client_id)
                        .addParameter("type", "base64")
                        .addParameter("title", "Blazed swordsman mofo")
                        .addParameter("description", "I was bored. also this is uploaded with my http client!"))
                .method(RequestType.POST)
                .build();
        HttpResponse response = client.execute();
        return new Gson().fromJson(response.asString(), JsonObject.class);
    }


    public static String authorize(String client_id) {
        return "";
    }


    public static String getPlayerProfile(String name) {
        JSONArray array = new JSONArray();
        array.add(name);

        HttpClient client = new HttpClientBuilder()
                .url("https://api.mojang.com/profiles/minecraft")
                .method(RequestType.POST)
                .body(array.toJSONString().getBytes())
                .contentType("application/json")
                .agent("Aurora HttpClient v0.1").build();
        HttpResponse response = client.execute();
        return response.asString();
    }

}
