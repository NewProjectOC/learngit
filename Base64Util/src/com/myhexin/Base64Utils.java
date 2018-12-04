package com.myhexin;

import java.util.regex.Pattern;

/**
 * @Company: 浙江核心同花顺网络信息股份有限公司
 * @Description: 自己编写算法实现base64加解密工具
 * @Auther: chenjiahao@myhexin.com
 * @Date: 2018年12月4日 上午9:06:19
 * @Version:
 */
public class Base64Utils {
	
	// base64的所有码
	public static final String BASE64CODE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	
	// base64加密方法
	public String encode(String srcStr) {
		
		if(srcStr == null || srcStr.length() == 0) {
			return "str is null";
		}
		
		// 将源字符串转为二进制
		char[] srcStrToCh = srcStr.toCharArray();
		StringBuilder srcStrToBin = new StringBuilder();
		for(int i = 0; i < srcStrToCh.length; i++) {
			String bin = Integer.toBinaryString((int)srcStrToCh[i]);
			while(bin.length() < 8) {
				bin = "0" + bin;
			}
			srcStrToBin.append(bin);
		}

		// 补位
		while(srcStrToBin.length() % 6 != 0) {
			srcStrToBin.append("0");
		}
		
		// 将二进制字符串每六位转换成十进制，并且转换成对应的base64码
		String srcStrBin = srcStrToBin.toString();
		char[] encodeCh = new char[srcStrBin.length() / 6];
		int index = 0;
		for(int i = 0; i < encodeCh.length; i++) {
			index = Integer.parseInt(srcStrBin.substring(0, 6),2);
			encodeCh[i] = BASE64CODE.charAt(index);
			srcStrBin = srcStrBin.substring(6);
		}
		
		StringBuilder encode = new StringBuilder(String.valueOf(encodeCh));
		
		// 末尾添"="
		if(srcStr.length() % 3 == 1) {
			encode.append("==");
		} else if(srcStr.length() % 3 == 2) {
			encode.append("=");
		}
		
		return encode.toString();
	}
	
	// base64解密方法
	public String decode(String srcStr) {
		
		if(srcStr == null || srcStr.length() == 0) {
			return "str is null";
		}
		
		String base64Pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
	    if(!Pattern.matches(base64Pattern, srcStr)) {
	    	return "not a base64 code";
	    }
	    
	    // 如果末尾有"="，记录需删除的二进制个数并删去"="
	    int zeroNum = 0;
	    if(srcStr.endsWith("==")) {
	    	zeroNum = 2;
	    } else if(srcStr.endsWith("=")) {
	    	zeroNum = 1;
	    }
	    srcStr = srcStr.replaceAll("=", "");
	    
	    // 将base64码转换成二进制
	    char[] srcStrToCh = srcStr.toCharArray();
	    StringBuilder srcStrToBin = new StringBuilder();
	    String indexBin;
	    for(int i = 0; i < srcStrToCh.length; i++) {
	    	indexBin = Integer.toBinaryString(BASE64CODE.indexOf((int)srcStrToCh[i]));
	    	while(indexBin.length() < 6)
	    		indexBin = "0" + indexBin;
	    	srcStrToBin.append(indexBin);
	    }

	    // 删去二进制末位的0
	    if(zeroNum == 1)
	    	srcStrToBin = srcStrToBin.delete(srcStrToBin.length()-2, srcStrToBin.length());
	    else if(zeroNum == 2)
	    	srcStrToBin = srcStrToBin.delete(srcStrToBin.length()-4, srcStrToBin.length());
	    
	    // 每八位转换成十进制，再转换成char
	    String srcStrBin = String.valueOf(srcStrToBin);
	    char[] decodeChArray = new char[srcStrBin.length() / 8];
	    for(int i= 0; i < decodeChArray.length; i++) {
	    	decodeChArray[i] = (char)Integer.parseInt(srcStrBin.substring(0, 8),2);
	    	srcStrBin = srcStrBin.substring(8);
	    }
	    
	    StringBuilder decode = new StringBuilder(String.valueOf(decodeChArray));
	    
		return decode.toString();
	}
}
