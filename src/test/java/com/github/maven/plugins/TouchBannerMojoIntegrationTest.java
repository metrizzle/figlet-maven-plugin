package com.github.maven.plugins;

import java.io.File;

import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import io.takari.maven.testing.TestMavenRuntime;
import io.takari.maven.testing.TestResources;

public class TouchBannerMojoTest {
	
	@Rule
	public final TestResources resources = new TestResources();

	@Rule
	public final TestMavenRuntime maven = new TestMavenRuntime();
	
	@Test
	public void assertGenerated() throws Exception {
		File basedir = resources.getBasedir("test");
		maven.executeMojo(basedir, "touch", newParameter("text", "figlets"));
		assertFilesPresent(basedir, "target/banner.txt");
		
	}

	private void assertFilesPresent(File basedir, String string) {
		File file = new File(basedir, string);
		if(!file.exists()) {
			Assert.fail("Assert failed! Expected file named=" + string + " does not exist!");
		}
		else {
			System.out.println("Touched file:" + file.getAbsolutePath());
		}
	}

	private static Xpp3Dom newParameter(String string, String string2) {
		Xpp3Dom node = new Xpp3Dom(string);
		node.setValue(string2);
		return node;
	}
}
