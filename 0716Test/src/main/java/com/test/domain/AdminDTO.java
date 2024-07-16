package com.test.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@ToString
@Log4j2
public class AdminDTO {
    private Integer no;
    private String id;
    private String password;
    private Integer count;
}
