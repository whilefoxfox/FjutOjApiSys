package com.fjut.oj.mapper;

import com.fjut.oj.pojo.SubmisssionRecord;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface SubmissionRecordMapper {

    List<SubmisssionRecord> getAreaSubmissionRecord(@Param("from") Timestamp from, @Param("to") Timestamp to);

    List<SubmisssionRecord> getFailAreaSubmissionRecord(@Param("from") Timestamp from, @Param("to") Timestamp to);
}
