package com.ly975.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.ly975.mapper.UserMapper;
import com.ly975.pojo.Person;
import com.ly975.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class TestController {
    @Autowired
    private Person person;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/test")
    public String test() {
        try {
            System.out.println(System.getProperty("user.dir"));
            System.out.println("start");
            Process process = Runtime.getRuntime().exec("bash ./yj && echo $var");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("mid");
            int i = process.waitFor();
            System.out.println("result: " + i);
            process.destroyForcibly();
            //      ProcessBuilder processBuilder=new ProcessBuilder("bash -c ./hello");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "succss";

    }

    @GetMapping("/hello")
    public String hello() {
        User user=userMapper.selectOne(new QueryWrapper<User>().eq("name","liuyun"));
        return user.getName();
    }

    public static void main(String[] args) {
//        try {
//            Class c = ClassLoader.getSystemClassLoader().loadClass("com.ly975.pojo.Person");
//                    c.newInstance();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }

//        try {
//            Class a=Class.forName("com.ly975.pojo.Person");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        try {
            Person.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
