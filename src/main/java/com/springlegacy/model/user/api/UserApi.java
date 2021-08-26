package com.springlegacy.model.user.api;

import com.springlegacy.model.user.UserVO;
import com.springlegacy.model.user.exception.BlockUserException;
import com.springlegacy.model.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserApi {

    private UserService userService;

    @Autowired
    public UserApi(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public UserVO getOne(UserVO vo) throws BlockUserException {
        return userService.getUser(vo);
    }
}
