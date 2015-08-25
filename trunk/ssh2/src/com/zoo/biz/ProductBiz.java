package com.zoo.biz;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zoo.dao.BaseDao;
import com.zoo.entity.Product;

/**
 * @Email    22582416@qq.com
 * @author   张如利
 * @version  创建时间:2011-6-1上午12:24:59
 */
@Service
public class ProductBiz extends BaseDao<Product>{
	
	/**
	 * 添加产品
	 * @param product 产品对象
	 */
	public void addProduct(Product product){
		this.save(product);
	}
	
	/**
	 * 删除产品
	 * @param product 产品对象
	 */
	public void delProduct(Product product){
		this.delete(product);
	}
	
	/**
	 * 批量删除产品
	 * @param product 产品对象
	 */
	public void delProduct(Product[] product){
		this.delete(product);
	}
	
	/**
	 * 根据产品ID删除产品
	 * @param id 产品ID
	 */
	public void delProduct(Integer id){
		this.delFromID(id);
	}
	
	/**
	 * 根据产品ID数组批量删除产品
	 * @param id 产品ID数组
	 */
	public void delProduct(Integer[] id){
		this.delFromID(id);
	}
	
	/**
	 * 修改产品
	 * @param product 产品对象
	 */
	public void modifyProduct(Product product){
		this.update(product);
	}
	
	/**
	 * 根据产品ID查看产品信息
	 * @param productid 产品ID
	 * @return 产品对象
	 */
	public Product viewProduct(Integer productid){
		return this.find(productid);
	}
	
	/**
	 * 查看所有产品信息
	 * @return 产品列表
	 */
	public List<Product> viewProductList(){
		return this.findAll();
	}
	
	/**
	 * 根据条件搜索产品信息
	 * @param where    产品条件
	 * @param params   条件参数
	 * @param orderby  排序条件
	 * @return 产品列表
	 */
	public List<Product> search(String where,Object[] params,LinkedHashMap<String,String> orderby){
		return this.findAll(where, params, orderby);
	}
}
