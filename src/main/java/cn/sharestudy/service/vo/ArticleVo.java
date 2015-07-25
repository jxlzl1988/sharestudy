package cn.sharestudy.service.vo;

import java.io.Serializable;

import cn.sharestudy.mapper.po.Article;

/**
 * book 章节详细内容
 *
 */
public class ArticleVo implements Serializable, Comparable<ArticleVo>{

	private static final long serialVersionUID = 1L;

    private Integer id;//主键id
    private Integer categoryid;//分类id
    private String title;//文章标题
    private Integer sort;//排序数
    private Integer eshow ;// 是否显示 1是 2 否
    
    public ArticleVo(Article article) {
    	this.id = article.getId() ;
    	this.categoryid = article.getCategoryid() ;
    	this.title = article.getTitle()	;
    	this.sort = article.getSort() ;
    	this.eshow = article.getEshow() ;
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getEshow() {
		return eshow;
	}

	public void setEshow(Integer eshow) {
		this.eshow = eshow;
	}

	public int compareTo(ArticleVo o) {
		if(this.sort > o.getSort()) {
			return 1 ;
		} else if(this.sort == o.getSort()) {
			return 0 ;
		} else {
			return -1 ;
		}
	}
}
