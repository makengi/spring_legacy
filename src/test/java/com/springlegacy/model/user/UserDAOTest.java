package com.springlegacy.model.user;

import com.springlegacy.model.user.exception.BlockUserException;
import com.springlegacy.model.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class UserDAOTest {

    private UserService userService;

    @BeforeEach
    public void setUpDataBaseAndSpringApplicationContext(){
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("applicationContext.xml");

        userService = (UserService) container.getBean("userService");

    }

    @Test
    public void 사용자한명을_찾는다() throws BlockUserException {
        String id = "makengi";
        String password = "wldud154";
        UserVO testUser = UserVO.builder().id(id).password(password).build();
        UserVO user = userService.getUser(testUser);
        System.out.println(user.toString());
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getId(),id);
        Assertions.assertEquals(user.getPassword(),password);
    }
}