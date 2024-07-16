package com.test.mapper;

import com.test.domain.UserDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;


@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    UserDTO selectUserById(String id);

    int getLikeCount(@Param("id") String id);
    int updateLikeCount(@Param("id") String id, @Param("count") int count);

}
