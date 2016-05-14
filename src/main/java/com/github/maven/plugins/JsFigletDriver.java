package com.github.maven.plugins;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.maven.shared.utils.StringUtils;

public class JsFigletDriver extends AbstractDriver<FigletOptionsRequest>{

	@Override
	protected void handleFigletRequestInternal(FigletOptionsRequest req) throws Exception {
	    ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine jsInterp = mgr.getEngineByName("js");
	    
	    if(StringUtils.isBlank(req.font))  {
	    	req.font = "Ghost";
	    }
	    
	    
		jsInterp.eval(openScriptSource("figlet-js/lib/figlet.js"));
	    jsInterp.eval(openScriptSource("figlet-js/figlet-nashorn.js"));
	    
	    String scriptlet = 
	    "figlet.text('" + req.text +"', {\n"+ 
    		"font: '" +  req.font +"', \n"+ 
    		"horizontalLayout: 'default', \n"+ 
    		"verticalLayout: 'default' \n" +
    		"}, function(err, data) { \n" + 
    			"if (err) {" +
    				"throw err \n" + 
    			"}" +
    		"console.log(data)"  +
		"});";
	    
	    Bindings b = jsInterp.createBindings();
	    //b.put(name, value)
	    
		jsInterp.eval(scriptlet);
//	    jsInterp.eval(
//	    		
//	    	"figlet.textSync('"+ req.text + "', {font: 'Ghost', horizontalLayout: 'default', verticalLayout: 'default' })"
//	    	
//	    		);
	   
	    
	}

	private BufferedReader openScriptSource(String resource_path) throws UnsupportedEncodingException {
		return new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(resource_path), "UTF-8"));
	}
	

}
