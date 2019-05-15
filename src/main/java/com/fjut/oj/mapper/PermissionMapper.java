package com.fjut.oj.mapper;

import com.fjut.oj.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    public List<Permission> getUserPermission(@Param("username") String username);
}
