package junit.test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zoo.entity.User;
import com.zoo.web.action.UserAction;

/**
 * @Email    22582416@qq.com
 * @author   张如利
 * @version  创建时间:2011-6-14下午10:35:10
 */
public class UserActionTest {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserAction action = (UserAction)ctx.getBean("userAction");
	
	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		User u = new User();
		u.setLoginName("zhangrl");
		u.setPwd("123456");
		action.setUser(u);
		System.out.println(action.login());
	}

}
