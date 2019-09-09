package com.example.demo.repository;

import com.example.demo.model.Watch;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by renliang on 2019/9/8.
 */
@Repository
@Mapper
public interface WatchRepository {
    @Select("select * from TBL_WATCH")
    List<Watch> findAll();

    @Select("SELECT * FROM TBL_WATCH WHERE watchNo = #{watchNo}")
    Watch findByWatchNo(@Param("watchNo") String watchNo);

    @Select({"<script>",
            "SELECT *",
            "FROM TBL_WATCH",
            "WHERE watchNo IN",
            "<foreach item='item' index='index' collection='watchNos'",
            "open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</script>"})
    List<Watch> selectWatchesInfoByWatchNos(@Param("watchNos") String[] watchNos);
}
