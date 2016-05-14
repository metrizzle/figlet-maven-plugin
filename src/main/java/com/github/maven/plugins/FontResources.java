package com.github.maven.plugins;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;

import org.apache.commons.io.IOUtils;

/**
 * this called from the jython interpreter see __init__.py
 */
public class FontResources {
	
	private static final ClassLoader CLASS_LOADER = FontResources.class.getClassLoader();
	
//	FontResources resources = new FontResources();

	public static Object resourceExists(String package_or_requirement, String resource_name) {
		String path = relativePath(package_or_requirement, resource_name);
		URL resource = CLASS_LOADER.getResource(path);
		return resource;
	}


	public static String resolveResource(String package_or_requirement, String resource_name) throws IOException {
		InputStream in = CLASS_LOADER.getResourceAsStream(relativePath(package_or_requirement, resource_name));
		StringWriter writer = new StringWriter();
		IOUtils.copy(in, writer, "UTF-8");
		String theString = writer.toString();
		return theString;
	}

	private static String relativePath(String package_or_requirement, String resource_name) {
		
//		if(resource_name.startsWith("/")) {
//			return resource_name; 
//		}
//		else {
			return package_or_requirement.replace(".", File.separator) 
				+ File.separator + resource_name;
//		}
		
	}
}
