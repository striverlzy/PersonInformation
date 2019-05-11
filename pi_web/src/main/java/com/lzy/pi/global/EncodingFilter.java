package com.lzy.pi.global;

import javax.servlet.*;
import java.io.IOException;

/**
 * 编码过滤器
 */
public class EncodingFilter implements Filter {

    private String encoding="UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //读取初始化参数指定编码
       if(filterConfig.getInitParameter("ENCODING")!=null)
        encoding=filterConfig.getInitParameter("ENCODING");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //请求编码
        servletRequest.setCharacterEncoding(encoding);
        //相应编码
        servletResponse.setCharacterEncoding(encoding);
        //继续执行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        encoding=null;
    }
}
