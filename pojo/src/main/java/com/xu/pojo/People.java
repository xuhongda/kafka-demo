package com.xu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xuhongda on 2019/3/27
 * pojo
 * kafka-demo
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class People implements Serializable {

    private Integer age;

    private String name;
}
