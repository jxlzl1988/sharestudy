package cn.sharestudy.mapper.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 类目信息(category)
 * @date 2014-07-27 16:54:42
 * created by tool
 */
public class Category implements Serializable, Comparable<Category> {

    private static final long serialVersionUID = 1L;

    private Integer id;//主键id

    private String title;//书籍标题

    private Integer sort;//排序数
    
    private Integer articlecount;//文章数

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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Integer getSort()
    {
        return sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
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

	public Integer getArticlecount() {
		return articlecount;
	}

	public void setArticlecount(Integer articlecount) {
		this.articlecount = articlecount;
	}

	public int compareTo(Category o) {
		if(this.sort > o.getSort()) {
			return 1 ;
		} else if(this.sort == o.getSort()) {
			return 0 ;
		} else {
			return -1 ;
		}
	}

}
