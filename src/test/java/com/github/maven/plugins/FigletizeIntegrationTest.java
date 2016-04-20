package com.github.maven.plugins;

import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.takari.maven.testing.TestProperties;
import io.takari.maven.testing.TestResources;
import io.takari.maven.testing.executor.MavenRuntime;
import io.takari.maven.testing.executor.MavenRuntime.MavenRuntimeBuilder;
import io.takari.maven.testing.executor.MavenVersions;
import io.takari.maven.testing.executor.junit.MavenJUnitTestRunner;

@RunWith(MavenJUnitTestRunner.class)
@MavenVersions({"3.3.9"})//"{"3.2.1", "3.2.5"}"
public class FigletizeIntegrationTest {

	public static String expectedBanner=
	" _                  _       ";
//	"| |__    __ _  ___ (_)  ___  " + "\n" +
//	"| '_ \\  / _` |/ __|| | / __|" + "\n" +
//	"| |_) || (_| |\\__ \\| || (__ " + "\n" +
//	"|_.__/  \\__,_||___/|_| \\___|";

	@Rule
	public final TestResources resources = new TestResources();

	public final TestProperties properties = new TestProperties();

	public final MavenRuntime maven;

	public FigletizeIntegrationTest(MavenRuntimeBuilder builder) throws Exception {
//		builder.withCliOptions("-B", "-U");
		builder.withCliOptions("-U");
		
		this.maven = builder.build();

	  }

	@Test
	public void test() throws Exception {
		File basedir = resources.getBasedir("basic");
		System.out.println("Expected banner: \n" + expectedBanner);
		maven.forProject(basedir)
//			.withCliOption("-Dproperty=value")
//			.withCliOption("-X")
			.execute("package")
			.assertErrorFreeLog()
			.assertLogText(expectedBanner);
	}

}