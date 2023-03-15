package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import jakarta.servlet.annotation.HttpMethodConstraint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";

        return html;
    }

    @GetMapping("/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(@PathVariable("message") String msg,
                       @PathVariable int age,
                       @PathVariable boolean isMan){
        System.out.println("echo message: " + msg);
        System.out.println("echo age: " + age);
        System.out.println("echo isMan: " + isMan);

        return msg.toUpperCase();
    }

    @GetMapping("/book")
    public void queryParam(@RequestParam String category,
                           @RequestParam String issuedYear,
                           @RequestParam("issued-month") String issuedMonth,
                           @RequestParam("isuued_day") String issuedDay){
        System.out.println("category = " + category);
        System.out.println("issuedYear = " + issuedYear);
        System.out.println("issuedMonth = " + issuedMonth);
        System.out.println("issuedDay = " + issuedDay);
    }

    @GetMapping("/book2")
    public void queryParamDto(BookQueryParam bookQueryParam){
        System.out.println("bookQueryParam = " + bookQueryParam);
    }

    @GetMapping("/plus")
    public int queryParamPlus(@RequestParam int first, @RequestParam int second){
        return first + second;
    }

    @GetMapping("/mul")
    public int queryParamMul(@RequestParam int first, @RequestParam int second){
        return first * second;
    }

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"})
    public void delete(@PathVariable String userName){
        log.info("user-name : {}", userName);
    }
}
