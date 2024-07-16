package com.test.service;

import com.test.domain.UserDTO;
import com.test.mapper.Mapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {
    @Autowired
    private Mapper mapper;
    public boolean authenticate(String id, String password) {
        UserDTO user = mapper.selectUserById(id);
        System.out.println("유저의 아이디 : " + user.getId());
        System.out.println("유저의 패스워드 : " + user.getPassword());

        System.out.println("String password : " + password);
        if(!user.getPassword().equals(password)) {
            return false;
        }
        return user != null && user.getPassword().equals(password);
    }
    public UserDTO getUserById(String id) {
        return mapper.selectUserById(id);
    }

    public int getLikeCount(String id){
        return mapper.getLikeCount(id);
    }
    public int updateLikeCount(String id, int count){
        return mapper.updateLikeCount(id, count);
    }

}
