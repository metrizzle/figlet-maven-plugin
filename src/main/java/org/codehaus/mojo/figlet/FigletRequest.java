package org.codehaus.mojo.figlet;

import org.codehaus.plexus.util.StringUtils;

public class FigletRequest {
	
}

class FigletCmdRequest extends FigletRequest {
	public FigletCmdRequest(String cmdline) {
		this.args = StringUtils.split(cmdline);
	}

	String[] args;
}
