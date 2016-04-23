package com.github.maven.plugins;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.github.lalyos.jfiglet.FigletFont;

public class FigletFontsTest {
	
//	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void printContrib() throws IOException {
		ClassLoader cl = this.getClass().getClassLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
		Resource[] resources = resolver.getResources("classpath*:**/contributed/*.flf");
		for (Resource resource: resources){
//		    logger.info(resource.getFilename());
		    String text ="MAVEN";
		    try {
		    	System.out.println("Printing font:" +  resource.getDescription()  + "\n");
		    	String asciiArt = convertOneLine(resource.getInputStream(), text);
				System.out.println("\n" + asciiArt);		    	
		    } catch(Exception e) {
		    	System.out.println("Error printing: " +  e.getMessage());
		    	e.printStackTrace();
		    }
		    
//		    logger.info("\n" + asciiArt);

		}	

	}		
	
	@Test
	public void printJave() throws IOException {
		ClassLoader cl = this.getClass().getClassLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
		Resource[] resources = resolver.getResources("classpath*:**/jave/*.flf");
		for (Resource resource: resources){
//		    logger.info(resource.getFilename());
		    String text ="MAVEN";
		    try {
		    	System.out.println("Printing font:" +  resource.getDescription()  + "\n");
		    	String asciiArt = convertOneLine(resource.getInputStream(), text);
				System.out.println("\n" + asciiArt);		    	
		    } catch(Exception e) {
		    	System.out.println("Error printing: " +  e.getMessage());
		    	e.printStackTrace();
		    }
		    
//		    logger.info("\n" + asciiArt);

		}	

	}	
	
	@Test
	public void printOurs() throws IOException {
		ClassLoader cl = this.getClass().getClassLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
		Resource[] resources = resolver.getResources("classpath*:**/ours/*.flf");
		for (Resource resource: resources){
//		    logger.info(resource.getFilename());
		    String text ="MAVEN";
		    try {
		    	System.out.println("Printing font:" +  resource.getDescription()  + "\n");
		    	String asciiArt = convertOneLine(resource.getInputStream(), text);
				System.out.println("\n" + asciiArt);		    	
		    } catch(Exception e) {
		    	System.out.println("Error printing: " +  e.getMessage());
		    	e.printStackTrace();
		    }
		    //fraktur.flf
//		    logger.info("\n" + asciiArt);

		}	

	}
	
    public static String convertOneLine(InputStream fontFileStream, String message) throws IOException {
        FigletFont fig = new FigletFont(fontFileStream);
        fig.smushMode++;
        fig.smushMode++;
        fig.smushMode++;
		return fig.convert(message);
    }

}
