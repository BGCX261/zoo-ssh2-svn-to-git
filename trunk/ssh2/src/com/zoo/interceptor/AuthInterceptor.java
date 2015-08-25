package com.zoo.interceptor;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zoo.entity.User;


public class AuthInterceptor  extends AbstractInterceptor {

    private static final long serialVersionUID = 4949812834762901805L;
    private static Log log = LogFactory.getLog(AuthInterceptor.class);
    
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // 取得请求的Action名
        String name = invocation.getInvocationContext().getName(); // action
        // 的名称，在xml中配置的
        String namespace = invocation.getProxy().getNamespace(); // 获取到namespace，还能够获取到要执行的方法，class等
        if ((namespace != null) && (namespace.trim().length() > 0)) {
            if ("/".equals(namespace.trim())) {
                // 说明是根路径，不需要再增加反斜杠了。
            } else {
                namespace += "/";
            }
        }
        String URL = namespace + invocation.getProxy().getActionName();
        
        URL += ".do";
        log.debug("actionname=" + name + "||fullActionName=" + URL);
        if (name.equals("login") || name.equals("loginAccess")) {
            // 如果用户想登录，则使之通过
            return invocation.invoke();
        }
        Map<String,Object> session = invocation.getInvocationContext().getSession();
        // TODO 在这里判断用户是否已经登陆,更改此方法，和OnLineUserManager联系起来，
        //OnLineUserManager 是线程安全的，效率上可能会比较低！所以暂时还不更改！。
        String success = (String) session.get("loginFlag");
        log.debug("success=" + success);
        // 如果没有登陆，那么就退出系统
        if (success == null || !"true".equals(success)) {
            log.debug("please login");
            return "login";
        }
        User user = (User) session.get("user");
        if (user == null) {
            log.error("用户不能为空!");
            return "login";
        }

        return null ;
    }

}