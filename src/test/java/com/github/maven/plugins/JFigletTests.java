package com.github.maven.plugins;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.StringReader;

import org.apache.commons.io.IOUtils;
import org.apache.maven.shared.utils.StringUtils;
import org.junit.Test;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.github.lalyos.jfiglet.FigletFont;

public class JFigletTests {

	private static final String JFIGLET_BASE = "figlet-fonts";

	@Test
	public void printOurs() throws Exception {
		ClassLoader cl = this.getClass().getClassLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
		Resource[] resources = resolver.getResources("classpath:figlet-fonts/**/*.flf");
		for (Resource resource : resources) {
			// logger.info(resource.getFilename());
			
			// String font ="standard";
			String text = "jfiglet>>";
			try {
				System.out.println("rendering text \"" + text + "\" with font \"" + resource.getFilename() + "\"");
				
				print(resource.getFilename(), text);

			} catch (Exception e) {
				System.out.println("error renderinfg font" + resource.getFilename());
				e.getMessage();
			}
		}

	}

	private void print(String font, String text) throws Exception {

		if (StringUtils.isBlank(font)) {
			font = "/ours/standard";
		} else if (!StringUtils.contains("/", font)) {
			font = "/ours/" + font;
		}

		if (JyPkgResourceStub.resourceExists(JFIGLET_BASE, font) == null) {
			throw new IllegalArgumentException("font" + font + " no resource found");
		}
		String content = JyPkgResourceStub.resolveResource(JFIGLET_BASE, font);
		InputStream fontfile = IOUtils.toInputStream(content, "UTF-8");
		String asciiArt = convertOneLine(fontfile, text);
		System.out.println("\n" + asciiArt);
	}

	public static String convertOneLine(InputStream fontfile, String message) throws IOException {
		FigletFont fig = new FigletFont(fontfile);
		fig.smushMode++;
		fig.smushMode++;
		fig.smushMode++;
		return fig.convert(message);
	}

}
