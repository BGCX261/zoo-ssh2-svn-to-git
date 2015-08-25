package com.zoo.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zoo.dao.BaseDao;
import com.zoo.entity.User;

/**
 * @Email 22582416@qq.com
 * @author 张如利
 * @version 创建时间:2011-6-14下午09:49:38
 */
@Service
public class UserBiz extends BaseDao<User> {

	/**
	 * 检查该用户名是否存在
	 * @param username 用户名
	 * @return 存在该用户名返回true，否则返回false
	 */
	public boolean isExist(String username) {
		List<User> users = this.findAll("loginName=?", new Object[]{username});
		return (null == users || users.size()<1) ? false : true;
	}
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param pwd 密码
	 * @return 存在该用户返回true，否则返回false
	 */
	public boolean login(String username,String pwd){
		List<User> users = this.findAll("loginName=? and pwd=?", new Object[]{username,pwd});
		return (null == users || users.size()<1) ? false : true;
	}
	
	/**
	 * 添加用户
	 * @param user 用户对象
	 */
	public void addUser(User user){
		this.save(user);
	}
}
