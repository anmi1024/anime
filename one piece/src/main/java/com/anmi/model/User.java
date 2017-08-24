package com.anmi.model;

import com.anmi.annotation.Column;
import com.anmi.annotation.Entity;

import java.io.Serializable;

@Entity("gafis_authorize_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column("PK_ID")
	private String pkId;		//主键UUID
    @Column("USERNAME")
	private String userName;	//用户名
    @Column("PASSWORD")
	private String passWord;	//密码
    @Column("NAME")
	private String name;		//姓名
    @Column("DELTAG")
	private long delTag;		//删除标记(1:正常;0:删除)

	public String getPkId() {
		return pkId;
	}
	public void setPkId(String pkId) {
		this.pkId = pkId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDelTag() {
		return delTag;
	}
	public void setDelTag(long delTag) {
		this.delTag = delTag;
	}



}
