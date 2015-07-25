package cn.sharestudy.mapper.po;

import java.io.Serializable;

/**
 * 图片信息
 * @date 2014-07-27 17:23:28
 * created by tool
 */
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;//主键id

    private Integer ctype;//类型 1 文章

    private Integer targetid;//文章id

    private String url;//图片url

    private Integer estate;//是否删除 1 否  2 是

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getCtype()
    {
        return ctype;
    }

    public void setCtype(Integer ctype)
    {
        this.ctype = ctype;
    }

    public Integer getTargetid()
    {
        return targetid;
    }

    public void setTargetid(Integer targetid)
    {
        this.targetid = targetid;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Integer getEstate()
    {
        return estate;
    }

    public void setEstate(Integer estate)
    {
        this.estate = estate;
    }

    public String toString()
    {
        return "Images [id=" + this.id + ",ctype=" + this.ctype + ",targetid=" + this.targetid + ",url=" + this.url + ",estate=" + this.estate + "]"
;
    }
}
