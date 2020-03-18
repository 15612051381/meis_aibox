package com.hzzxkj.utils;

import java.math.BigDecimal;

public class HzzxMathUtils {

	/**
	 * 获取保留N位小数点后的值
	 * @param value  原始值
	 * @param count  要保留的小数点位数
	 * @param mode   是否四舍五入
	 * @return       
	 */
	public static double round(double value,int count,boolean mode ) {
		BigDecimal   b   =   new   BigDecimal(value);
		double   f1=0.00;
		if(mode) {
		   f1   =   b.setScale(count, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		}else {
			f1= b.setScale(count, BigDecimal.ROUND_HALF_DOWN).doubleValue();
		}
		return f1;
	}
}
