package com.ly975.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {

    @TableField(value = "name")
    public String name;
}
