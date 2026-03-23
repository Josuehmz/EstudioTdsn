package com.example.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

public class HttpRemoteCaller {
    public static String fetch (String url) throws IOException{
        HttpURLConnection con = (HttpURLConnection) URI.create(url).toURL().openConnection();
        con.setConnectTimeout(3000);
        con.setReadTimeout(3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        StringBuilder res = new StringBuilder();
        while ((line = in.readLine()) != null){
            res.append(line);
        }
        in.close();
        return res.toString();
 }
}