package com.zoo.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zoo.biz.ProductBiz;
import com.zoo.biz.ProductTypeBiz;
import com.zoo.common.Pagination;
import com.zoo.entity.Product;
import com.zoo.entity.ProductType;

@Controller
@Scope("prototype")
public class ProductAction {
	@Resource
	private ProductBiz productService ;
	@Resource 
	private ProductTypeBiz typeService ;
	private String message ;
	private List<ProductType> types ;
	private ProductType type ;
	private List<Product> products ;
	private Product product ;
	private Pagination pagination; 
    private Integer pageNo = 1;
    private String url = "product_list.do" ;
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	public List<ProductType> getTypes() {
		return types;
	}
	public void setTypes(List<ProductType> types) {
		this.types = types;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}	
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	} 
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	/**  
     * 产品列表显示  
     */   
    public String list(){ 
        this.products = productService.viewProductList();  
        pagination = new Pagination(pageNo,12,products.size(),5, url,"pagenum");
        products = pagination.getPageDate(products);
        return "list";   
    }  
	/**
     * 产品查看
     */
    public String view(){
    	this.product = productService.viewProduct(product.getId());
    	return "view" ;
    }
    /**  
     * 产品添加界面  
     */   
    public String addUI(){   
        return "addUI";   
    }   
    /**  
     * 产品添加  
     */   
    public String add(){
    	if(type!=null & type.getTypeid()!=null){
    		type = typeService.find(type.getTypeid());
    		product.setType(type);
    	}else{
    		product.setType(null);
    	}
    	productService.save(this.product);   
        this.message="产品添加成功";   
        return "success";   
    }
    /**  
     * 产品修改界面  
     */  
    public String editUI(){
    	this.product = productService.viewProduct(product.getId());
    	this.type = product.getType();
    	return "editUI" ;
    }
    /**  
     * 产品修改  
     */   
    public String edit(){
    	if(type!=null & type.getTypeid()!=null){
    		type = typeService.find(type.getTypeid());
    		product.setType(type);
    	}
    	productService.modifyProduct(product);   
        this.message="产品修改成功";   
        return "success";   
    }
    /**  
     * 产品删除  
     */
    public String del(){
    	productService.delProduct(product.getId());
    	this.message="产品删除成功";   
        return "success"; 
    }    
    /**
     * 统合查询界面
     */
    public String queryProductUI(){
    	return "queryProductUI" ;
    }
    /**
     * 产品搜索  
     */
    public String search(){
    	String where = "name like ?" ;
    	Object[] params = new Object[]{"%"+product.getName()+"%"};
    	this.products = productService.search(where, params, null);
    	return "list";
    }    
    /**
     * 产品类型选择
     */
    public String selectTypeUI(){
    	String jpql = "parent is null" ;
    	Object[] params = null ;
    	ProductType parent = null ;
    	if(type!=null && type.getTypeid()>0){
    		jpql = "parent.typeid=?" ;
    		params = new Object[]{type.getTypeid()};
    		parent = typeService.find(type.getTypeid());
    	}
    	types = typeService.findAll(jpql, params);
    	List<ProductType> menutypes = new ArrayList<ProductType>();
    	while(parent!=null){
    		menutypes.add(parent);
    		parent = parent.getParent();
    	}
    	ActionContext.getContext().getSession().put("menutypes", menutypes);
    	return "selectTypeUI" ;
    }
}
