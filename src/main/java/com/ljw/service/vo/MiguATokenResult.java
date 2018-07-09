package com.ljw.service.vo;

import java.io.Serializable;



/**
 * 咪咕云返回atoken和ftoken的信息封装类
 * 
 * @author PC
 *
 */
public class MiguATokenResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4106963288269596753L;
	
	
	private String atoken;
	private String ftoken;
	private String expired_time;
	private String timestamp;
	private User_Info user_info;

	
	@Override
	public String toString() {
		return "MiguATokenResult [atoken=" + atoken + ", ftoken=" + ftoken + ", expired_time=" + expired_time
				+ ", timestamp=" + timestamp + ", user_info=" + user_info + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atoken == null) ? 0 : atoken.hashCode());
		result = prime * result + ((expired_time == null) ? 0 : expired_time.hashCode());
		result = prime * result + ((ftoken == null) ? 0 : ftoken.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((user_info == null) ? 0 : user_info.hashCode());
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
		MiguATokenResult other = (MiguATokenResult) obj;
		if (atoken == null) {
			if (other.atoken != null)
				return false;
		} else if (!atoken.equals(other.atoken))
			return false;
		if (expired_time == null) {
			if (other.expired_time != null)
				return false;
		} else if (!expired_time.equals(other.expired_time))
			return false;
		if (ftoken == null) {
			if (other.ftoken != null)
				return false;
		} else if (!ftoken.equals(other.ftoken))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (user_info == null) {
			if (other.user_info != null)
				return false;
		} else if (!user_info.equals(other.user_info))
			return false;
		return true;
	}
	public String getAtoken() {
		return atoken;
	}
	public void setAtoken(String atoken) {
		this.atoken = atoken;
	}
	public String getFtoken() {
		return ftoken;
	}
	public void setFtoken(String ftoken) {
		this.ftoken = ftoken;
	}
	public String getExpired_time() {
		return expired_time;
	}
	public void setExpired_time(String expired_time) {
		this.expired_time = expired_time;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public User_Info getUser_info() {
		return user_info;
	}
	public void setUser_info(User_Info user_info) {
		this.user_info = user_info;
	}
	
	
	
	
	

}
