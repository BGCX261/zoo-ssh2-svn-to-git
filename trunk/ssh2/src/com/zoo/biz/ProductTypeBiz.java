package com.zoo.biz ;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zoo.dao.BaseDao;
import com.zoo.entity.ProductType;

/**
 * @Email    22582416@qq.com
 * @author   张如利
 * @version  创建时间:2011-6-1上午12:18:04
 */
@Service
public class ProductTypeBiz extends BaseDao<ProductType>{
	
	/**
	 * 添加产品类型
	 * @param type 产品类型对象
	 */
	public void addProductType(ProductType type){
		this.save(type);
	}
	
	/**
	 * 删除产品类型
	 * @param type 产品类型对象
	 */
	public void delProductType(ProductType type){
		this.delete(type);
	}
	
	/**
	 * 批量删除产品类型
	 * @param type 产品类型对象数组
	 */
	public void delProductType(ProductType[] types){
		this.delete(types);
	}
	
	/**
	 * 批量删除产品类型
	 * @param type 产品类型对象列表
	 */
	public void delProductType(List<ProductType> types){
		this.delete(types);
	}
	
	/**
	 * 根据产品类型ID删除产品类型
	 * @param id 产品类型ID
	 */
	public void delProductType(Integer id){
		this.delFromID(id);
	}
	
	/**
	 * 根据产品类型ID数组批量删除产品类型
	 * @param id 产品类型ID数组
	 */
	public void delProductType(Integer[] ids){
		this.delFromID(ids);
	}
	
	/**
	 * 修改产品类型
	 * @param type 产品类型对象
	 */
	public void modifyProductType(ProductType type){
		this.update(type);
	}
	
	/**
	 * 根据产品类型ID查看产品类型信息
	 * @param id 产品类型ID
	 * @return 产品类型对象
	 */
	public ProductType viewProductType(Integer id){
		return this.find(id);
	}
	
	/**
	 * 查看所有产品类型信息
	 * @return 产品类型列表
	 */
	public List<ProductType> viewProductTypeList(){
		return this.findAll();
	}
	
	/**
	 * 搜索所有符合条件的实体类对象列表,并进行排序
	 * @param where   条件语句,格式为:attribute operator ?,比如查找用户列表(username like ? and password=?) 
	 * @param params  条件语句中所用到的参数Object数组,例如:(new Object[]{"%xx%","yy"}),可找到所有用户名包含xx字符并且密码等于yy的用户
	 * @param orderby 排序用到的LinkedHashMap<key,value>集合,key为要排序的属性,value为key属性的排序操作,有两种选择:asc(升序)和desc(降序)
	 *                例如orderby.put("username","asc");orderby.put("password","desc");,表示先按用户名升序再按密码降序进行排序。
	 * @return        实体类对象列表
	 */
	public List<ProductType> search(String where,Object[] params,LinkedHashMap<String,String> orderby){
		return this.findAll(where, params, orderby);
	}

}
