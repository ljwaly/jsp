package com.ljw.taglib;

import javax.servlet.jsp.JspException;

import org.springframework.context.ApplicationContext;

import com.ljw.cache.CacheManager;
import com.ljw.util.ServerApplictionContextUtil;
import com.ljw.vo.Film;


/**
 * Tag标签类
 * 在进行Tag标签的网页访问的时候，tag标签是new出来的新的，所以内部不能使用AutoWired
 * @author PC
 *
 */
public class AreaCodeTag extends BaseTag{
	private static final long serialVersionUID = 3035851013864501938L;
	
	private String code;
	
	@Override
	public int doStartTag() throws JspException {
		setDefaultVar("areacode");
	
		ApplicationContext appContext = ServerApplictionContextUtil.getAppContext();
		CacheManager cacheManager = (CacheManager)appContext.getBean("cacheManager");
		
		String property = CacheManager.conf.getProperty("hello");
		System.out.println(property);
		String cacheMap = cacheManager.getTestmap(6L);
		
		System.out.println(new Film());
		
		String result = "cacheMap:"+cacheMap+"\n\tcacheManager:"+cacheManager+"\n\tproperty:"+property;
 		saveScope(result);
        return super.doStartTag();
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
