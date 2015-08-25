package junit.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zoo.biz.RoleBiz;
import com.zoo.biz.UserBiz;
import com.zoo.entity.Role;
import com.zoo.entity.User;

/**
 * @Email    22582416@qq.com
 * @author   张如利
 * @version  创建时间:2011-6-14下午10:00:19
 */
public class UserBizTest {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserBiz biz = (UserBiz)ctx.getBean("userBiz");
	RoleBiz rbiz = (RoleBiz)ctx.getBean("roleBiz");
	
	@Test
	public void testIsExist() {
		System.out.println(biz.isExist("zhangrl"));
	}
	
	@Test
	public void testAddUser() {
		User u = new User();
		u.setLoginName("zoo");
		u.setRealName("张如利");
		u.setAddress("瑞士花园");
		u.setAge(31);
		u.setEmail("22582416@qq.com");
		u.setGovermentID("450521197907263912");
		u.setMobile("13471030361");
		u.setPhone("07798702817");
		u.setPwd("123456");
		List<Role> roles = rbiz.findAll("id = 1");
		u.setRoles(roles);
		biz.addUser(u);
		System.out.println("ok");
	}
	
	@Test
	public void testList(){
		List<User> users = biz.findAll();
		for(User u : users){
			System.out.println(u.getId()+":"+u.getLoginName());
		}
	}

}
