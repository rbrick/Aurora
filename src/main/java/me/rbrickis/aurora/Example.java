package me.rbrickis.aurora;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import me.rbrickis.aurora.http.HttpClient;
import me.rbrickis.aurora.http.HttpResponse;
import me.rbrickis.aurora.http.RequestType;
import me.rbrickis.aurora.http.impl.builder.HttpClientBuilder;

public class Example {

    public static void main(String... args) {
        JsonObject object = new Gson().fromJson(getPlayerProfile("rbrick"), JsonObject.class);
        System.out.println("Name: " + object.get("name").getAsString());
        System.out.println("UUID: " + object.get("id").getAsString());
    }


    public static String getPlayerProfile(String name) {
        HttpClient client = new HttpClientBuilder()
                .url("https://api.mojang.com/users/profiles/minecraft/" + name)
                .method(RequestType.GET)
                .agent("Aurora HttpClient v0.1").build();
        HttpResponse response = client.execute();
        return response.asString();
    }

}
