package com.zoo.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zoo.biz.ProductTypeBiz;
import com.zoo.common.Pagination;
import com.zoo.entity.ProductType;

@Controller
@Scope("prototype")
public class ProductTypeAction {
	@Resource
	private ProductTypeBiz service ;
	private String message ;
	private List<ProductType> productTypes ;
	private ProductType productType ;
	private Pagination pagination; 
    private int pageNo = 1;
	private String parentID  ;

	public List<ProductType> getProductTypes() {
		return productTypes;
	}
	public void setProductTypes(List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}
	public void setService(ProductTypeBiz service) {
		this.service = service;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}	
	public String getParentID() {
		return parentID;
	}
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
	/**  
     * 产品分类列表显示  
     */   
    public String list(){  	
    	List<ProductType> list = service.findAll();
    	pagination = new Pagination(pageNo, 2, list.size(),5,"producttype_list.do","pagenum");  
    	productTypes = pagination.getPageDate(list);
    	return "list";   
    }   
    /**  
     * 产品分类添加界面  
     */   
    public String addUI(){
        return "add";   
    }
    /**
     * 产品分类查看界面
     */
    public String view(){
    	productType = service.find(productType.getTypeid());
    	return "view" ;
    }
    /**  
     * 人员添加  
     */   
    public String add(){   
    	productType.setParent(service.find(parentID==null || "".equals(parentID) ? 0 : Integer.parseInt(parentID)));
    	service.save(this.productType);   
        this.message="产品分类添加成功";  
        ActionContext.getContext().getSession().put("url","producttype_list.do");
        return "success";   
    } 
    /**
     * 产品分类编辑界面
     */
    public String editUI(){
    	productType = service.find(productType.getTypeid());    	
    	return "editUI" ;
    }
    /**
     * 产品分类编辑
     */
    public String edit(){
    	service.update(this.productType);   
        this.message="产品分类修改成功";   
        return "success";
    }
}
