package com.test.controller;

import com.test.domain.UserDTO;
import com.test.service.UserService;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Objects;

@Controller
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public void get_index() {
        log.info("login");
    }
    @GetMapping("/admin")
    public void get_second(){
        log.info("admin");
    }
    @GetMapping("/user")
    public void get_user(){
        log.info("user");
    }

    @PostMapping("/index")
    @ResponseBody
    public RedirectView login(@RequestParam String id, @RequestParam String password) {
        UserDTO user = userService.getUserById(id);

        if(Objects.equals(user.getId(), "admin") && Objects.equals(user.getPassword(), "admin")) {
            boolean authenticated = userService.authenticate(id, password);
            if(authenticated) {
                return new RedirectView("/admin");
            } else {
                return new RedirectView("/index");
            }
        }
        else{
            boolean authenticated = userService.authenticate(id, password);
            if(authenticated) {
                return new RedirectView("/user");
            } else {
                return null;
            }
        }
    }

    @PostMapping("/user")
    public void getCount(String id, int count){
        int result = userService.updateLikeCount(id, count);
        int result2 = userService.getLikeCount(id);
        System.out.println(result);
        System.out.println(result2);
    }

//    @GetMapping("/store/{id}")
//    public int getCount(@PathVariable String id){
//        return userService.getLikeCount(id);
//    }
//    @PostMapping("/store/{id}")
//    public int updateCount(@PathVariable String id, int count){
//        return userService.updateLikeCount(id,count);
//    }

}
