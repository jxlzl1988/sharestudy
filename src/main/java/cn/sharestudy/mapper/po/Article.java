package cn.sharestudy.mapper.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章数据(article)
 * @date 2014-07-27 17:23:28
 * created by tool
 */
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;//主键id

    private Integer categoryid;//分类id

    private String title;//文章标题

    private String content;//文章内容

    private Integer sort;//排序数

    private Integer readnum;//浏览数

    private String digest;//摘要
    
    private String keywords;//关键字

    private String bdtext;//分享内容

    private String bddesc;//分享摘要

    private String bdurl;//分享url

    private String bdpic;//分享图片url

    private Integer eshow;//是否显示 1是 2 否
    
    private Integer estate;//是否有效 1有效 2 无效

    private Date createtime;//创建时间

    private Date updatetime;//修改时间

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getCategoryid()
    {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid)
    {
        this.categoryid = categoryid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Integer getSort()
    {
        return sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public Integer getReadnum()
    {
        return readnum;
    }

    public void setReadnum(Integer readnum)
    {
        this.readnum = readnum;
    }

    public String getDigest()
    {
        return digest;
    }

    public void setDigest(String digest)
    {
        this.digest = digest;
    }

    public String getBdtext()
    {
        return bdtext;
    }

    public void setBdtext(String bdtext)
    {
        this.bdtext = bdtext;
    }

    public String getBddesc()
    {
        return bddesc;
    }

    public void setBddesc(String bddesc)
    {
        this.bddesc = bddesc;
    }

    public String getBdurl()
    {
        return bdurl;
    }

    public void setBdurl(String bdurl)
    {
        this.bdurl = bdurl;
    }

    public String getBdpic()
    {
        return bdpic;
    }

    public void setBdpic(String bdpic)
    {
        this.bdpic = bdpic;
    }

    public Integer getEstate()
    {
        return estate;
    }

    public void setEstate(Integer estate)
    {
        this.estate = estate;
    }

    public Date getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public Date getUpdatetime()
    {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime)
    {
        this.updatetime = updatetime;
    }

	public Integer getEshow() {
		return eshow;
	}

	public void setEshow(Integer eshow) {
		this.eshow = eshow;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}
