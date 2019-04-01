/*
 * @Copyright: 2005-2018 www.2345.com. All rights reserved.
 */
package com.goudong.filter;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

import javax.servlet.http.HttpServletResponse;

/**
 * @author chentl
 * @version CrossFilter, v0.1 2019/4/1 10:10
 */
public class CrossInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        CrossOrigin cross = inv.getController().getClass().getAnnotation(CrossOrigin.class);
        if (cross != null) {
            handler(inv.getController().getResponse());
            inv.invoke();
            return;
        }
        cross = inv.getMethod().getAnnotation(CrossOrigin.class);
        if (cross != null) {
            handler(inv.getController().getResponse());
            inv.invoke();
            return;
        }
        inv.invoke();
    }

    private void handler(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
    }
}
