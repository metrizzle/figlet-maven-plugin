package org.codehaus.mojo.figlet;

import java.io.File;

import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.takari.maven.testing.TestMavenRuntime;
import io.takari.maven.testing.TestResources;
import io.takari.maven.testing.executor.MavenVersions;
import io.takari.maven.testing.executor.junit.MavenJUnitTestRunner;

//@RunWith(MavenJUnitTestRunner.class)
//@MavenVersions({"3.3.9", "3.2.5"})//"{"3.1.1","3.2.1", "3.0" }"
public class TouchBannerTest {
	
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
