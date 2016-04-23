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

public class JyFigletDriverTest {

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
	public void pyfiglet() throws Exception {
        // Create an instance of the PythonInterpreter
        PythonInterpreter interp = new PythonInterpreter();

        // The exec() method executes strings of code
        interp.exec("import sys");
        interp.exec("print sys");
        interp.exec("print sys.path");
        
        //TODO
        PyModule mod = new PyModule("pkg_resources");
//        mod.__setattr__("resource_exists", Py.newJavaCode(cls, name));
        interp.getSystemState().modules.__add__(mod);
//        interp.execfile("test.py");
        
//        interp.exec("import pkg_resources");
        interp.exec("from pyfiglet import Figlet");	
        interp.exec("f = Figlet(font='slant')");
        interp.exec("print f.renderText('builds r us')");
        
	}
	
	
	
//	@Theory
	@Test
	public void pyfigletScr() throws Exception {
//		System.setProperty("python.import.site", "false");
		System.setProperty("python.verbose", "true");
	    ScriptEngineManager mgr = new ScriptEngineManager();
	    
	    //only works with libs
//	    ScriptEngine pyEngine = mgr.getEngineByName("python");
	    ScriptEngine pyEngine = mgr.getEngineFactories()
	    		.stream()
	    		.filter(x -> x.getLanguageName().startsWith("py"))
	    		.findFirst().get().getScriptEngine();
	    
//	    pyEngine.
	    
	    ScriptContext context = pyEngine.getContext();
	    context.setWriter(new PrintWriter(System.out));
//	    context.setAttribute("python.verbose", true, ScriptContext.ENGINE_SCOPE);
//		pyEngine.setContext(context);
		
		pyEngine.eval("import os");
		
		pyEngine.eval("import sys");
		pyEngine.eval("sys.path.append('target/pyfiglet-0.7.3') ");
		
		pyEngine.eval("import glob");
		
		pyEngine.eval("from com.github.maven.plugins import pkg_resources");
		pyEngine.eval("from pyfiglet import Figlet");	
		
		Bindings bindings = pyEngine.getBindings(ScriptContext.GLOBAL_SCOPE);
		if(bindings == null) {
			bindings = pyEngine.createBindings();
			
		}
		
//		Object pkgResources = new PyObject(PyType.fromClass(JyPkgResources.class));
//		Object pkgResources = new PyModule(PyType.fromClass(JyPkgResources.class), "pkg_resources");
		
//		import pkg_resources

		
//		Object pkgResources = DynamicLibrary. new DynamicLibrary("pkg_resources", 0);
//		bindings.put("pkg_resources", pkgResources);
//		pyEngine.setBindings(bindings, ScriptContext.GLOBAL_SCOPE);
//		pyEngine.getContext().setAttribute("pkg_resources", pkgResources, ScriptContext.GLOBAL_SCOPE);
		//pyEngine.s
//		pyEngine.set("pkg_resources", pkgResources);
//		pyEngine.("pkg_resources", pkgResources, ScriptContext.GLOBAL_SCOPE);
		
//		pyEngine.eval("from javax.tools import (forwardingjavafilemanager, toolprovider, diagnosticcollector,)");
//		pyEngine.eval("print sys.path");
//		pyEngine.eval("import pkg_resources");
		
		
		pyEngine.eval("print \"figletize it!\"");	    

		pyEngine.eval("echo pkg_resources");
		//pyEngine.getContext().setAttribute("__pkg_resources__", value, scope);
//        dict.__setitem__("FUNCFLAG_CDECL", Py.newInteger(FUNCFLAG_CDECL));


		

		
	    //pyEngineFactory.
//	      pyEngine.eval(resolve("target/pyfiglet-0.7.3/pyfiglet/__init__.py"));
//	      pyEngine.eval("f = Figlet()");
//	      pyEngine.
//		  pyInterp = new PythonInterpreter(null, new PySystemState));
		  //pySysStat.set
		
//		  pyInterp.eval("println \"hello world\"");
		  
//		PythonInterpreter inter = new PythonInterpreter();
//		inter.
//		pyInterp.execfile("target/pyfiglet-0.7.3/pyfiglet/test.py");
//		inter.compile();
		
		
//		File basedir = resources.getBasedir("api");
////		new File(basedir, "target/classes").mkdirs(); // TODO this shouldn't be
//		mojos.newMojoExecution("figletize");								// necessary;
//		mojos.executeMojo(basedir, "copy-api-resources");
//		
//		TestResources.assertFilesPresent(basedir, "target/classes/SampleApiType.java");
//		
////		try (JarFile jar = new JarFile(new File(basedir, "target/test-1.0.jar"))) {
////			Manifest mf = jar.getManifest();
////			Assert.assertEquals("custom-value", mf.getMainAttributes().getValue("Custom-Entry"));
////		}
	}

	private Reader resolve(String string) {
		try {
			return new FileReader(string);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Cannot resolve script resource", e);
		}
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
