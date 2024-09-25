package com.zero.spring.annotaions;

import com.zero.spring.annotaions.common.annotations.RequestTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ZeroSpringAnnotationsApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(showHelloWorld());
    }

    @RequestTime
    public Map<String, Object> showHelloWorld(){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "HelloWorld");
        return map;
    }

}
