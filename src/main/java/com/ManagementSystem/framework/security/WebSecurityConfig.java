package com.ManagementSystem.framework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ManagementSystem.framework.security.conf.ConfAuthenticationFailureHandler;
import com.ManagementSystem.framework.security.conf.ConfAuthenticationLogoutHandler;
import com.ManagementSystem.framework.security.conf.ConfAuthenticationSuccessHandler;
import com.ManagementSystem.framework.service.ConfUserDetailsService;

/**
 * Spring Security設定クラス.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 認証が成功した時のHandlerクラスをBean登録する
	 * @return 認証が成功した時のHandlerクラス
	 */
	@Bean
	ConfAuthenticationSuccessHandler confAuthenticationSuccessHandler() {
		return new ConfAuthenticationSuccessHandler();
	}

	/**
	 * 認証が失敗した時のHandlerクラスをBean登録する
	 * @return 認証が失敗した時のHandlerクラス
	 */
	@Bean
	ConfAuthenticationFailureHandler confAuthenticationFailureHandler() {
		return new ConfAuthenticationFailureHandler();
	}

	/**
	 * ログアウト時のHandlerクラスをBean登録する
	 * @return ログアウト時のHandlerクラス
	 */
	@Bean
	ConfAuthenticationLogoutHandler confAuthenticationLogoutHandler() {
		return new ConfAuthenticationLogoutHandler();
	}

	/** Spring Securityのユーザー認証用サービス拡張版クラス */
	@Autowired
	ConfUserDetailsService confUserDetailsService;

	/**
	 * Spring Securityの対象としないパスの設定
	 * @param web WebSecurity
	 * @throws Exception Exception
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		// セキュリティ設定を無視するリクエスト設定
		// 静的リソース(images、css、js)に対するアクセスはセキュリティ設定を無視する
		web.ignoring().antMatchers("/images/**", "/css/**", "/js/**");
	}

	/**
	 * Spring Securityの設定
	 * @param http HttpSecurity
	 * @throws Exception Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// 認可の設定
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated() // それ以外は全て認証無しの場合アクセス不許可
			.and()
			.logout()
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true).permitAll()
			.and()
			.headers()
			.frameOptions().sameOrigin(); // Fancyboxを使用するため。

		// ログイン認証用
		http.formLogin()
			.loginPage("/login") // ログインフォームのパス
			.successHandler(confAuthenticationSuccessHandler())
			.failureHandler(confAuthenticationFailureHandler())
			.permitAll()
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			.logout()
			.logoutSuccessUrl("/login")
			.logoutSuccessHandler(confAuthenticationLogoutHandler());
	}

	/**
	 * 設定済みのAuthenticationManagerBuilderを取得し、カスタムしたUserDetailsServiceを設定
	 * @param auth AuthenticationManagerBuilder
	 * @throws Exception Exception
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 認証するユーザーを設定する
		auth.userDetailsService(confUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
