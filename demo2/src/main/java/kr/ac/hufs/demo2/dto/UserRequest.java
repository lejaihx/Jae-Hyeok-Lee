package kr.ac.hufs.demo2.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private int age;
    private int level;
    

    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", level=" + level +
                '}';
    }
}
