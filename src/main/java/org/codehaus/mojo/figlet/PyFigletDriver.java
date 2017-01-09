package com.github.maven.plugins;

import org.apache.commons.io.IOUtils;
import org.python.core.PyModule;
import org.python.util.PythonInterpreter;

/**
 * implementation delegating to the embend python lib for rendering. 
 */
public class PyFigletDriver extends AbstractDriver<FigletOptionsRequest> {

	@Override
	protected void handleFigletRequestInternal(FigletOptionsRequest req) throws Exception {

		// Create an instance of the PythonInterpreter
		PythonInterpreter interp = new PythonInterpreter();
		try {
			// The exec() method executes strings of code
			interp.exec("import sys");
			// interp.exec("print sys");
			// interp.exec("print sys.path");
			
			PyModule mod = new PyModule("pkg_resources");
			interp.getSystemState().modules.__add__(mod);
			interp.exec("from pyfiglet import Figlet");
			
			if(req.font == null) {
				interp.exec("f = Figlet()");
			}
			else {
				interp.exec("f = Figlet(font='" + req.font + "')");
			}
			
			interp.set("res", "");
			//TODO bind string properly script injects..
			interp.exec("res = f.renderText('" + req.text + "')");
			
			IOUtils.write(interp.get("res").asString(), req.out);
			
		} finally {
			interp.close();
		}
		
	}

}
