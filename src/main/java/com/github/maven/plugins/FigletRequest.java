package com.github.maven.plugins;

import org.apache.maven.shared.utils.StringUtils;

public class FigletRequest {
		

	
}	


class FigletCmdRequest extends FigletRequest {
	public FigletCmdRequest(String cmdline) {
		this.args = StringUtils.split(cmdline);
	}

	String[] args;
}
