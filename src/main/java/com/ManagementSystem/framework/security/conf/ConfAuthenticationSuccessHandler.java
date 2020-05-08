package com.ManagementSystem.framework.security.conf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ManagementSystem.framework.security.dto.LoginUserDto;
import com.ManagementSystem.framework.security.dto.TopMenuDto;
import com.ManagementSystem.framework.service.TopMenuService;
import com.ManagementSystem.web.entity.UserEntity;
import com.ManagementSystem.web.mapper.UserMapper;

/**
 * Spring Securityの認証成功時に呼ばれるハンドラクラス
 */
public class ConfAuthenticationSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler 
implements AuthenticationSuccessHandler {

	/** ユーザーMapper */
    @Autowired
    private UserMapper userMapper;
    
    /** ログインユーザー情報*/
    @Autowired
    private LoginUserDto loginUserDto;
    
    /** トップメニューサービス*/
	@Autowired
	private TopMenuService topMenuService;
	
	/**トップメニューDto */
    @Autowired
    private TopMenuDto topMenuDto;
    
	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {

		User user = (User) authentication.getPrincipal();

		// ユーザー情報取得
		UserEntity userEntity = userMapper.getByUserCode(user.getUsername());

		// ユーザーコード
		loginUserDto.setUserCode(userEntity.userCode);
		// ユーザー名
		loginUserDto.setUserName(userEntity.userName);
		// ユーザー権限LEV
		loginUserDto.setUserAuth(userEntity.userAuth);
		// 権限名
		loginUserDto.setAuthComment(userEntity.authComment);
		
		// トップメニュー
		topMenuDto.setTopMenuList(topMenuService.topMenuInit(userEntity.userAuth));
		
		// ログイン成功したら、セッションID切り替え
		httpServletRequest.changeSessionId();
		
		getRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, "/top");
	}
}
