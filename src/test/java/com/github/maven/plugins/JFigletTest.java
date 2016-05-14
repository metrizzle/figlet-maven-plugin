package com.github.maven.plugins;

import static com.github.maven.plugins.Figletizzr.print;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class JFigletTest {

    @DataPoints("text") 
    public static String[] messages = new String[] { "figletizzr", "swa", "jfiglet" };

    @DataPoints("fonts")
    public static String[] fonts = new String[] { "block", "bubble",  "lean", "big"};

	JFigletDriver figlet = new JFigletDriver();

	
	@Theory
	public void renderAFew(@FromDataPoints("text") String message,
			@FromDataPoints("fonts") String font) {
		
		try {
			print(figlet, new FigletOptionsRequest().text(message).font(font));
		} catch(Exception e) {
			System.out.println("rendering failed; error message:" + e.getMessage() + " font: " + font + " text:" + message);
		}

		System.out.println("text: " + message + " font:" + font);
//	    assumeThat(m, not(0));
//	    assertThat(new Dollar(amount).times(m).divideBy(m).getAmount(), is(amount));
	}
	
	
}
