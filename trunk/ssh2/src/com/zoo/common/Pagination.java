package com.zoo.common;

import java.util.List;

/**
 * @Email    22582416@qq.com
 * @author   张如利
 * @version  创建时间:2011-5-30下午05:05:05
 */
public class Pagination {
	/** 当前页 */
	private int pageNo;
	/** 每页数据量 */
	private int pageSize;
	/** 总数据量 */
	private int allCount;
	/** 总页数 */
	private int allPage;
	/** 每页开始 */
	private int recordStart;
	/** 每页结束 */
	private int recordEnd;
	/** 显示页数 */
	private int showCount;
	/** 显示开始 */
	private int showStart;
	/** 显示结束 */
	private int showEnd;
	/** RUL地址*/
	private String url;
	/** 样式名字*/
	private String styleClass;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public int getRecordStart() {
		return recordStart;
	}
	public void setRecordStart(int recordStart) {
		this.recordStart = recordStart;
	}
	public int getRecordEnd() {
		return recordEnd;
	}
	public void setRecordEnd(int recordEnd) {
		this.recordEnd = recordEnd;
	}
	public int getShowCount() {
		return showCount;
	}
	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}
	public int getShowStart() {
		return showStart;
	}
	public void setShowStart(int showStart) {
		this.showStart = showStart;
	}
	public int getShowEnd() {
		return showEnd;
	}
	public void setShowEnd(int showEnd) {
		this.showEnd = showEnd;
	}	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getStyleClass() {
		return styleClass;
	}
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	/**
	 * 构造方法,缺省每页记录数为12、显示页码数为9、样式名字为空
	 * @param pageNo     当前页
	 * @param allCount   总记录数
	 * @param url        分页URL
	 */
	public Pagination(int pageNo, int allCount,String url) {
		this(pageNo,12,allCount,9,url,"");
	}
	/**
	 * 构造方法,缺省显示页码数为9、样式名字为空
	 * @param pageNo     当前页
	 * @param pageSize   每页记录数
	 * @param allCount   总记录数
	 * @param url        分页URL
	 */
	public Pagination(int pageNo, int pageSize, int allCount,String url) {
		this(pageNo,pageSize,allCount,9,url,"");
	}
	/**
	 * 构造方法,缺省样式名字为空
	 * @param pageNo     当前页
	 * @param pageSize   每页记录数
	 * @param allCount   总记录数
	 * @param showCount  显示页码数
	 * @param url        分页URL
	 */
	public Pagination(int pageNo, int pageSize, int allCount, int showCount ,String url) {
		this(pageNo,pageSize,allCount,showCount,url,"");
	}
	/**
	 * 构造方法
	 * @param pageNo     当前页
	 * @param pageSize   每页记录数
	 * @param allCount   总记录数
	 * @param showCount  显示页码数
	 * @param url        分页URL
	 * @param styleClass 样式名字
	 */
	public Pagination(int pageNo, int pageSize, int allCount, int showCount,String url,String styleClass) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.allCount = allCount;
		this.showCount = showCount ;
		this.url = url ;
		this.styleClass = styleClass ;
		init();
	}
	/**
	 * 初始化分页各种参数
	 */
	private void init() {
		allPage = allCount%pageSize==0 ? allCount/pageSize : allCount/pageSize+1 ;
		if(pageNo>allPage){
			pageNo = allPage ;
		}
		if (pageNo < 1) {
			pageNo = 1;
		}
		recordStart = (pageNo-1) * pageSize ;
		recordEnd = Math.min(recordStart+pageSize, allCount);
		showCount = Math.min(showCount, allPage);
		if (showCount>=allPage) {
			showStart = 1;
			showEnd = showCount;
		} else {
			if (pageNo <= (showCount+1)/2) {
				showStart = 1;
				showEnd = showCount ;
			} else if(pageNo > allPage-(showCount+1)/2 ) {
				showStart = allPage - showCount + 1 ;
				showEnd = allPage ;
			} else{
				showStart = pageNo - showCount/2;
				showEnd = showStart+showCount-1 ;		
			}	
		}
	}
	/**
	 * 获取分页数据
	 * @param <T>  范型参数
	 * @param list 需要分数的总数据集合
	 * @return
	 */
	public <T> List<T> getPageDate(List<T> list) {
		return list.subList(recordStart,recordEnd);
	}
	/**
	 * 生成页面的分页元素(分页html页面标签)
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("<div class='"+styleClass+"'>");
		if(pageNo<2){
			sb.append("<a href='#'>首  页</a>&nbsp;");
			sb.append("<a href='#'>上一页</a>&nbsp;");
		}else{
			sb.append("<a href='"+url+"?pageNo=1'>首  页</a>&nbsp;");
			sb.append("<a href='"+url+"?pageNo="+(pageNo-1)+"'>上一页</a>&nbsp;");
		}
		for (int i = showStart; i < pageNo; i++) {
			sb.append("<a href='"+url+"?pageNo="+i+"'>" + i + "</a>&nbsp;");
		}
		sb.append("<span>" + pageNo + "</span>&nbsp;");
		for (int i = pageNo + 1; i <= showEnd; i++) {
			sb.append("<a href='"+url+"?pageNo="+i+"'>" + i + "</a>&nbsp;");
		}
		if(pageNo>=allPage){
			sb.append("<a href='#'>下一页</a>&nbsp;");
			sb.append("<a href='#'>尾  页</a>&nbsp;");
		}else{
			sb.append("<a href='"+url+"?pageNo="+(pageNo+1)+"'>下一页</a>&nbsp;");
			sb.append("<a href='"+url+"?pageNo="+allPage+"'>尾  页</a>&nbsp;");
		}
		sb.append("</div>");
		return sb.toString();
	}
}

