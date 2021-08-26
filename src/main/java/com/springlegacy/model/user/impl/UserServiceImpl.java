package com.springlegacy.model.user.impl;

import com.springlegacy.model.user.exception.BlockUserException;
import com.springlegacy.model.user.repository.UserDAO;
import com.springlegacy.model.user.service.UserService;
import com.springlegacy.model.user.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private static Logger Log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public UserVO getUser(UserVO vo) throws BlockUserException {
        if(vo.getId().equals("makengi12")){
            throw new BlockUserException("차단된 사용자");
        }
        Log.info("getUser ServiceImpl()");
        return userDAO.get(vo);
    }
}
