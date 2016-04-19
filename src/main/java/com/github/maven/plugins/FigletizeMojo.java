package com.github.maven.plugins;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.InstantiationStrategy;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.lalyos.jfiglet.FigletFont;

@Execute(goal="figletize", phase=LifecyclePhase.VALIDATE)
@Mojo(name = "figletize", requiresProject=true, threadSafe = true, defaultPhase = LifecyclePhase.VALIDATE, instantiationStrategy = InstantiationStrategy.SINGLETON)
public class FigletizeMojo extends AbstractMojo {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Get the executed project from the forked lifecycle.
     */
    @Parameter( property = "executedProject" )
    private MavenProject executedProject;

    @Parameter( property = "text", defaultValue="${executedProject.artifactId}" )
    private String text;
	
	@Override
	public final void execute() throws MojoExecutionException, MojoFailureException {
		 try {
			executeInternal();
		} catch (Exception e) {
			throw new MojoExecutionException("Unexpected Exception while figletizing: " + e.getMessage(), e);
		}

	}

	protected void executeInternal() throws Exception {
		
		
		String text = executedProject.getArtifactId();
		String asciiArt = FigletFont.convertOneLine(text);
		logger.info(asciiArt);
	}

}
