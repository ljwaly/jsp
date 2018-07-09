package com.ljw.service.vo;

import java.io.Serializable;



/**
 * 咪咕云返回的atoken携带的一些参数
 * @author PC
 *
 */
public class User_Info implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5044828572579385245L;

	private String uid;
	private String uname;
	private String utype;
	
	
	
	@Override
	public String toString() {
		return "User_Info [uid=" + uid + ", uname=" + uname + ", utype=" + utype + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		result = prime * result + ((utype == null) ? 0 : utype.hashCode());
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
		User_Info other = (User_Info) obj;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		if (utype == null) {
			if (other.utype != null)
				return false;
		} else if (!utype.equals(other.utype))
			return false;
		return true;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	
	
	
	
}
