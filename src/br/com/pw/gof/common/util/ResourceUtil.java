package br.com.pw.gof.common.util;

import java.util.ResourceBundle;

public class ResourceUtil {
	private static ResourceUtil resourceUtil = null;
	private ResourceBundle resource = null;
	
	private ResourceUtil() {
		resource = ResourceBundle.getBundle("config");
	}
	
	public static ResourceUtil getInstance() {
		if(resourceUtil == null) {
			resourceUtil = new ResourceUtil();
		}
		return resourceUtil;
	}
	
	public String getProperty(String chave) {
		return resource.getString(chave);
	}
}