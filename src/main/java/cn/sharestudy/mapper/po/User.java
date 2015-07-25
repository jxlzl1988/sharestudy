package cn.sharestudy.mapper.po;

import java.io.Serializable;

/**
 * 用户数据(article)
 * @date 2014-07-27 17:23:28
 * created by tool
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;//主键id

    private String username;//文章标题

    private String password;//文章内容

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
