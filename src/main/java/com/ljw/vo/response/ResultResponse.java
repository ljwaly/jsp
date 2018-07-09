package com.ljw.vo.response;

import java.util.List;

public class ResultResponse<T> extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9001434346114048203L;
	
	private List<T> resultList;

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((resultList == null) ? 0 : resultList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultResponse other = (ResultResponse) obj;
		if (resultList == null) {
			if (other.resultList != null)
				return false;
		} else if (!resultList.equals(other.resultList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultResponse [resultList=" + resultList + "]";
	}
	
	
	
	
	
	

}
