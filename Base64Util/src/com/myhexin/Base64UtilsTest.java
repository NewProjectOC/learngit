package com.myhexin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Base64UtilsTest {
	
	Base64Utils test = new Base64Utils();
	
	// 测试用例
	String strNull = null;
	String str0 = "";
	String strNotBase = "QQ";
	String decode = "Ap83J";
	String encode = "QXA4M0o=";
	
	@Test
	void testEncode() {
		// str为空测试
		if(!test.encode(strNull).equals("str is null") || !test.encode(str0).equals("str is null"))
			fail("null input error");
		
		// 算法测试
		if(!test.encode(decode).equals(encode))
			fail("encode error");
	}

	@Test
	void testDecode() {
		// str为空测试
		if(!test.encode(strNull).equals("str is null") || !test.encode(str0).equals("str is null"))
			fail("null input error");
		
		// 非base64码测试
		if(!test.decode(strNotBase).equals("not a base64 code"))
			fail("not a base64 code error");
		
		// 算法测试
		if(!test.decode(encode).equals(decode))
			fail("decode error");
	}

}
