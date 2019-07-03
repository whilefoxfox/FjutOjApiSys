package com.fjut.oj.service.serviceImpl;

import com.fjut.oj.mapper.PermissionMapper;
import com.fjut.oj.pojo.Permission;
import com.fjut.oj.service.PermissionService;
import com.fjut.oj.enums.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<String> getUserPermission(String username) {
        List<Permission> permissions = permissionMapper.getUserPermission(username);
        List<String> list = new ArrayList<>();
        for (Permission item:permissions){
            PermissionType p =PermissionType.getPerByCode(item.getPerid());
            list.add(p.getName());
        }
        return list;
    }
}
