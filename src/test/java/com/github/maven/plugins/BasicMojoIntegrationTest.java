package com.github.maven.plugins;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.takari.maven.testing.TestProperties;
import io.takari.maven.testing.TestResources;
import io.takari.maven.testing.executor.MavenExecutionResult;
import io.takari.maven.testing.executor.MavenRuntime;
import io.takari.maven.testing.executor.MavenRuntime.MavenRuntimeBuilder;
import io.takari.maven.testing.executor.MavenVersions;
import io.takari.maven.testing.executor.junit.MavenJUnitTestRunner;

@RunWith(MavenJUnitTestRunner.class)
@MavenVersions({"3.3.9", "3.2.5"})//"{,"3.2.1", "3.0" }"
public class BasicMojoIntegrationTest {
	
	private static final Log log  = LogFactory.getLog(BasicMojoIntegrationTest.class);
	
	@Rule
	public final TestResources resources = new TestResources();

	public final TestProperties properties = new TestProperties();

	public final MavenRuntime maven;

	public BasicMojoIntegrationTest(MavenRuntimeBuilder builder) throws Exception {
//		builder.withCliOptions("-B", "-U");
		builder.withCliOptions("-B", "-U");
		
		this.maven = builder.build();

	  }

	//contains java escape symbols; looks a bit weird
	String[] expectedBanner= {
			" _                  _       ",
			"| |__    __ _  ___ (_)  ___ ", 
			"| '_ \\  / _` |/ __|| | / __|",
			"| |_) || (_| |\\__ \\| || (__ ",
			"|_.__/  \\__,_||___/|_| \\___|"
	};		

	@Test
	public void defaultsOptions() throws Exception {
		String project = "basic";
		assertSuccesfulBuildWithSplash(expectedBanner, project);
	}

	private void assertSuccesfulBuildWithSplash(String[] expectedBanner, String project) throws IOException, Exception {
		File basedir = resources.getBasedir(project);
		System.out.println("Expected banner: \n" + Arrays.toString(expectedBanner));
		MavenExecutionResult res = maven.forProject(basedir)
			.execute("package");
		 
		printStdout(new File(basedir, "log.txt"));
		
	    for (String string : expectedBanner) {
	    	res.assertLogText(string);
			
		}
	    res.assertErrorFreeLog();
	}

	@Test
	public void defaultsOptionsWithPyfiglet() throws Exception {
		File basedir = resources.getBasedir("basic-pyfiglet");
		String[] expectedBanner= {
				" _                  _       ",
				"| |__    __ _  ___ (_)  ___ ", 
				"| '_ \\  / _` |/ __|| | / __|",
				"| |_) || (_| |\\__ \\| || (__ ",
				"|_.__/  \\__,_||___/|_| \\___|"
				};		
				
		System.out.println("Expected banner: \n" + expectedBanner);
		MavenExecutionResult res = maven.forProject(basedir)
//			.withCliOption("-Dproperty=value")
//			.withCliOption("-X")
			.execute("package");
		 
		printStdout(new File(basedir, "log.txt"));
		
	    for (String string : expectedBanner) {
	    	res.assertLogText(string);
			
		}
	    
	    res.assertErrorFreeLog();
		
	}	
	
	@Test
	public void figletjsDefaultOptions() throws Exception {
		assertSuccesfulBuildWithSplash(expectedBanner, "basic-figletjs");
	}	
		
	
	
	private static void printStdout(File logFile) throws IOException {
	    if (!logFile.canRead()) {
	    	return;
	    }
	    
        for (String line : Files.readAllLines(logFile.toPath(), Charset.defaultCharset())) {
        	System.out.println(line);
          //log.info(line);
        }
	}

}