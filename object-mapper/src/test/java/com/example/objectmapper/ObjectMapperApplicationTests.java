package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("-".repeat(10));

        //Text JSON -> Object
        //Object -> Text JSON

        //controller req json(text) -> object
        //response object -> json(text)

        var objectMapper = new ObjectMapper();

        //object -> text
        //objectMapper가 get method 활용한다.
        var user = new User("steve", 10, "010-1111-2222");

        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        //text -> object
        //objectMapper가 기본 생성자를 필요로한다.
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

}
