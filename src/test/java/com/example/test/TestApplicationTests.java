package com.example.test;

import com.example.test.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void contextLoads() {
        Integer i = 7000;
        while (i<8000){
            redisUtil.set(i.toString(),i);
            System.out.println(i);
            i++;
        }
//        System.out.println(redisUtil.get("1228"));
    }


}
