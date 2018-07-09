package com.ljw.vo.response;

import java.io.Serializable;


/**
 * 返回结果父类
 * @author PC
 *
 */
public class BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5754778664446661692L;

	// 返回代码
	protected String resultCode;
	// 返回描述
	protected String resultDesc;
	
	
	public BaseResponse() {
	}


	public BaseResponse(String resultCode, String resultDesc) {
		this.resultCode = resultCode;
		this.resultDesc = resultDesc;
	}


	@Override
	public String toString() {
		return "BaseResponse [resultCode=" + resultCode + ", resultDesc=" + resultDesc + "]";
	}
	
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultDesc() {
		return resultDesc;
	}
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resultCode == null) ? 0 : resultCode.hashCode());
		result = prime * result + ((resultDesc == null) ? 0 : resultDesc.hashCode());
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
		BaseResponse other = (BaseResponse) obj;
		if (resultCode == null) {
			if (other.resultCode != null)
				return false;
		} else if (!resultCode.equals(other.resultCode))
			return false;
		if (resultDesc == null) {
			if (other.resultDesc != null)
				return false;
		} else if (!resultDesc.equals(other.resultDesc))
			return false;
		return true;
	}
	
	
	
	

}
