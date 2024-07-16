package com.test.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@Log4j2
public class UserDTO{
    private Integer no;
    private String id;
    private String name;
    private String password;

}
