package com.ljw.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.httpclient.NameValuePair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.ljw.exception.UserAccountSystemException;
import com.ljw.util.HttpClientUtil;
import com.ljw.util.HttpSender;

@Service
@PropertySource("classpath:userservice-conf.properties")
public class UserAccountServiceImpl implements UserAccountService{
	private static Logger log = Logger.getLogger(UserAccountServiceImpl.class);

	
	@Value("${httpUrlPre}")
	private String httpUrlPre;
	@Value("${userInfoByIdUrl}")
	private String userInfoByIdUrl;
	@Value("${memberInfoUrl}")
	private String memberInfoUrl;
	@Value("${memberInfoForPlayUrl}")
	private String memberInfoForPlayUrl;
	@Value("${userBehaviorAddUrlLocal}")
	private String userBehaviorAddUrlLocal;
	@Value("${userBehaviorRecordCombineUrlLocal}")
	private String userBehaviorRecordCombineUrlLocal;
	@Value("${userBehaviorRecordQueryUrlLocal}")
	private String userBehaviorRecordQueryUrlLocal;
	@Value("${userInterestTagAddUrlLocal}")
	private String userInterestTagAddUrlLocal;
	@Value("${userInterestTagQueryUrlLocal}")
	private String userInterestTagQueryUrlLocal;
	@Value("${userInterestTagCombineUrlLocal}")
	private String userInterestTagCombineUrlLocal;
	@Value("${mobileProvinceIdAndOperatorUrl}")
	private String mobileProvinceIdAndOperatorUrl;
	
	@Value("${httpUrlPre_flow}")
	private String httpUrlPre_flow;
	@Value("${userBindFlowPhoneUrl}")
	private String userBindFlowPhoneUrl;
	@Value("${userGetFlowPhoneUrl}")
	private String userGetFlowPhoneUrl;
	
	
	


