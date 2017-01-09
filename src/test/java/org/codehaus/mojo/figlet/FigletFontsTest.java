package com.github.maven.plugins;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@RunWith(Parameterized.class)
public class FigletFontsTest {
	
    @Parameters(name = "Test {index} text:\"{1}\" driver:{0}")
    public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {     
                 { new JsFigletDriver(), "figlet-js ->", "figletjs/fonts" }, 
                 { new JFigletDriver(), "jfiglet ->" , "/figlet-fonts/defaults/ours"}, 
                 { new PyFigletDriver(), "pyfiglet ->" ,"pyfiglet/fonts"},
//                 { new JFigletDriver(), "jfiglet" }
                 //{ 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }  
           });
    }
    Driver figlet;
    String text;
    String fontPath;
    
	public FigletFontsTest(Driver figlet, String text,String fontPath) {
		super();
		this.figlet = figlet;
		this.text = text;
		this.fontPath = fontPath;
	}

	@Test
	public void renderFonts() {
		Figletizzr.print(figlet, new FigletOptionsRequest().text(text));
	}
	
	@Test
	@Ignore
	public void printOurs() throws Exception {
		ClassLoader cl = this.getClass().getClassLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
		Resource[] resources = resolver.getResources("classpath*:" + fontPath + "/*");
		for (Resource resource : resources) {
			try {
				
				Figletizzr.print(figlet, new FigletOptionsRequest()
						.text("test")
						.font(resource.getFilename()));
				//fig.print(resource.getFilename(), text);
				System.out.println("rendering text \"" + text + "\" with font \"" + resource.getFilename() + "\"");
				
				Figletizzr.print(figlet, new FigletOptionsRequest()
						.text(text)
						.font(resource.getFilename()));
				//fig.print(resource.getFilename(), text);
				System.out.println("rendering text \"" + text + "\" with font \"" + resource.getFilename() + "\"");

				
			} catch (Exception e) {
				System.out.println(figlet.toString() + " error renderin font" + resource.getFilename() + " msg: " + e.getMessage());
				
			}
		}

	}	
	
}
