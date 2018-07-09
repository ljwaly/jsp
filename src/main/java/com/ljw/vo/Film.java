package com.ljw.vo;

import java.io.Serializable;

public class Film implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9178405656894119459L;
	/**
	 * 节目ID varchar(30)
	 */
	private String prdContId;
	/**
	 * 影片名称 varchar(200)
	 */
	private String filmName;
	/**
	 * 影片ID varchar(50)
	 */
	private String filmId;
	/**
	 * 上映日期 varchar(50)
	 */
	private String playDate;
	/**
	 * 影片场次Number(10)
	 */
	private int showCount;
	/**
	 * 活动ID varchar(30)
	 */
	private String activeId;
	/**
	 * 活动url varchar(200)
	 */
	private String url;
	/**
	 * 影片序号
	 */
	private String filmSeq;
	
	
	/**
	 * 20170327
	 * 新增：上映时间标识位（0-国内首映时间；1-待映日期）
	 */
	private String playDateType;
         	
	
	/**
	 * 20170327
	 * 按城市:即将上映
	 * 城市代码varchar(30)
	 */
	private String cityId;
	
	/**
	 * 20170327
	 * 按城市:即将上映
	 * 场次数varchar(10)
	 */
	private String num;
	
	/**
	 * 20170327
	 * 按城市:即将上映
	 * 是否预售varchar(5)
	 * 0-想看，1-预售
	 */
	private String isPreSale;

	public String getPrdContId() {
		return prdContId;
	}

	public void setPrdContId(String prdContId) {
		this.prdContId = prdContId;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getFilmId() {
		return filmId;
	}

	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}

	public String getPlayDate() {
		return playDate;
	}

	public void setPlayDate(String playDate) {
		this.playDate = playDate;
	}

	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}

	public String getActiveId() {
		return activeId;
	}

	public void setActiveId(String activeId) {
		this.activeId = activeId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFilmSeq() {
		return filmSeq;
	}

	public void setFilmSeq(String filmSeq) {
		this.filmSeq = filmSeq;
	}

	public String getPlayDateType() {
		return playDateType;
	}

	public void setPlayDateType(String playDateType) {
		this.playDateType = playDateType;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getIsPreSale() {
		return isPreSale;
	}

	public void setIsPreSale(String isPreSale) {
		this.isPreSale = isPreSale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeId == null) ? 0 : activeId.hashCode());
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
		result = prime * result + ((filmId == null) ? 0 : filmId.hashCode());
		result = prime * result + ((filmName == null) ? 0 : filmName.hashCode());
		result = prime * result + ((filmSeq == null) ? 0 : filmSeq.hashCode());
		result = prime * result + ((isPreSale == null) ? 0 : isPreSale.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((playDate == null) ? 0 : playDate.hashCode());
		result = prime * result + ((playDateType == null) ? 0 : playDateType.hashCode());
		result = prime * result + ((prdContId == null) ? 0 : prdContId.hashCode());
		result = prime * result + showCount;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Film other = (Film) obj;
		if (activeId == null) {
			if (other.activeId != null)
				return false;
		} else if (!activeId.equals(other.activeId))
			return false;
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		if (filmId == null) {
			if (other.filmId != null)
				return false;
		} else if (!filmId.equals(other.filmId))
			return false;
		if (filmName == null) {
			if (other.filmName != null)
				return false;
		} else if (!filmName.equals(other.filmName))
			return false;
		if (filmSeq == null) {
			if (other.filmSeq != null)
				return false;
		} else if (!filmSeq.equals(other.filmSeq))
			return false;
		if (isPreSale == null) {
			if (other.isPreSale != null)
				return false;
		} else if (!isPreSale.equals(other.isPreSale))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (playDate == null) {
			if (other.playDate != null)
				return false;
		} else if (!playDate.equals(other.playDate))
			return false;
		if (playDateType == null) {
			if (other.playDateType != null)
				return false;
		} else if (!playDateType.equals(other.playDateType))
			return false;
		if (prdContId == null) {
			if (other.prdContId != null)
				return false;
		} else if (!prdContId.equals(other.prdContId))
			return false;
		if (showCount != other.showCount)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film [prdContId=" + prdContId + ", filmName=" + filmName + ", filmId=" + filmId + ", playDate="
				+ playDate + ", showCount=" + showCount + ", activeId=" + activeId + ", url=" + url + ", filmSeq="
				+ filmSeq + ", playDateType=" + playDateType + ", cityId=" + cityId + ", num=" + num + ", isPreSale="
				+ isPreSale + "]";
	}

		
	
}
