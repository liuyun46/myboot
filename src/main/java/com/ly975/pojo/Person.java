package com.ly975.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
@Data
@PropertySource(value = "classpath:user.properties")
public class Person {

    @Value("${person.name}")
    public String name;
    @Value("${person.age}")
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    static {
        System.out.println("这是静态代码块");
    }

    public static void main(String[] args) {
        try {
            Class aClass=Person.class.getClassLoader().loadClass("Person");
            aClass.getMethods();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("user.properties");
        byte[] bytes = new byte[1024];
        try {
            inputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Scheduled(fixedRate = 1000)
    public void test(){
        System.out.println("定时任务");
    }
}
