package org.codehaus.mojo.figlet;

import com.github.lalyos.jfiglet.JFiglet;

public class JFigletCmdDriver extends AbstractDriver<FigletCmdRequest> {

	@Override
	protected void handleFigletRequestInternal(FigletCmdRequest req) throws Exception {
		//TODO redirect System.out
		JFiglet.main(req.args);
		
	}

}
