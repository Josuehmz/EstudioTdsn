package com.example.demo;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProxyController {
    private String activeServer;
    private String passiveServer;
    public ProxyController(){
        String s1 = System.getenv("SERVER1");
        String s2 = System.getenv("SERVER2");
        activeServer = (s1 != null) ? s1 : "http://localhost:8081";
        passiveServer = (s2 != null) ? s2 : "http://localhost:8082";
    }
    @GetMapping("/proxy/sum")
    public String sum (@RequestParam ("a") int a, @RequestParam ("b") int b){
        return delegate("/proxy/sum?a=" + a + "&b=" + b);
    }
    private String delegate(String path){
        try {
            return HttpRemoteCaller.fetch(activeServer + path);
        } catch (IOException e){
            try {
                String res = HttpRemoteCaller.fetch(passiveServer + path);
                String tmp = activeServer;
                activeServer = passiveServer;
                passiveServer = tmp;
                return res;
            } catch (IOException ex){
                return "Error: ambos servicios caidos";
        }
     }
  }
}