	@Override
	public String getById(String clientId, String userId, String userToken, String accessToken) throws UserAccountSystemException {
		Map<String, String> requestMap = new HashMap<String, String>();
		if(userId != null && !"".equals(userId)) {
			requestMap.put("userId", userId);
		}
		if(userToken != null && !"".equals(userToken)) {
			requestMap.put("userToken", userToken);
		}
		if(accessToken != null && !"".equals(accessToken)) {
			requestMap.put("accessToken", accessToken);
		}
		String requestParam = "";
		try {
			requestParam = JSON.toJSONString(requestMap);
		} catch(JSONException e) {
			throw new UserAccountSystemException(UserAccountSystemException.REQPARAM_INVALID, "REQPARAM_INVALID");
		}
		 
		String sign = "xxx";//TODO
		String queryString;
		try {
			queryString = "request=" + URLEncoder.encode(requestParam, "utf-8") + "&clientId=" + clientId + "&sign=" + sign;
		} catch (UnsupportedEncodingException e) {
			throw new UserAccountSystemException(UserAccountSystemException.UNSUPPORTED_ENCODING, "UNSUPPORTED_ENCODING");
		}
		String url = httpUrlPre + userInfoByIdUrl + "?" + queryString;
		log.debug("url:" + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("userId", userId);
		headers.put("userToken", userToken);
		headers.put("accessToken", accessToken);
		return HttpClientUtil.httpClientGet(url, headers);
	}

	@Override
	public String queryMemInfo(String clientId, String userId, String userToken, String accessToken) throws UserAccountSystemException {
		Map<String, String> requestMap = new HashMap<String, String>();
		if(userId != null && !"".equals(userId)) {
			requestMap.put("userId", userId);
		}
		if(userToken != null && !"".equals(userToken)) {
			requestMap.put("userToken", userToken);
		}
		if(accessToken != null && !"".equals(accessToken)) {
			requestMap.put("accessToken", accessToken);
		}
		String requestParam = "";
		try {
			requestParam = JSON.toJSONString(requestMap);
		} catch(JSONException e) {
			throw new UserAccountSystemException(UserAccountSystemException.REQPARAM_INVALID, "REQPARAM_INVALID");
		}
		
//		String sign = AesEncryption.encrypt(data, AES_KEY);
		String sign = "xxx";//TODO
		String queryString;
		try {
			queryString = "request=" + URLEncoder.encode(requestParam, "utf-8") + "&clientId=" + clientId + "&sign=" + sign;
		} catch (UnsupportedEncodingException e) {
			throw new UserAccountSystemException(UserAccountSystemException.UNSUPPORTED_ENCODING, "UNSUPPORTED_ENCODING");
		}
		String url = httpUrlPre + memberInfoUrl + "?" + queryString;
				
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("userId", userId);
		headers.put("userToken", userToken);
		headers.put("accessToken", accessToken);
		return HttpClientUtil.httpClientGet(url, headers);
	}

	
	@Override
	public String queryMemInfoForPlay(String clientId, String userId, String userToken, String accessToken) throws UserAccountSystemException {
		Map<String, String> requestMap = new HashMap<String, String>();
		if(userId != null && !"".equals(userId)) {
			requestMap.put("userId", userId);
		}
		if(userToken != null && !"".equals(userToken)) {
			requestMap.put("userToken", userToken);
		}
		if(accessToken != null && !"".equals(accessToken)) {
			requestMap.put("accessToken", accessToken);
		}
		String timestamp = new Date().getTime()+"";

		requestMap.put("timestamp", timestamp);
		

		String requestParam = "";
		try {
			requestParam = JSON.toJSONString(requestMap);
		} catch(JSONException e) {
			throw new UserAccountSystemException(UserAccountSystemException.REQPARAM_INVALID, "REQPARAM_INVALID");
		}
		
//		String sign = AesEncryption.encrypt(data, AES_KEY);
		String sign = "xxx";//TODO
		String queryString;
		
		try {
			queryString = "request=" + URLEncoder.encode(requestParam, "utf-8") + "&clientId=" + clientId + "&sign=" + sign;
		} catch (UnsupportedEncodingException e) {
			throw new UserAccountSystemException(UserAccountSystemException.UNSUPPORTED_ENCODING, "UNSUPPORTED_ENCODING");
		}
		String url = httpUrlPre + memberInfoForPlayUrl + "?" + queryString;
				
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("userId", userId);
		headers.put("userToken", userToken);
		headers.put("accessToken", accessToken);
		return HttpClientUtil.httpClientGet(url, headers);
	}
	
	
	@Override
	public String combineUserBehaviorRecord(String clientId, String userId, String userToken, String accessToken, String resourceUserId, String targetUserId) throws UserAccountSystemException{
		Map<String, String> requestHeaders = new HashMap<String, String>();
		if(userId != null && !"".equals(userId)) {
			requestHeaders.put("userId", userId);
		}
		if(userToken != null && !"".equals(userToken)) {
			requestHeaders.put("userToken", userToken);
		}
		if(accessToken != null && !"".equals(accessToken)) {
			requestHeaders.put("accessToken", accessToken);
		}
		requestHeaders.put("Content-Type", "application/json;charset=UTF-8");
		
		Map<String, Object> paramValue = new HashMap<String, Object>();
		if(resourceUserId != null && !"".equals(resourceUserId)) {
			paramValue.put("resourceUserId", resourceUserId);
		}
		if(targetUserId != null && !"".equals(targetUserId)) {
			paramValue.put("targetUserId", targetUserId);
		}
		String body = "";
		try {
			body = JSON.toJSONString(paramValue);
		} catch(JSONException e) {
			throw new UserAccountSystemException(UserAccountSystemException.REQPARAM_INVALID, "REQPARAM_INVALID");
		}

		String sign = "xxx";
		Map<String, Object> urlParam = new HashMap<String, Object>();
		urlParam.put("clientId", clientId);
		urlParam.put("sign", sign);
		NameValuePair[] values = HttpSender.praseParameterMap(urlParam);
		
		String userBehaviorRecordCombineUrl = httpUrlPre + userBehaviorRecordCombineUrlLocal;
		
//		log.error("url:" + userBehaviorRecordCombineUrl + ",urlParam:" + urlParam + ",body:" + body + ",requestHeaders:" + requestHeaders );
		
		return HttpSender.httpPost(userBehaviorRecordCombineUrl, values , body, requestHeaders);
	}
	
	@Override
	public String queryUserBehaviorRecord(String clientId, String userId, String userToken, String accessToken, String startTime, String endTime, String actionType)throws UserAccountSystemException{
		Map<String, String> requestMap = new HashMap<String, String>();
		if(userId != null && !"".equals(userId)) {
			requestMap.put("userId", userId);
		}
		if(userToken != null && !"".equals(userToken)) {
			requestMap.put("userToken", userToken);
		}
		if(accessToken != null && !"".equals(accessToken)) {
			requestMap.put("accessToken", accessToken);
		}
		if(startTime != null && !"".equals(startTime)) {
			requestMap.put("startTime", startTime);
		}
		if(endTime != null && !"".equals(endTime)) {
			requestMap.put("endTime", endTime);
		}
		if(actionType != null && !"".equals(actionType)) {
			requestMap.put("actionType", actionType);
		}
		String requestParam = "";
		try {
			requestParam = JSON.toJSONString(requestMap);
		} catch(JSONException e) {
			throw new UserAccountSystemException(UserAccountSystemException.REQPARAM_INVALID, "REQPARAM_INVALID");
		}
		
		String sign = "xxx";
		String queryString;
		try {
			queryString = "request=" + URLEncoder.encode(requestParam, "utf-8") + "&clientId=" + clientId + "&sign=" + sign;
		} catch (UnsupportedEncodingException e) {
			throw new UserAccountSystemException(UserAccountSystemException.UNSUPPORTED_ENCODING, "UNSUPPORTED_ENCODING");
		}
		
		String userBehaviorRecordQueryUrl = httpUrlPre + userBehaviorRecordQueryUrlLocal;
		String url = userBehaviorRecordQueryUrl + "?" + queryString;
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("userId", userId);
		headers.put("userToken", userToken);
		headers.put("accessToken", accessToken);
		
//		log.error("url:" + url + ",headers:" + headers);
		return HttpClientUtil.httpClientGet(url, headers);
	}

	@Override
	public String addUserInterestTag(String clientId, String userId, String userToken, String accessToken, String tags, String userType)throws UserAccountSystemException{
		Map<String, String> requestHeaders = new HashMap<String, String>();
		if(userId != null && !"".equals(userId)) {
			requestHeaders.put("userId", userId);
		}
		if(userToken != null && !"".equals(userToken)) {
			requestHeaders.put("userToken", userToken);
		}
		if(accessToken != null && !"".equals(accessToken)) {
			requestHeaders.put("accessToken", accessToken);
		}
		requestHeaders.put("Content-Type", "application/json;charset=UTF-8");
		
		Map<String, Object> paramValue = new HashMap<String, Object>();
		if(tags != null && !"".equals(tags)) {
			paramValue.put("tags", tags);
		}
		if(userType != null && !"".equals(userType)) {
			paramValue.put("userType", userType);
		}	
		String body = "";
		try {
			body = JSON.toJSONString(paramValue);
		} catch(JSONException e) {
			throw new UserAccountSystemException(UserAccountSystemException.REQPARAM_INVALID, "REQPARAM_INVALID");
		}
		
		String sign = "xxx";
		Map<String, Object> urlParam = new HashMap<String, Object>();
		urlParam.put("clientId", clientId);
		urlParam.put("sign", sign);
		NameValuePair[] values = HttpSender.praseParameterMap(urlParam);
		
		String userInterestTagAddUrl = httpUrlPre + userInterestTagAddUrlLocal;
//		log.error("url:" + userInterestTagAddUrl + ",urlParam:" + urlParam + ",body:" + body + ",requestHeaders:" + requestHeaders );
		return HttpSender.httpPost(userInterestTagAddUrl, values , body, requestHeaders);
	}

	@Override
	public String queryUserInterestTag(String clientId, String userId, String userToken, String accessToken)throws UserAccountSystemException{
		Map<String, String> requestMap = new HashMap<String, String>();
		if(userId != null && !"".equals(userId)) {
			requestMap.put("userId", userId);
		}
		if(userToken != null && !"".equals(userToken)) {
			requestMap.put("userToken", userToken);
		}
		if(accessToken != null && !"".equals(accessToken)) {
			requestMap.put("accessToken", accessToken);
		}
		String requestParam = "";
		try {
			requestParam = JSON.toJSONString(requestMap);
		} catch(JSONException e) {
			throw new UserAccountSystemException(UserAccountSystemException.REQPARAM_INVALID, "REQPARAM_INVALID");
		}
		String sign = "xxx";
		String queryString;
		try {
			queryString = "request=" + URLEncoder.encode(requestParam, "utf-8") + "&clientId=" + clientId + "&sign=" + sign;
		} catch (UnsupportedEncodingException e) {
			throw new UserAccountSystemException(UserAccountSystemException.UNSUPPORTED_ENCODING, "UNSUPPORTED_ENCODING");
		}
		String userInterestTagQueryUrl = httpUrlPre + userInterestTagQueryUrlLocal;
		String url = userInterestTagQueryUrl + "?" + queryString;
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("userId", userId);
		headers.put("userToken", userToken);
		headers.put("accessToken", accessToken);
		
//		log.error("url:" + url + ",headers:" + headers);
		return HttpClientUtil.httpClientGet(url, headers);
	}
	
	@Override
	public String combineUserInterestTag(String clientId, String userId, String userToken, String accessToken, String resourceUserId, String targetUserId) throws UserAccountSystemException{
		Map<String, String> requestHeaders = new HashMap<String, String>();
		if(userId != null && !"".equals(userId)) {
			requestHeaders.put("userId", userId);
		}
		if(userToken != null && !"".equals(userToken)) {
			requestHeaders.put("userToken", userToken);
		}
		if(accessToken != null && !"".equals(accessToken)) {
			requestHeaders.put("accessToken", accessToken);
		}
		requestHeaders.put("Content-Type", "application/json;charset=UTF-8");
		
		Map<String, Object> paramValue = new HashMap<String, Object>();
		if(resourceUserId != null && !"".equals(resourceUserId)) {
			paramValue.put("resourceUserId", resourceUserId);
		}
		if(targetUserId != null && !"".equals(targetUserId)) {
			paramValue.put("targetUserId", targetUserId);
		}
		String body = "";
		try {
			body = JSON.toJSONString(paramValue);
		} catch(JSONException e) {
			throw new UserAccountSystemException(UserAccountSystemException.REQPARAM_INVALID, "REQPARAM_INVALID");
		}

		String sign = "xxx";
		Map<String, Object> urlParam = new HashMap<String, Object>();
		urlParam.put("clientId", clientId);
		urlParam.put("sign", sign);
		NameValuePair[] values = HttpSender.praseParameterMap(urlParam);
		
		String userInterestTagCombineUrl = httpUrlPre + userInterestTagCombineUrlLocal;
//		log.error("url:" + userInterestTagCombineUrl + ",urlParam:" + urlParam + ",body:" + body + ",requestHeaders:" + requestHeaders );
		return HttpSender.httpPost(userInterestTagCombineUrl, values , body, requestHeaders);	
	}
	
	public String getMobileProvinceIdAndOperator(String clientId, String mobile) throws UserAccountSystemException{
		Map<String, Object> requestMap = new HashMap<String, Object>();
		if (!"".equals(mobile) && mobile!=null){
			requestMap.put("mobile", mobile);
		}
		long timestamp = new Date().getTime();
		requestMap.put("timestamp", timestamp);
		String requestParam = "";
		try {
			requestParam = JSON.toJSONString(requestMap);
		} catch(JSONException e) {
			throw new UserAccountSystemException(UserAccountSystemException.REQPARAM_INVALID, "REQPARAM_INVALID");
		}
		
		String sign = "xxx";//TODO
		String queryString;
		try {
			queryString = "request=" + URLEncoder.encode(requestParam, "utf-8") + "&clientId=" + clientId + "&sign=" + sign;
		} catch (UnsupportedEncodingException e) {
			throw new UserAccountSystemException(UserAccountSystemException.UNSUPPORTED_ENCODING, "UNSUPPORTED_ENCODING");
		}
		String url = httpUrlPre + mobileProvinceIdAndOperatorUrl + "?" + queryString;
		//log.error("UserAccountServiceImpl:getMobileProvinceIdAndOperator" + "[" + "queryString" + queryString + ",url" + url + "]");
		log.debug("url:" + url);
		Map<String, String> headers = new HashMap<String, String>();
		return HttpClientUtil.httpClientGet(url, headers);	
	}
	
	@Override
	public String bindFlowPhone(String clientId, String userId, String phoneNum, Map<String, Object> extInfo)
			throws UserAccountSystemException {
		
		Map<String, Object> paramValue = new HashMap<String, Object>();
		paramValue.put("userId", userId);
		paramValue.put("phoneNum", phoneNum);
		long timestamp = new Date().getTime();
		paramValue.put("timestamp", timestamp);
		paramValue.put("extInfo", extInfo);
		String body = "";
		try {
			body = JSON.toJSONString(paramValue);
		} catch(JSONException e) {
			throw new UserAccountSystemException(UserAccountSystemException.REQPARAM_INVALID, "REQPARAM_INVALID");
		}
		
		String sign = "xxx";//TODO
		
		Map<String, Object> urlParam = new HashMap<String, Object>();
		urlParam.put("clientId", clientId);
		urlParam.put("sign", sign);
		urlParam.put("signType", "AES");
		NameValuePair[] values = HttpSender.praseParameterMap(urlParam);
		String url = httpUrlPre_flow + userBindFlowPhoneUrl;
		return HttpSender.httpPost(url, values , body);	
	}

	@Override
	public String getFlowPhone(String clientId, String userId) throws UserAccountSystemException {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		
		long timestamp = new Date().getTime();
		requestMap.put("timestamp", timestamp);
		requestMap.put("userId", userId);
		
		String requestParam = "";
		try {
			requestParam = JSON.toJSONString(requestMap);
		} catch(JSONException e) {
			throw new UserAccountSystemException(UserAccountSystemException.REQPARAM_INVALID, "REQPARAM_INVALID");
		}
		
		String sign = "xxx";//TODO
		String signType = "AES";
		
		String queryString;
		try {
			queryString = "request=" + URLEncoder.encode(requestParam, "utf-8") + "&clientId=" + clientId + "&sign=" + sign +"&signType="+signType;
		} catch (UnsupportedEncodingException e) {
			throw new UserAccountSystemException(UserAccountSystemException.UNSUPPORTED_ENCODING, "UNSUPPORTED_ENCODING");
		}
		String url = httpUrlPre_flow + mobileProvinceIdAndOperatorUrl + "?" + queryString;
		log.debug("url:" + url);
		
		Map<String, String> headers = new HashMap<String, String>();
		
		
		return HttpClientUtil.httpClientGet(url, headers);	
	}
	
	
	
		
	public String getUserInfoByIdUrl() {
		return userInfoByIdUrl;
	}

	public void setUserInfoByIdUrl(String userInfoByIdUrl) {
		this.userInfoByIdUrl = userInfoByIdUrl;
	}

	public String getMemberInfoUrl() {
		return memberInfoUrl;
	}

	public void setMemberInfoUrl(String memberInfoUrl) {
		this.memberInfoUrl = memberInfoUrl;
	}

	public String getMemberInfoForPlayUrl() {
		return memberInfoForPlayUrl;
	}

	public void setMemberInfoForPlayUrl(String memberInfoForPlayUrl) {
		this.memberInfoForPlayUrl = memberInfoForPlayUrl;
	}

	public String getHttpUrlPre() {
		return httpUrlPre;
	}

	public void setHttpUrlPre(String httpUrlPre) {
		this.httpUrlPre = httpUrlPre;
	}

	public String getUserBehaviorAddUrlLocal() {
		return userBehaviorAddUrlLocal;
	}

	public void setUserBehaviorAddUrlLocal(String userBehaviorAddUrlLocal) {
		this.userBehaviorAddUrlLocal = userBehaviorAddUrlLocal;
	}

	public String getUserBehaviorRecordCombineUrlLocal() {
		return userBehaviorRecordCombineUrlLocal;
	}

	public void setUserBehaviorRecordCombineUrlLocal(
			String userBehaviorRecordCombineUrlLocal) {
		this.userBehaviorRecordCombineUrlLocal = userBehaviorRecordCombineUrlLocal;
	}

	public String getUserBehaviorRecordQueryUrlLocal() {
		return userBehaviorRecordQueryUrlLocal;
	}

	public void setUserBehaviorRecordQueryUrlLocal(
			String userBehaviorRecordQueryUrlLocal) {
		this.userBehaviorRecordQueryUrlLocal = userBehaviorRecordQueryUrlLocal;
	}

	public String getUserInterestTagAddUrlLocal() {
		return userInterestTagAddUrlLocal;
	}

	public void setUserInterestTagAddUrlLocal(String userInterestTagAddUrlLocal) {
		this.userInterestTagAddUrlLocal = userInterestTagAddUrlLocal;
	}

	public String getUserInterestTagQueryUrlLocal() {
		return userInterestTagQueryUrlLocal;
	}

	public void setUserInterestTagQueryUrlLocal(String userInterestTagQueryUrlLocal) {
		this.userInterestTagQueryUrlLocal = userInterestTagQueryUrlLocal;
	}

	public String getUserInterestTagCombineUrlLocal() {
		return userInterestTagCombineUrlLocal;
	}

	public void setUserInterestTagCombineUrlLocal(
			String userInterestTagCombineUrlLocal) {
		this.userInterestTagCombineUrlLocal = userInterestTagCombineUrlLocal;
	}

	public String getMobileProvinceIdAndOperatorUrl() {
		return mobileProvinceIdAndOperatorUrl;
	}

	public void setMobileProvinceIdAndOperatorUrl(
			String mobileProvinceIdAndOperatorUrl) {
		this.mobileProvinceIdAndOperatorUrl = mobileProvinceIdAndOperatorUrl;
	}

	public String getHttpUrlPre_flow() {
		return httpUrlPre_flow;
	}

	public void setHttpUrlPre_flow(String httpUrlPre_flow) {
		this.httpUrlPre_flow = httpUrlPre_flow;
	}
	
	public String getUserBindFlowPhoneUrl() {
		return userBindFlowPhoneUrl;
	}

	public void setUserBindFlowPhoneUrl(String userBindFlowPhoneUrl) {
		this.userBindFlowPhoneUrl = userBindFlowPhoneUrl;
	}

	public String getUserGetFlowPhoneUrl() {
		return userGetFlowPhoneUrl;
	}

	public void setUserGetFlowPhoneUrl(String userGetFlowPhoneUrl) {
		this.userGetFlowPhoneUrl = userGetFlowPhoneUrl;
	}

	

	

}
