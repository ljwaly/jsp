package com.ljw.service;

import java.util.Map;

import com.ljw.exception.UserAccountSystemException;



/**
 * 用户管理组件接口
 * @author Administrator
 *
 */
public interface UserAccountService {
	/**
	 * 获取用户信息（根据serId）
	 * @param clientId
	 * @param userId
	 * @param userToken
	 * @param accessToken
	 * @return
	 * @throws UserAccountSystemException
	 */
	public String getById(String clientId, String userId, String userToken, String accessToken) throws UserAccountSystemException;
	
	/**
	 * 获取会员信息
	 * @param clientId
	 * @param userId
	 * @param userToken
	 * @param accessToken
	 * @return
	 * @throws UserAccountSystemException
	 */
	public String queryMemInfo(String clientId, String userId, String userToken, String accessToken) throws UserAccountSystemException;

	

	/**
	 * 获取会员播放信息
	 * @param clientId
	 * @param userId
	 * @param userToken
	 * @param accessToken
	 * @return
	 * @throws UserAccountSystemException
	 */
	public String queryMemInfoForPlay(String clientId, String userId, String userToken, String accessToken) throws UserAccountSystemException;

	/**
	 * 用户行为记录合并
	 * @param clientId
	 * @param userId
	 * @param userToken
	 * @param accessToken
	 * @param resourceUserId
	 * @param targetUserId
 	 * @return
	 * @throws UserAccountSystemException
	 */
	public String combineUserBehaviorRecord(String clientId, String userId, String userToken, String accessToken, String resourceUserId, String targetUserId) throws UserAccountSystemException;
	
	/**
	 * 用户行为记录查询
	 * @param clientId
	 * @param userId
	 * @param userToken
	 * @param accessToken
	 * @param startTime
	 * @param endTime
	 * @param actionType
	 * @return
	 * @throws UserAccountSystemException
	 */
	public String queryUserBehaviorRecord(String clientId, String userId, String userToken, String accessToken, String startTime, String endTime, String actionType) throws UserAccountSystemException;
	
	/**
	 * 用户兴趣标签新增
	 * @param clientId
	 * @param userId
	 * @param userToken
	 * @param accessToken
	 * @param tags
	 * @param userType
	 * @return
	 * @throws UserAccountSystemException
	 */
	public String addUserInterestTag(String clientId, String userId, String userToken, String accessToken, String tags, String userType) throws UserAccountSystemException;
	
	/**
	 * 用户兴趣标签查询
	 * @param clientId
	 * @param userId
	 * @param userToken
	 * @param accessToken
	 * @return
	 * @throws UserAccountSystemException
	 */
	public String queryUserInterestTag(String clientId, String userId, String userToken, String accessToken) throws UserAccountSystemException;

	/**
	 * 用户兴趣标签合并
	 * @param clientId
	 * @param userId
	 * @param userToken
	 * @param accessToken
	 * @param resourceUserId
	 * @param targetUserId
 	 * @return
	 * @throws UserAccountSystemException
	 */
	public String combineUserInterestTag(String clientId, String userId, String userToken, String accessToken, String resourceUserId, String targetUserId) throws UserAccountSystemException;
	
	/**
	 * 获取手机号省份id及手机号运营商
	 * @param clientId
	 * @param mobile
 	 * @return
	 * @throws UserAccountSystemException
	 */
	public String getMobileProvinceIdAndOperator(String clientId, String mobile) throws UserAccountSystemException;
	
	/**
	 * 免流量手机号绑定及变更
	 * @param userId
	 * @param phoneNum
	 * @param extInfo
	 * @return
	 */
	public String bindFlowPhone(String clientId, String userId, String phoneNum, Map<String, Object> extInfo) throws UserAccountSystemException;

	/**
	 * 免流量手机号查询(根据userId，使用get请求)
	 * @param clientId
	 * @param userId
	 * @return
	 * @throws UserAccountSystemException
	 */
	public String getFlowPhone(String clientId, String userId) throws UserAccountSystemException;

}
