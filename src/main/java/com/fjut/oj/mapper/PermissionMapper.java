package com.fjut.oj.mapper;

import com.fjut.oj.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    /**
     * 获取用户权限详情
     * @param username
     * @return
     */
    List<Permission> getUserPermission(@Param("username") String username);

    /**
     * 获取用户是否为管理员
     * @param username
     * @return
     */
    boolean getIsAdmin(@Param("username") String username);
}
