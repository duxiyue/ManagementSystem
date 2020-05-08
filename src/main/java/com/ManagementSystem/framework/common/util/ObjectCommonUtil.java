package com.ManagementSystem.framework.common.util;

public class ObjectCommonUtil {

	/**
	 * nullかどうかを判断する。
	 * @param obj
	 * @return nullの場合tureを返す。
	 */
	public static final boolean isEmpty(Object obj) {
		
		if (obj != null) {
			return true;
		}
		
		return false;
	}
}
