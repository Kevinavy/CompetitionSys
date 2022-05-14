package com.kevinavy.competitionsys.security.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kevinavy.competitionsys.constant.enums.ResponseCode;
import com.kevinavy.competitionsys.model.common.Response;
import com.kevinavy.competitionsys.security.service.SecurityAccessDeniedHandler;
import com.kevinavy.competitionsys.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityAccessDeniedHandlerImpl implements SecurityAccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        WebUtils.renderString(response, JSONObject.toJSONString(Response.error(ResponseCode.FORBIDDEN)));
    }
}
