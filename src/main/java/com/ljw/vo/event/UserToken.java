package com.ljw.vo.event;

import java.io.Serializable;
import java.util.List;

public class UserToken implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2147435505261781464L;
	//Y:必传;N:非必传
	/**
	 * 用户id
	 * Y
	 */
	private String userid;
	/**
	 * userNum
	 * N
	 */
	private String userNum;
	/**
	 * 操作类型: 5:修改密码,14:密码锁定
	 * Y
	 */
	private String actiontype;
	/**
	 * 操作时间(yyyyMMddhhmmssSSS)
	 * Y
	 */
	private String  actiontime;
	/**
	 * 失效的所有token
	 * Y
	 */
	private List<String> tokenList;
	
	
	
	
	@Override
	public String toString() {
		return "UserToken [userid=" + userid + ", userNum=" + userNum + ", actiontype=" + actiontype + ", actiontime="
				+ actiontime + ", tokenList=" + tokenList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actiontime == null) ? 0 : actiontime.hashCode());
		result = prime * result + ((actiontype == null) ? 0 : actiontype.hashCode());
		result = prime * result + ((tokenList == null) ? 0 : tokenList.hashCode());
		result = prime * result + ((userNum == null) ? 0 : userNum.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserToken other = (UserToken) obj;
		if (actiontime == null) {
			if (other.actiontime != null)
				return false;
		} else if (!actiontime.equals(other.actiontime))
			return false;
		if (actiontype == null) {
			if (other.actiontype != null)
				return false;
		} else if (!actiontype.equals(other.actiontype))
			return false;
		if (tokenList == null) {
			if (other.tokenList != null)
				return false;
		} else if (!tokenList.equals(other.tokenList))
			return false;
		if (userNum == null) {
			if (other.userNum != null)
				return false;
		} else if (!userNum.equals(other.userNum))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getActiontype() {
		return actiontype;
	}
	public void setActiontype(String actiontype) {
		this.actiontype = actiontype;
	}
	public String getActiontime() {
		return actiontime;
	}
	public void setActiontime(String actiontime) {
		this.actiontime = actiontime;
	}
	public List<String> getTokenList() {
		return tokenList;
	}
	public void setTokenList(List<String> tokenList) {
		this.tokenList = tokenList;
	}
	
	
	
	
}
