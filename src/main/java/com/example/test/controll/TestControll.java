package com.example.test.controll;

import com.example.test.entity.Person;
import com.example.test.entity.ResMap;
import com.example.test.service.TestService;
import com.example.test.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/con")
public class TestControll {
    @Autowired
    private TestService testService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/list")
    @ResponseBody
    public ResMap getDataList(Model model, HttpServletRequest request,
                              HttpServletResponse response){

        //System.out.println("==redis=="+ redisUtil.get("key"));
        List<Person> list = (List<Person>) redisUtil.get("list") ;
        if(null == list){
            System.out.println("==redis==为空");
            list = testService.getDataList();
            redisUtil.set("list",list);
        }
        ResMap resMap = new ResMap();
        resMap.setCode(200);
        resMap.setData(list);
        resMap.setCount(list.size());
        return resMap;
    }

    @RequestMapping("/index")
    public String getDataList2(Model model){
//        redisUtil.set("key","redistest");
//        System.out.println("index");
        return "index";
    }

    @RequestMapping("/selectByPersonId")
    @ResponseBody
    public ResMap selectByPersonId(String id){
        id="1";
        Person person = testService.selectByPersonId(id);
        ResMap resMap = new ResMap();
        resMap.setCode(200);
        resMap.setData(person);
        return resMap;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResMap update(Person person){
        testService.update(person);
        redisUtil.remove("list");
        ResMap resMap = new ResMap();
        resMap.setCode(200);
        return resMap;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResMap insert(Person person){
        testService.insert(person);
        redisUtil.remove("list");
        ResMap resMap = new ResMap();
        resMap.setCode(200);
        return resMap;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResMap delete(Person person){
        testService.delete(person);
        redisUtil.remove("list");
        ResMap resMap = new ResMap();
        resMap.setCode(200);
        return resMap;
    }


}
