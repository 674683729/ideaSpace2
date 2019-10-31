package com.fh.shop.api.argumentReslover;

import com.fh.shop.api.member.vo.MemberVo;
import com.fh.shop.api.utils.SystemConst;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class MemberMethodArgumentReslover implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> memberVo = parameter.getParameterType();
        return memberVo==MemberVo.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        MemberVo memberVo = (MemberVo)request.getAttribute(SystemConst.LOGIN_MEMBER);
        return memberVo;
    }
}
