package com.ManagementSystem.framework.security.conf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * Spring Securityの認証失敗時に呼ばれるハンドラクラス
 */
public class ConfAuthenticationFailureHandler extends AbstractAuthenticationTargetUrlRequestHandler 
implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AuthenticationException authenticationException) throws IOException, ServletException {
		
		String errorId = "";
		// ExceptionからエラーIDをセットする
		if (authenticationException instanceof BadCredentialsException) {
			errorId = "errorId";
		}

		// ログイン画面にリダイレクトする
		getRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, "/login?error=" + errorId);
	}
}
