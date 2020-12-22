package com.zzd.bookmanagersystem.handle;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 可以在连接中携带区域信息
 * @date：
 */

public class MyLocalResolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest httpServletRequest) {
		String l = httpServletRequest.getParameter("l");
		Locale locale =Locale.getDefault();
		if(!StringUtils.isEmpty(l)){
			String [] spilt = l.split("_");
			locale = new Locale(spilt[0],spilt[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

	}
}
