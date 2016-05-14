package com.github.maven.plugins;


import static com.github.maven.plugins.Figletizzr.*;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class JFigletFontTest {

	JFigletDriver fig = new JFigletDriver();

//	@Test
//	public void noargs() throws Exception {
//		print(fig, null);
//	}
	
	@Test
	public void printFunctions() throws Exception {
		print(fig, "test figlet");
	}


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
				
				Figletizzr.print(fig, new FigletOptionsRequest()
						.text(text)
						.font(resource.getFilename()));
				//fig.print(resource.getFilename(), text);

			} catch (Exception e) {
				System.out.println("error renderinfg font" + resource.getFilename());
				e.getMessage();
			}
		}

	}


}
