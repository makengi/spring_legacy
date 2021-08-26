package com.springlegacy.model.user.service;

import com.springlegacy.model.user.UserVO;
import com.springlegacy.model.user.exception.BlockUserException;
import org.h2.engine.User;

public interface UserService {
    public UserVO getUser(UserVO vo) throws BlockUserException;
}
