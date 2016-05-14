//var Paths = Java.type('java.nio.file.Paths');
//var Files = Java.type('java.nio.file.Files');

var FontResources = Java.type('com.github.maven.plugins.FontResources');


fontDir = 'figlet-js/fonts/';

/*
    Loads a font into the figlet object.

    Parameters:
    - name (string): Name of the font to load.
    - next (function): Callback function.
*/
figlet.loadFont = function(name, next) {
		
	if(!FontResources.resourceExists(fontDir, name + '.flf')) {
		throw new Error("Resource with name: " + name + " does not exist. FontDir: " + fontDir)
	}
			
	//Files.re
	var fontData = FontResources.resolveResource(fontDir, name + '.flf');
	
    try {
        next(null, figlet.parseFont(name, fontData));
    } catch(error) {
        next(error);
    }	

};

console = { 
	    log: print,
	    warn: print,
	    error: print
};