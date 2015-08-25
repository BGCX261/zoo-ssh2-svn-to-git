package junit.test;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zoo.biz.ProductTypeBiz;
import com.zoo.entity.ProductType;

/**
 * @Email    22582416@qq.com
 * @author   张如利
 * @version  创建时间:2011-6-11下午08:19:16
 */
public class ProductTypeBizTest {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	ProductTypeBiz biz = (ProductTypeBiz)ctx.getBean("productTypeBiz");

	@Test
	public void testAddProductType() {
		ProductType type = new ProductType();
		type.setName("rasf");
		biz.addProductType(type);
		System.out.println("ok");
	}

	@Test
	public void testDelProductTypeProductType() {
		biz.delete(biz.find(5));
		System.out.println("ok");
	}

	@Test
	public void testDelProductTypeProductTypeArray() {
		biz.delete(new ProductType[]{biz.find(6),biz.find(7)});
		System.out.println("ok");
	}

	@Test
	public void testDelProductTypeInteger() {
		biz.delFromID(4);
		System.out.println("ok");
	}

	@Test
	public void testDelProductTypeIntegerArray() {
		biz.delFromID(new Integer[]{2,3});
		System.out.println("ok");
	}

	@Test
	public void testModifyProductType() {
		ProductType type = biz.find(8);
		type.setName("feilo");
		biz.modifyProductType(type);
		System.out.println("ok");
	}

	@Test
	public void testViewProductType() {
		System.out.println(biz.viewProductType(8).getName());
	}

	@Test
	public void testViewProductTypeList() {
		List<ProductType> list = biz.findAll();
		for(ProductType type : list){
			System.out.println(type.getName());
		}
	}

	@Test
	public void testSearch() {
		String where = "name like ? and typeid > ?" ;
		Object[] params = new Object[]{"%f%",8};
		LinkedHashMap<String,String> orderby = new LinkedHashMap<String,String>();
		orderby.put("name", "asc");
		orderby.put("typeid", "desc");
		List<ProductType> list = biz.search(where, params, orderby);
		for(ProductType type : list){
			System.out.println(type.getTypeid()+":"+type.getName());
		}
	}

}
