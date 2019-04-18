package com.fjut.oj.service.serviceImpl;

import com.fjut.oj.mapper.StatusMapper;
import com.fjut.oj.service.StatusService;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("statusService")
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public Integer querySubmitCountByUsername(String name) {
        Integer num = statusMapper.querySubmitCountByUsername(name);
        return num;
    }
}
