package com.douzone.dzfinal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerSecurityConfig extends ResourceServerConfigurerAdapter {
    @Value("${publickey}")
    private String publickey;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenStore(tokenStore());
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setVerifierKey(publickey);
        return converter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/api/admin/getimage/**").permitAll()
                .mvcMatchers(HttpMethod.GET, "/api/view/**").permitAll()
                .mvcMatchers(HttpMethod.GET, "/api/reservation/**").permitAll()
                .mvcMatchers(HttpMethod.GET, "/api/reception/**").permitAll()
                .mvcMatchers(HttpMethod.GET, "/api/clinic/**").permitAll()
                .mvcMatchers(HttpMethod.GET, "/api/receipt/**").permitAll()
                .mvcMatchers(HttpMethod.GET, "/api/employee/**").permitAll()
                .mvcMatchers(HttpMethod.GET, "/api/chat/**").permitAll()
                .mvcMatchers("/api/admin/**").hasAuthority("ADMIN")
                .mvcMatchers("/api/employee/**").hasAuthority("ADMIN")
                .mvcMatchers("/api/reservation/**").hasAnyAuthority("KLPN", "RN", "DOCTOR")
                .mvcMatchers("/api/patient/**").hasAnyAuthority("KLPN", "RN", "DOCTOR")
                .mvcMatchers("/api/reception/**").hasAnyAuthority("KLPN", "RN", "DOCTOR")
                .mvcMatchers("/api/clinic/**").hasAuthority("DOCTOR")
                .mvcMatchers("/api/receipt/**").hasAnyAuthority("KLPN", "RN", "DOCTOR")
                .mvcMatchers("/api/did/**").authenticated()
                .mvcMatchers("/api/**").authenticated();
    }
}

