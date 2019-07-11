package com.webcacheredis.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Catchfilter implements Filter, ApplicationContextAware{
    private static final Logger log = LoggerFactory.getLogger(Catchfilter.class);
    private static ApplicationContext ctx;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        // 如果不是访问主页，放行
        if (!req.getRequestURI().equals(req.getContextPath()+"/manager/listmanagers.do")) {
            filterChain.doFilter(servletRequest, resp);
            return;
        }
        // 从缓存中得到主页html
        String html = getPageFromCache();
        if (null == html) {
            // 截取生成的html并放入缓存
            ResponseWrapper wrapper = new ResponseWrapper(resp);
            filterChain.doFilter(servletRequest, wrapper);
            // 放入缓存
            html = wrapper.getResult();
            putIntoCache(html);
        }
        // 返回响应
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().print(html);
    }

    @Override
    public void destroy() {

    }



    private void putIntoCache(String html){
        StringRedisTemplate redis = (StringRedisTemplate)ctx.getBean("redisTemplate");
        redis.opsForValue().set("home",html, TimeUnit.MINUTES.toSeconds(10));//设置10分钟
    }

    private String getPageFromCache(){
        StringRedisTemplate redis = (StringRedisTemplate)ctx.getBean("redisTemplate");
        ValueOperations<String,String> v = redis.opsForValue();
        return redis.opsForValue().get("home");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
