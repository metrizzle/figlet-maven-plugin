package com.github.maven.plugins;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class JyPkgResourceStub {
	
	private static final ClassLoader CLASS_LOADER = JyPkgResourceStub.class.getClassLoader();

	public static Object resourceExists(String package_or_requirement, String resource_name) {
		String path = relativePath(package_or_requirement, resource_name);
		URL resource = CLASS_LOADER.getResource(path);
		return resource;
	}

	private static String relativePath(String package_or_requirement, String resource_name) {
		return package_or_requirement.replace(".", File.separator) + File.separator + resource_name;
	}

	public static String resolveResource(String package_or_requirement, String resource_name) throws IOException {
		InputStream in = CLASS_LOADER.getResourceAsStream(relativePath(package_or_requirement, resource_name));
		StringWriter writer = new StringWriter();
		IOUtils.copy(in, writer, "UTF-8");
		String theString = writer.toString();
		return theString;
	}

}
