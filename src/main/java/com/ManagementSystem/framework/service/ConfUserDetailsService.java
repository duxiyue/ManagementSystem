package com.ManagementSystem.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ManagementSystem.web.entity.UserEntity;
import com.ManagementSystem.web.mapper.UserMapper;
/**
 * Spring Securityのユーザー認証用サービス拡張版クラス
 */
@Service
@Transactional
public class ConfUserDetailsService implements UserDetailsService {

	/** ユーザーMapper */
    @Autowired
    private UserMapper userMapper;

    /*
     * ユーザーコードでユーザーを検索する
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     * 
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username == null ) {
        	// ユーザーコード入力しない場合
            throw new UsernameNotFoundException("ユーザーコードを入力してください。");
        }
        // 入力したユーザーIDから認証を行うユーザー情報を取得する
        UserEntity userEntity = userMapper.getByUserCode(username);

        if (userEntity != null) {
        	return new User(userEntity.getUserCode(),
        			userEntity.getPassword(),
        			AuthorityUtils.createAuthorityList("USER"));
        }
        // ユーザー存在しない場合
        throw new UsernameNotFoundException("ユーザーが見つかりませんでした。");
    }
}