package com.ManagementSystem.framework.security.conf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * Spring Securityのログアウト時に呼ばれるハンドラクラス
 */
public class ConfAuthenticationLogoutHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {
		
		// ログイン画面にリダイレクトする
		httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login?logout");
	}
}
