package com.ManagementSystem.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.ManagementSystem.framework.security.dto.LoginUserDto;
import com.ManagementSystem.web.entity.UserEntity;
import com.ManagementSystem.web.form.UserForm;
import com.ManagementSystem.web.mapper.UserMapper;
import com.ManagementSystem.web.util.CommonCode;
/**
 * ユーザーサービスクラス
 */
@Service
@Transactional
public class UserService {

	/** ユーザーMapper */
    @Autowired
    private UserMapper userMapper;

	/** ログインユーザーDto */
    @Autowired
    private LoginUserDto loginUserDto;

    /**
     * ユーザー画面初期処理サービス
     * @return userEntity
     */
    public UserForm userListInit() {

    	UserForm userForm = new UserForm();

    	if (CommonCode.AUTH_CODE == loginUserDto.getUserAuth()) {
    		userForm.userEntityList = userMapper.getAll();
    	}

    	userForm.userEntity = new UserEntity();
    	userForm.userEntity.userCode = loginUserDto.getUserCode(); // ユーザコード
    	userForm.userEntity.userName = loginUserDto.getUserName(); // ユーザ名
    	userForm.userEntity.userAuth = loginUserDto.getUserAuth(); // 権限
    	userForm.userEntity.authComment = loginUserDto.getAuthComment(); // 権限名

    	return userForm;
    }

    /**
     * ユーザー編集画面初期処理サービス
     * @param userCode
     * @return userEntity
     */
    public UserForm userEditInit(String userCode) {

    	UserForm userForm = new UserForm();

    	if (StringUtils.isEmpty(userCode)) {
    		userForm.userEntity = new UserEntity();
    	} else {
    		userForm.userEntity = userMapper.getByUserCode(userCode);
    	}
    	return userForm;
    }

    /**
     * ユーザー登録処理サービス
     * @return userEntity
     */
    public boolean userRegist(UserForm userForm) {
    	try {

    		// ユーザ情報取得
        	UserEntity userEntity = userMapper.getByUserCode(userForm.getUserEntity().getUserCode());

        	// ユーザパースワード設定
        	BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        	userForm.getUserEntity().setPassword(encode.encode(userForm.password));

        	if (userForm.insertEditFlg == CommonCode.NEW_FLG) {

            	if (userEntity == null) {
            		userForm.getUserEntity().setUserAuth(2);
            		userForm.getUserEntity().setAuthComment("一般社員");
                	// 登録
                	userMapper.insert(userForm.getUserEntity());
            	} else {
            		return false;
            	}

        	} else {

            	// ユーザ名設定
            	userEntity = userForm.getUserEntity();
            	// 更新
            	userMapper.update(userEntity);
        	}
    	} catch (TransactionTimedOutException e) {
    		throw new TransactionTimedOutException("");
    	}

    	return true;
    }
}