package com.zoo.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Hibernate基类，抽象类，不能直接实例化，只提供继承
 * @author 张如利
 * @param <T>没确定的范型，由继承者确定其类型
 */
@Transactional
public abstract class BaseDao<T> {
	
	@Resource
	protected HibernateTemplate hibernateTemplate;
	
	private Class<T> entityClass = getEnityClass();

	/**
	 * 获取实体bean类型对象(也就是确定传过来的范型<T>)
	 * @return 实体bean类型对象
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getEnityClass() {
		Type parentType = getClass().getGenericSuperclass();
		if(parentType instanceof ParameterizedType){
			ParameterizedType ptype = (ParameterizedType)parentType ;
			return (Class<T>)ptype.getActualTypeArguments()[0] ;
		}
		return null;
	}
	
	/**
	 * 根据实体类对象ID删除该实体对象
	 * @param entityid 实体类对象ID
	 */
	public void delFromID(Integer entityid) {
		delFromID(new Integer[]{entityid});		
	}

	/**
	 * 根据实体类对象ID数组批量删除实体对象
	 * @param entityids 实体类对象ID数组
	 */
	public void delFromID(Integer[] entityids) {
		for(Integer id:entityids){
			hibernateTemplate.delete(hibernateTemplate.get(entityClass, id));
		}		
	}
	
	/**
	 * 根据实体类对象删除该实体对象
	 * @param entity 实体类对象
	 */
	public void delete(Object entity){
		hibernateTemplate.delete(entity);
	}
	
	/**
	 * 根据实体类对象数组批量删除实体对象
	 * @param entities 实体类对象数组
	 */
	public void delete(Object[] entities) {
		for(Object entity:entities){
			hibernateTemplate.delete(entity);
		}		
	}
	
	/**
	 * 根据实体类对象列表批量删除实体对象
	 * @param entities 实体类对象列表
	 */
	public void delete(List<T> entities) {
		for(T entity:entities){
			hibernateTemplate.delete(entity);
		}		
	}

	/**
	 * 保存实现类对象(一般用于添加)
	 * @param entity 实体类对象
	 */
	public void save(Object entity) {
		hibernateTemplate.save(entity);
	}

	/**
	 * 更新实现类对象
	 * @param entity 实体类对象
	 */
	public void update(Object entity) {
		hibernateTemplate.update(entity);
	}
	
	/**
	 * 根据实体类对象ID查找该实体类对象
	 * @param entityid 实体类对象ID
	 * @return 实体类对象
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public T find(Integer entityid) {
		return hibernateTemplate.get(entityClass, entityid);
	}
	
	/**
	 * 查找所有该实体类对象列表
	 * @return 实体类对象列表
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<T> findAll() {
		return findAll(null,null,null);
	}
	
	/**
	 * 查找所有符合条件的实体类对象列表
	 * @param where  条件语句,格式为:attribute operator condition,比如查找用户列表(username like "%f%")
	 * @return       实体类对象列表
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<T> findAll(String where) {
		return findAll(where,null,null);
	}
	
	/**
	 * 查找所有符合条件的实体类对象列表
	 * @param where  条件语句,格式为:attribute operator ?,比如查找用户列表(username like ? and password=?)
	 * @param params 条件语句中所用到的参数Object数组,例如:(new Object[]{"%xx%","yy"}),可找到所有用户名包含xx字符并且密码等于yy的用户
	 * @return       实体类对象列表
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<T> findAll(String where,Object[] params) {
		return findAll(where,params,null);
	}
	
	/**
	 * 查找所有符合条件的实体类对象列表,并进行排序
	 * @param where   条件语句,格式为:attribute operator ?,比如查找用户列表(username like ? and password=?) 
	 * @param params  条件语句中所用到的参数Object数组,例如:(new Object[]{"%xx%","yy"}),可找到所有用户名包含xx字符并且密码等于yy的用户
	 * @param orderby 排序用到的LinkedHashMap<key,value>集合,key为要排序的属性,value为key属性的排序操作,有两种选择:asc(升序)和desc(降序)
	 *                例如orderby.put("username","asc");orderby.put("password","desc");,表示先按用户名升序再按密码降序进行排序。
	 * @return        实体类对象列表
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<T> findAll(String where,Object[] params,LinkedHashMap<String,String> orderby) {
		String entityName = getEntityName(entityClass);
		String hql = "from "+entityName ;
		List<T> list = hibernateTemplate.find(hql+(where==null?" ":" where "+where)+buileOrderBy(orderby), params);
		return list ;
	}

	/**
	 * 构造orderby语句
	 * @param orderby
	 * @return orderby语句
	 */
	protected String buileOrderBy(LinkedHashMap<String,String> orderby){
		if(orderby==null || orderby.size()==0){
			return "" ;
		}else{
			StringBuffer sb = new StringBuffer();
			sb.append(" order by ");
			for(String key : orderby.keySet()){
				sb.append(key).append(" ").append(orderby.get(key)).append(",");
			}
			sb.deleteCharAt(sb.length()-1);
			return sb.toString();
		}
	}
	
	/**
	 * 获取实体类的名字，注解名优先，没有指定注解名则默认是类名
	 * @param entityClass 实体类的类对象
	 * @return 实体类的名字
	 */
	protected String getEntityName(Class<T> entityClass){
		String entityName = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if(entity!=null && !"".equals(entity.name())){
			entityName = entity.name() ;
		}
		return entityName ;
	}

}
