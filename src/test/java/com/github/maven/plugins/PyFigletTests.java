package com.github.maven.plugins;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

import org.junit.Test;
import org.python.core.Py;
import org.python.core.PyBuiltinFunction;
import org.python.core.PyInteger;
import org.python.core.PyModule;
import org.python.core.PyObject;
import org.python.core.PyType;
import org.python.modules.jffi.DynamicLibrary;
import org.python.util.PythonInterpreter;

public class PyFigletTests {

	// @Rule
	// public final TestResources resources = new TestResources();
	//
	// @Rule
	// public final TestMavenRuntime mojos = new TestMavenRuntime();

	
//	public void multiplyIsInverseOfDivideWithInlineDataPoints(
//	        @TestedOn(ints = {0, 5, 10}) int amount,
//	        @TestedOn(ints = {0, 1, 2}) int m
//	) {
//	    assumeThat(m, not(0));
//	    assertThat(new Dollar(amount).times(m).divideBy(m).getAmount(), is(amount));
//	}
	

	@Test
	public void pyScr() throws Exception {
		
	}

	
	@Test
	public void pyfiglet() throws Exception {
		
		String font ="standard";
		String text ="builds \\'r us";
		
        printText(font, text);
        
	}


	private void printText(String font, String text) {
		// Create an instance of the PythonInterpreter
        PythonInterpreter interp = new PythonInterpreter();

        // The exec() method executes strings of code
        interp.exec("import sys");
        //interp.exec("print sys");
        //interp.exec("print sys.path");
        
        PyModule mod = new PyModule("pkg_resources");
        interp.getSystemState().modules.__add__(mod);
        interp.exec("from pyfiglet import Figlet");
        
        interp.exec("f = Figlet(font='"+font+"')");
        interp.exec("print f.renderText('"+text+"')");
	}
		
	
}
