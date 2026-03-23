package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MathController{
    @GetMapping("/api/sum")
    public String sum (@RequestParam ("a")int a, @RequestParam ("b") int b){
        return "" + (a+b);
    }
    @GetMapping("/api/multiply")
    public String multiply (@RequestParam ("a") int a, @RequestParam("b") int b){
        return ""+ (a*b);
    }
    @GetMapping("/api/sub")
    public String sub (@RequestParam ("a")int a, @RequestParam("b")int b){
        return "" + (a-b);
    }
    @GetMapping("/api/divide")
    public String divide (@RequestParam ("a") int a, @RequestParam("b") int b){
        if (b==0){
            return "Error: No se puede dividir por 0";
        } else{
            return "" + (a/b);
        }
    } 
}