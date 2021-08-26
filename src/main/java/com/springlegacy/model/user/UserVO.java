package com.springlegacy.model.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.h2.engine.User;

@Getter
@Setter
@ToString
public class UserVO {
    private String id;
    private String password;
    private String name;
    private String role;

    @Builder
    public UserVO(String id, String password, String name,String role){
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
    }
}
