package com.zoo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProductType implements Serializable{

	private static final long serialVersionUID = -4983903562660167289L;
	/** 类别id **/
	private Integer typeid;
	/** 类别名称 **/
	private String name;
	/** 备注，用于google页面描述 **/
	private String note ;
	/** 是否可见 **/
	private Boolean visible = true ;
	/** 子类别 **/
	private Set<ProductType> childtypes = new HashSet<ProductType>();
	/** 所属父类别 **/
	private ProductType parent ;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	@Column(length=30,nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=300)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(nullable=false)
	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	@OneToMany(cascade={CascadeType.REFRESH,CascadeType.REMOVE},mappedBy="parent")
	public Set<ProductType> getChildtypes() {
		return childtypes;
	}

	public void setChildtypes(Set<ProductType> childtypes) {
		this.childtypes = childtypes;
	}

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="parentid")
	public ProductType getParent() {
		return parent;
	}

	public void setParent(ProductType parent) {
		this.parent = parent;
	}

}
