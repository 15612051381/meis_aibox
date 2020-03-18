/**  

* <p>Title: LevelController.java</p>  

* <p>Description:北京惠泽智信科技有限公司 </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.hzzxkj.com/</p>  
* @author guoxinan  
* @date 2018年10月13日  
* @version 1.0  
*/
package com.hzzxkj.Logger;

import static ch.qos.logback.core.spi.FilterReply.ACCEPT;
import static ch.qos.logback.core.spi.FilterReply.DENY;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.filter.LevelFilter;

/**
 * 日志级别过滤器
 * @author guoxinan
 * @date 2018年10月13日
 */
public class LevelController {
	/**
	 * 通过level设置过滤器
	 * 
	 * @param level
	 * @return
	 */
	public LevelFilter getLevelFilter(Level level) {
		LevelFilter levelFilter = new LevelFilter();
		levelFilter.setLevel(level);
		levelFilter.setOnMatch(ACCEPT);
		levelFilter.setOnMismatch(DENY);
		return levelFilter;
	}
}
