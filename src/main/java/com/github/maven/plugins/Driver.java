package com.github.maven.plugins;

import java.net.URI;

/**
 * strategy to figletizing implementations
 * @param <R>
 */
@FunctionalInterface
public interface Driver<R extends FigletRequest> {
	
	/**
	 * handler steez foglet 
	 */
	void handleFigletRequest(R req);
	
	/**
	 * 
	 * defaults fonts of this driver
	
	Iterable<String> getFonts();
	 */

	
//	//add impl
//	@Override
//	default public void handleFigletRequest(R req) {
//		return;
//	}
	

//	public boolean supports(R req);
	
}
