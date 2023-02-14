package com.tdh.gps.console.token.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;


/**
 * 
 * @ClassName: SsoWebSecurityConfigurer
 * @Description: (sso资源服务配置类)
 * @author wxf
 * @date 2018年12月4日 下午3:43:56
 *
 */
@Configuration
@EnableResourceServer
public class SsoResourceServerConfigurer extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "my_rest_api";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.anonymous().disable().requestMatchers().antMatchers("/user*/**").and().authorizeRequests()
				.antMatchers("/user*/**").permitAll().and().exceptionHandling()
				.accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}
