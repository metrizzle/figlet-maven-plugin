package org.codehaus.mojo.figlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.codehaus.mojo.figlet.Driver.Types;

@Mojo( name = "touch", requiresProject = true, threadSafe = false, defaultPhase = LifecyclePhase.GENERATE_RESOURCES )
public class TouchMojo
    extends AbstractMojo
{

    @Parameter( property = "text", defaultValue = "${project.artifactId}", required = true )
    String text;

    @Parameter( property = "driver", defaultValue = "jfiglet", required = true )
    String driver;

    @Parameter( property = "font", defaultValue = "standard" )
    String font;

    @Parameter( property = "bannerFileName", defaultValue = "banner.txt" )
    String bannerFileName = "banner.txt";

    /**
     * Location of the file.
     */
    @Parameter( defaultValue = "${project.build.directory}", property = "outputDir", required = true )
    private File outputDirectory;

    @Override
    public void execute()
        throws MojoExecutionException
    {

        File f = outputDirectory;

        if ( !f.exists() )
        {
            f.mkdirs();
        }

        File touch = new File( f, bannerFileName );
        Types type = Driver.Types.valueOf( driver );

        FileOutputStream out = null;
        try
        {
            out = new FileOutputStream( touch );
            Figletizzr.print( Figletizzr.byType( type ).text( text ).font( font ).out( out ) );
        }
        catch ( IOException e )
        {
            throw new MojoExecutionException( "Error creating file " + touch, e );
        }
        finally
        {
            if ( out != null )
            {
                try
                {
                    out.close();
                }
                catch ( IOException e )
                {
                    // ignore
                }
            }
        }
    }
}
