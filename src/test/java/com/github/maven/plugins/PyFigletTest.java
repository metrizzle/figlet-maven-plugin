package com.github.maven.plugins;

import static com.github.maven.plugins.Figletizzr.print;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class PyFigletTest {

    @DataPoints("text") 
    public static String[] messages = new String[] { "foobar", "swagg", "jfiglet", "pyfiglet" };

    @DataPoints("fonts")
    public static String[] fonts = new String[] { "banner4", "bubble", "graffiti",  "kban"};

	PyFigletDriver figlet = new PyFigletDriver();
    
	@Theory
	public void renderAFew(@FromDataPoints("text") String message,
			@FromDataPoints("fonts") String font) {
		
		try {
			print(figlet, new FigletOptionsRequest().text(font).font(font));
			print(figlet, new FigletOptionsRequest().text(message).font(font));
		} catch(Exception e) {
			System.out.println("rendering failed; error message:" + e.getMessage() + " font:" + font + " text:" + message);
		}

		System.out.println("text: " + message + " font:" + font);
//	    assumeThat(m, not(0));
//	    assertThat(new Dollar(amount).times(m).divideBy(m).getAmount(), is(amount));
	}
	
	
//	@Test
//	public void noargs() throws Exception {
//		print(figlet, null);
//	}
	
	
	@Test
	public void pyfigletDefaultFont() throws Exception {
		print(figlet, "continous delivery");
	}
	
	@Test
	public void pyfiglet() throws Exception {
		
//		String font ="standard";
		
		print(figlet, new FigletOptionsRequest().text("text").font("4max"));
		
//		print(figlet, b -> {
//			b.font("banner.flf")
//		});
		
//		.font("banner.flf")
//		.text("text");
        
	}

	
}
