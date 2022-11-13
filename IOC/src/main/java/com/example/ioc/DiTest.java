package com.example.ioc;

import org.springframework.context.ApplicationContext;

public class DiTest {
    public static void main(String[] args) {
        ApplicationContext context = ApplicationContextProvider.getContext();

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        //Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        //UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        //Encoder encoder = context.getBean(Encoder.class);
        Encoder encoder = context.getBean("urlEncode", Encoder.class);
        String result = encoder.encode(url);
        System.out.println(result);
    }
}
