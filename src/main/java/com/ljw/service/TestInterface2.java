package com.ljw.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ljw.log.HttpInterceptor;
import com.ljw.service.vo.MiguATokenResult;
import com.ljw.util.DESUtil;
import com.ljw.util.HttpClientUtil;
import com.ljw.util.HttpSender;
import com.ljw.util.MD5Util;


/**
 * 
 * 
 * 如果有远程接口，可以使用这个进行解析测试
 * 
 * @author PC
 *
 */
@Component
public class TestInterface2 {
	
	
	private static Logger log = Logger.getLogger(TestInterface2.class);
	
	/**
	 * cc_validate的DES加密盐值
	 */
	private static String CC_VALIDATE_DES_KEY = "des_ccm_all_card_service";
	
	/**
	 * cc_validate的MD5加密盐值
	 */
	private static final String CC_VALIDATE_MD5_SALT = "md5_ccm_card_service";
	
	
	/**
	 * 加密方式
	 */
	private static final String MD5 = "MD5";
	
	
	
	@Autowired
	private MyHttpService httpService;

	
	public Map<String, Object> getResultMap(){
		
		//url
		String url= "http://117.131.17.119:80/ccm/cc_cancel.html";
		
		
		
		String cardPass = "VLRNKJUJ98885618";
		String userId = "543626518";
		String logout = "0";
		String mobile = "15902188397";
		String remark = "";
		
		
		String preCardPass = this.pre(cardPass);
		
		String cardPassDES = DESUtil.encryptMode(preCardPass, CC_VALIDATE_DES_KEY);
		
	
		
		String signSource = "cardPass=" + preCardPass + "&logout=" + logout;
		//创建带有盐值的MD5加密对象
		MD5Util md = new MD5Util(CC_VALIDATE_MD5_SALT, MD5);
		//通过md5加密生成sign
		String sign = md.encode(signSource);
		if (sign == null || "".equals(sign)) {
			
		}
		
		String url1 = url + "?" + "cardPass=" + cardPassDES +
				"&logout=" + logout +"&userId=" + userId + "&sign=" + "4dae2fa32045bb2dd89d231693615c93" +
				"&mobile=" + mobile + "&remark=" +remark;
		
		
		Map<String, String> header = new HashMap<String, String>();
		
		String rtnJson = httpService.getHttpString(url1, header);
		System.out.println("***************************************************************************");
		System.out.println("\n\n");
		log.info("rtnJsonOrg:" + rtnJson);
			
		
		Map<String, Object> resultMap =null;
		try {
			
			resultMap = JSON.parseObject(rtnJson, Map.class);
			log.info("resultMap:" + resultMap);
			
			String result = resultMap.get("result").toString();
			MiguATokenResult parseObject = JSON.parseObject(result, MiguATokenResult.class);
			log.info("map转化为对象:"+parseObject);
			
			
		} catch (Exception e) {
			log.info("Exception:" + e.getMessage());
		}
		System.out.println("\n\n");
		System.out.println("***************************************************************************");
		return resultMap;
		
	}

	/**
	 * 加密
	 * 
	 * 第1位和第11位交换，第2位和13位交换，第3位和第15位交换
	 * 
	 * @param data
	 * @return
	 */
	private String pre(String data) {
		byte[] bytesData = data.getBytes();
		for (int i = 0; i < 3; i++) {
			int j = 10 + 2 * i;
			byte temp = bytesData[i];
			bytesData[i] = bytesData[j];
			bytesData[j] = temp;
		}
		return new String(bytesData);
	}
}
