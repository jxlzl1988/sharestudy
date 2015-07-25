package cn.sharestudy.service.vo;

import cn.sharestudy.common.ImageUrlUtil;
import cn.sharestudy.mapper.po.Images;

public class ImageVo {

	private Long id;//主键id

    private Integer ctype;//类型 1 书籍介绍 2 章节内容 3 博客

    private Integer targetid;//书籍id或章节id或博客id

    private String url;//图片url
    
    private String imageurl ;//
    
    private String urlTemp ;
    
    public ImageVo(Images image, String wwwUrl) {
    	this.id = (long)image.getId() ;
    	this.ctype = image.getCtype() ;
    	this.targetid = image.getTargetid() ;
    	this.urlTemp = image.getUrl() ;
    	this.url = ImageUrlUtil.getImageTag(image.getUrl()) ;
    	this.imageurl = wwwUrl +  image.getUrl() ;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCtype() {
		return ctype;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}

	public Integer getTargetid() {
		return targetid;
	}

	public void setTargetid(Integer targetid) {
		this.targetid = targetid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getUrlTemp() {
		return urlTemp;
	}

	public void setUrlTemp(String urlTemp) {
		this.urlTemp = urlTemp;
	}
}
