package com.fjut.oj.service;

import java.util.List;

public interface PermissionService {
    public List<String> getUserPermission(String username);
    boolean getIsAdmin(String username);
}
