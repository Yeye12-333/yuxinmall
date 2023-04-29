package com.example.mallelectron.filter;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.example.mallelectron.dto.SecurityUser;
import com.example.mallelectron.exception.CustomException;
import com.example.mallelectron.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 认证过滤器
 */
@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    private final AdminService adminService;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, AdminService adminService) {
        super(authenticationManager);
        this.adminService = adminService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("authorization");
        log.debug("token => {}", token);
        // 如果请求头中没有Authorization信息则直接放行了
        if (!StringUtils.hasLength(token)) {
            super.doFilterInternal(request, response, chain);
            return;
        }
        try {
            JWT jwt = JWTUtil.parseToken(token);
            Long timestamp = (Long) jwt.getPayload().getClaim(JWT.EXPIRES_AT);
            if (System.currentTimeMillis() > timestamp){
                throw new CustomException("token已过期");
            }else {
                Integer id = (Integer) jwt.getPayload().getClaim(JWT.JWT_ID);
                SecurityUser securityUser = adminService.getSecurityUser(id);
                // 如果请求头中有token，则进行解析，并且设置认证信息
                if (securityUser != null){
                    SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                            securityUser, securityUser.getPassword(), securityUser.getAuthorities()
                    ));
                    super.doFilterInternal(request, response, chain);
                }else {
                    throw new CustomException("用户状态异常");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            if (e instanceof CustomException){
                throw e;
            }else {
                throw new CustomException("token格式有误");
            }
        }
    }
}
