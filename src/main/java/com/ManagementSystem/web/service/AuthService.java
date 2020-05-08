package com.ManagementSystem.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ManagementSystem.web.entity.AuthEntity;
import com.ManagementSystem.web.mapper.AuthMapper;
/**
 * 権限管理サービスクラス
 */
@Service
@Transactional
public class AuthService {

	/** 権限管理Mapper */
    @Autowired
    private AuthMapper authMapper;

    /** 権限管理Entity */
    private AuthEntity authEntity;
    
    
    /**
     * 権限管理画面初期処理サービス
     * @return menuEntity
     */
    public AuthEntity userInit() {
    	


    	return authEntity;
    }

    /**
     * 権限管理登録処理サービス
     * @return menuEntity
     */
    public void userInsert(AuthEntity menu) {
    	
    	authMapper.insert(menu);
    }
    
    /**
     * 権限管理更新処理サービス
     * @return menuEntity
     */
    public void userUpdate(AuthEntity menu) {
    	
    	authMapper.update(menu);
    }
    
    
}