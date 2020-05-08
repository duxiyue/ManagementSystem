package com.ManagementSystem.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.transaction.annotation.Transactional;

import com.ManagementSystem.framework.security.dto.LoginUserDto;
import com.ManagementSystem.web.entity.UserEntity;
import com.ManagementSystem.web.mapper.UserMapper;
/**
 * パースワード変更サービスクラス
 */
@Service
@Transactional
public class PasswordEditService {

	/** ユーザーMapper */
    @Autowired
    private UserMapper userMapper;

	/** ログインユーザーDto */
    @Autowired
    private LoginUserDto loginUserDto;

    /**
     * パースワード更新処理サービス
     * @return userEntity
     */
    public boolean passwordUpdate(String password) {
    	
    	try {

        	UserEntity userEntity = userMapper.getByUserCode(loginUserDto.getUserCode());

        	BCryptPasswordEncoder encode = new BCryptPasswordEncoder();  
        	userEntity.password = encode.encode(password); 

        	userMapper.update(userEntity);

    	} catch (TransactionTimedOutException e) {
    		throw new TransactionTimedOutException("");
    	}

    	return true;
    }
}