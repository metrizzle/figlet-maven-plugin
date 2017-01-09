package org.codehaus.mojo.figlet;

import java.io.OutputStream;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.InstantiationStrategy;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.codehaus.mojo.figlet.Driver.Types;

//@Execute(goal="figletize", phase=LifecyclePhase.VALIDATE)
@Mojo(name = "figletize", requiresProject=true, threadSafe = true, 
defaultPhase = LifecyclePhase.VALIDATE, instantiationStrategy = InstantiationStrategy.SINGLETON)
public class FigletizeMojo extends AbstractMojo {
	
//	protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Parameter( property = "executedProject", readonly=true )
    private MavenProject executedProject;	
	
    @Parameter( property = "text", defaultValue="${project.artifactId}", required=true)
    private String text;
	
    @Parameter(property = "driver", defaultValue="jfiglet", required=true)
    private String driver;

    @Parameter( property = "font", defaultValue="standard")
	private String font;
    
	@Override
	public final void execute() throws MojoExecutionException, MojoFailureException {
		 try {
			executeInternal();
		} catch (Exception e) {
			getLog().error("Unexpected Exception while figletizzzzzzzzzzzing: " + e.getMessage(), e);
			throw new MojoExecutionException("Unexpected Exception while figletizzzzzzzzzzzing: " + e.getMessage(), e);
		}

	}

	protected void executeInternal() throws Exception {
		
		Types type = Driver.Types.valueOf(driver);
		
		OutputStream out = System.out;
		
		Figletizzr.print(Figletizzr
				.byType(type)
				.text(text)
				.font(font)
				.out(out)
			);
		
	}

}
