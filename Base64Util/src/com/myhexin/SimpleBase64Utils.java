package com.myhexin;

import java.util.Base64;
import java.util.regex.Pattern;

/**
 * @Company: 浙江核心同花顺网络信息股份有限公司
 * @Description: 利用jdk8自带的类实现base64加解密
 * @Auther: chenjiahao@myhexin.com
 * @Date: 2018年12月4日 下午1:05:00
 * @Version:
 */
public class SimpleBase64Utils {

	public final Base64.Encoder encoder = Base64.getEncoder();
	public final Base64.Decoder decoder = Base64.getDecoder();
	
	// 加密，源字符串为空会提示
	public String getEncode(String str) {
		if(str == null || str.length() == 0)
			return "str is null";
		byte[] strByte = str.getBytes();
		String encode = encoder.encodeToString(strByte);
		
		return encode;
	}
	
	// 利用正则表达式判断一个字符串是否为base64码（借鉴而来，需要加深学习）
	public boolean isBase64(String str) {
	    String base64Pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
	    return Pattern.matches(base64Pattern, str);
	}
	
	// 解密，源字符串不是base64码会提示
	public String getDecode(String str) {
		if(str == null || str.length() == 0) {
			return "str is null";
		}
		while(isBase64(str)) {
			byte[] decodeByte = decoder.decode(str);
			String decode = new String(decodeByte);
			return decode;
		}
		return "not a base64 code";
	}
}
