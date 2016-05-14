package com.github.maven.plugins;
import java.util.List;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

import org.junit.Test;
import org.python.core.PyException;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class ScriptEngineTest {

    /**
    * @param args the command line arguments
    */
//	@Test
    public static void main(String[] args) throws PyException {

        // Create an instance of the PythonInterpreter
        PythonInterpreter interp = new PythonInterpreter();

        // The exec() method executes strings of code
        interp.exec("import sys");
        interp.exec("print sys");

        // Set variable values within the PythonInterpreter instance
        interp.set("a", new PyInteger(42));
        interp.exec("print a");
        interp.exec("x = 2+2");

        // Obtain the value of an object from the PythonInterpreter and store it
        // into a PyObject.
        PyObject x = interp.get("x");
        System.out.println("x: " + x);
    }

	@Test
	public void listEngines(){
	    ScriptEngineManager mgr = new ScriptEngineManager();
	    List<ScriptEngineFactory> factories =
	        mgr.getEngineFactories();
	    for (ScriptEngineFactory factory: factories) {
	      System.out.println("ScriptEngineFactory Info");
	      String engName = factory.getEngineName();
	      String engVersion = factory.getEngineVersion();
	      String langName = factory.getLanguageName();
	      String langVersion = factory.getLanguageVersion();
	      System.out.printf("\tScript Engine: %s (%s)\n",
	          engName, engVersion);
	      List<String> engNames = factory.getNames();
	      for(String name: engNames) {
	        System.out.printf("\tEngine Alias: %s\n", name);
	      }
	      System.out.printf("\tLanguage: %s (%s)\n",
	          langName, langVersion);
	    }
	  }	
}