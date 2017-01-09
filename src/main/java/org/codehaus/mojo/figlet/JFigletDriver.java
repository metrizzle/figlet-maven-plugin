package com.github.maven.plugins;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.codehaus.plexus.util.StringUtils;

import com.github.lalyos.jfiglet.FigletFont;

public class JFigletDriver extends AbstractDriver<FigletOptionsRequest> {
	
	private static final String JFIGLET_BASE = "figlet-fonts";

	@Override
	protected void handleFigletRequestInternal(FigletOptionsRequest req) throws Exception {

		if (StringUtils.isBlank(req.font)) {
			req.font = "/defaults/ours/standard.flf";
		} else if (!StringUtils.contains("/", req.font)) {
			req.font = "/defaults/ours/" + req.font;
		}
		
		if(!StringUtils.contains(req.font, ".flf")) {
			req.font += ".flf";
		}
		

		if (FontResources.resourceExists(JFIGLET_BASE, req.font) == null) {
			throw new IllegalArgumentException("font:" + req.font + " no resource found");
		}
		String content = FontResources.resolveResource(JFIGLET_BASE, req.font);
		InputStream fontfile = IOUtils.toInputStream(content, "UTF-8");
		String asciiArt = convertOneLine(fontfile, req.text);
		
		IOUtils.write(asciiArt, req.out);
		
	}

	public static String convertOneLine(InputStream fontfile, String message) throws IOException {
		FigletFont fig = new FigletFont(fontfile);
		fig.smushMode++;
		fig.smushMode++;
		fig.smushMode++;
		return fig.convert(message);
	}


}
