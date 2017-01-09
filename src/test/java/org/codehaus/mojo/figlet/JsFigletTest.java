package org.codehaus.mojo.figlet;

import static org.codehaus.mojo.figlet.Figletizzr.print;

import org.codehaus.mojo.figlet.FigletOptionsRequest;
import org.codehaus.mojo.figlet.JsFigletDriver;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class JsFigletTest {

    @DataPoints("text") 
    public static String[] messages = new String[] { "hack hack hustle", "figletizzr 2000", "swa", "figlet-js" };

    @DataPoints("fonts")
    public static String[] fonts = new String[] { "Ghost", "Banner", "Banner3-D",  "Spliff", "Spliff", "Script"};

	JsFigletDriver figlet = new JsFigletDriver();

	@Theory
	public void renderAFew(@FromDataPoints("text") String message,
			@FromDataPoints("fonts") String font) {
		
		try {

			print(figlet, new FigletOptionsRequest().text(message).font(font));
		} catch(Exception e) {
			System.out.println("rendering failed; error message:" + e.getMessage() + " font:" + font + " text:" + message);
		}

		System.out.println("text: " + message + " font:" + font);
//	    assumeThat(m, not(0));
//	    assertThat(new Dollar(amount).times(m).divideBy(m).getAmount(), is(amount));
	}
	
	
	@Test
	public void defaultFont() throws Exception {
		print(figlet, "continous delivery");
	}

	
}
