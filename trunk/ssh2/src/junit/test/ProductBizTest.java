package junit.test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zoo.biz.ProductBiz;
import com.zoo.biz.ProductTypeBiz;
import com.zoo.entity.Product;

/**
 * @Email    22582416@qq.com
 * @author   张如利
 * @version  创建时间:2011-6-9下午03:19:54
 */
public class ProductBizTest {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	ProductBiz biz = (ProductBiz)ctx.getBean("productBiz");
	ProductTypeBiz typebiz = (ProductTypeBiz)ctx.getBean("productTypeBiz");

	@Test
	public void testAddProduct() {
		for(int i=0;i<50;i++){
			Product p = new Product();
			p.setDiscount(1.1);
			p.setInventories(20);
			p.setName("cc"+i);
			p.setPrice(5.5);
			p.setType(typebiz.find(1));
			p.setVisible(true);
			biz.addProduct(p);
		}
		System.out.println("success");
	}

	@Test
	public void testDelProductProduct() {
		
	}

	@Test
	public void testModifyProduct() {
		
	}

	@Test
	public void testViewProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewProductList() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchProducts() {
		fail("Not yet implemented");
	}

}
