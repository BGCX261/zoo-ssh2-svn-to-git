package com.zoo.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zoo.biz.UserBiz;
import com.zoo.entity.User;

/**
 * @Email    22582416@qq.com
 * @author   张如利
 * @version  创建时间:2011-6-14下午10:26:00
 */
@Controller
@Scope("prototype")
public class UserAction {
	@Resource
	private UserBiz biz ;
	private List<User> users ;
	private User user ;
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String list(){
		users = biz.findAll();
		return "list" ;
	}
	
	public String login(){
		if(biz.login(user.getLoginName(), user.getPwd())){
			return "main" ;
		}
		return "login" ;
	}
	
	public String loginUI(){
		return "login" ;
	}
}
