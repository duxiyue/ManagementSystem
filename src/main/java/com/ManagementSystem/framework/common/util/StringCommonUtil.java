package com.ManagementSystem.framework.common.util;

public class StringCommonUtil {

	/**
	 * nullかどうかを判断する。
	 * @param obj
	 * @return nullの場合tureを返す。
	 */
	public static final boolean isEmpty(String str) {
		
		if (str != null || "".equals(str)) {
			return true;
		}

		return false;
	}
}
