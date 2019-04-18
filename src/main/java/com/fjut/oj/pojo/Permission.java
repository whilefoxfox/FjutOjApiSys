package com.fjut.oj.pojo;

// 权限表
public class Permission {

    private Integer id;                  // 权限 ID
    private String  name;                // 权限名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
