package com.github.maven.plugins;

import java.io.File;

import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.takari.maven.testing.TestMavenRuntime;
import io.takari.maven.testing.TestResources;
import io.takari.maven.testing.executor.junit.MavenJUnitTestRunner;

//@RunWith(MavenJUnitTestRunner.class)
public class FigletizeMojoTest {
	
	@Rule
	public final TestResources resources = new TestResources();

	@Rule
	public final TestMavenRuntime maven = new TestMavenRuntime();

	@Test
	@Ignore
	public void test() throws Exception {
		File basedir = resources.getBasedir("testproject");
		maven.executeMojo(basedir, "figletize", newParameter("name", "value"));
		assertFilesPresent(basedir, "target/output.txt");
	}

	private void assertFilesPresent(File basedir, String string) {
		// TODO Auto-generated method stub
		
	}

	private Xpp3Dom newParameter(String string, String string2) {
		Xpp3Dom node = new Xpp3Dom(string);
		node.setValue(string2);
		return node;
	}
}
