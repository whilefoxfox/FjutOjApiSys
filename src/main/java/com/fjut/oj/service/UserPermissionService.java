package com.fjut.oj.service;

import com.fjut.oj.pojo.UserPer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author axiang
 */

public interface UserPermissionService {
    List<UserPer> queryUserPermission(String username);
    boolean queryIsAdmin(String username);
}
