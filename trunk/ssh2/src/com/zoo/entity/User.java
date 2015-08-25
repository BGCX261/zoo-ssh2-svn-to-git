package com.zoo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @Email 22582416@qq.com
 * @author 张如利
 * @version 创建时间:2011-6-14下午09:40:53
 */
@Entity(name = "userinfo")
public class User {
	/** id */
	private Integer id;
	/** 登录名称 */
	private String loginName;
	/** 真实姓名 */
	private String realName;
	/** 登录密码 */
	private String pwd;
	/** 用户住址 */
	private String address;
	/** 用户邮箱 */
	private String email;
	/** 用户电话号码 */
	private String phone;
	/** 用户手机号码 */
	private String mobile;
	/** 用户年龄 */
	private Integer age;
	/** 用户身份证号码 */
	private String govermentID;
	/** 是否可用标志 */
	private Boolean useFlag = true;
	/** 用户角色列表 */
	private List<Role> roles;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGovermentID() {
		return govermentID;
	}

	public void setGovermentID(String govermentID) {
		this.govermentID = govermentID;
	}

	public Boolean getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(Boolean useFlag) {
		this.useFlag = useFlag;
	}

	@ManyToMany(targetEntity=com.zoo.entity.Role.class, cascade={CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name="user_role", joinColumns={@JoinColumn(name="user_id")}, inverseJoinColumns={@JoinColumn(name="role_id")})
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
