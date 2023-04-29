package com.example.mallelectron.filter;


import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.example.mallelectron.domain.Admin;
import com.example.mallelectron.dto.SecurityUser;
import com.example.mallelectron.exception.CustomException;
import com.example.mallelectron.util.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录过滤器
 */
@Slf4j
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Admin admin = new ObjectMapper().readValue(request.getInputStream(),
                    Admin.class);
            // authenticationManager.authenticate 调用登录方法
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getUsername(), admin.getPassword()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException("登录信息不正确！");
        }
    }

    public static final String SECURITY_KEY = "9d5ea474b14ba109eaaf2d4f8f516183";
    private static final long EXPIRE_TIME = 1000 * 60 * 60 * 24;

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        Map<String, Object> map = new HashMap<String, Object>() {
            {
                log.debug("authResult getPrincipal class => {}", authResult.getPrincipal().getClass());
                SecurityUser secuirtyUser = (SecurityUser) authResult.getPrincipal();
                put(JWT.JWT_ID, secuirtyUser.getAdmin().getId());
                put(JWT.EXPIRES_AT, System.currentTimeMillis() + EXPIRE_TIME);
            }
        };
        String token = JWTUtil.createToken(map, SECURITY_KEY.getBytes());
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(new JSONObject(Result.ok().data("token", token)).toString());
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(new JSONObject(Result.error().message("账号或密码错误！")).toString());
    }
}
