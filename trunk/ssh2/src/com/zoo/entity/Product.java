package com.zoo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	/** id */
	private Integer id ;
	/** 产品名称  */
	private String name ;
	/** 库存 */
	private Integer inventories ;
	/** 所属产品类型 */
	private ProductType type ;
	/** 价格 */
	private Double price ;
	/** 折扣 */
	private Double discount ;
	/** 是否可见 **/
	private Boolean visible = true ;
	/** 备注，用于google页面描述 **/
	private String note ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=30,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getInventories() {
		return inventories;
	}
	public void setInventories(Integer inventories) {
		this.inventories = inventories;
	}
	@ManyToOne(cascade=CascadeType.REFRESH ,fetch = FetchType.EAGER)
	@JoinColumn(name="typeid")
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Boolean isVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	@Column(length=300)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}


}
