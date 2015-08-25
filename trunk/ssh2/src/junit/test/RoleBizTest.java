package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zoo.biz.RoleBiz;
import com.zoo.entity.Role;

public class RoleBizTest {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	RoleBiz biz = (RoleBiz)ctx.getBean("roleBiz");
	
	@Test
	public void testAddRole(){
		Role role = new Role();
		role.setDescp("xxx");
		role.setRoleName("normal");
		role.setRoleTitle("普通用户");
		biz.save(role);
		System.out.println("ok");
	}
	
}
