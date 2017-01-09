
# jfiglet-maven-plugin
[![Build Status](https://api.travis-ci.org/metrizzle/jfiglet-maven-plugin.svg)](https://api.travis-ci.org/metrizzle/jfiglet-maven-plugin)

Decorate your builds with [figlet](http://www.figlet.org/) ascii banners like

Generates banners on the jvm with help of several libs
- [jfiglet](https://lalyos.github.io/jfiglet/)
- [pyfiglet](https://github.com/pwaller/pyfiglet)
- [figjet-js](https://github.com/patorjk/figlet.js)

```
<dependency>
	<groupId>${project.groupId}</groupId>
	<artifactId>${project.artifactId}</artifactId>
	<version>${project.version}</version>
</dependency>
```

```
  _________ _______________          ______      _____
  ______  /____  ____/___(_)_______ ____  /_____ __  /_
  ___ _  / ___  /_    __  / __  __ `/__  / _  _ \_  __/
  / /_/ /   _  __/    _  /  _  /_/ / _  /  /  __// /_  
  \____/    /_/       /_/   _\__, /  /_/   \___/ \__/  
  jflight-maven-plugin      \____/
```

```
                        _|_|  _|            _|              _|
_|_|_|    _|    _|    _|            _|_|_|  _|    _|_|    _|_|_|_|
_|    _|  _|    _|  _|_|_|_|  _|  _|    _|  _|  _|_|_|_|    _|
_|    _|  _|    _|    _|      _|  _|    _|  _|  _|          _|
_|_|_|      _|_|_|    _|      _|    _|_|_|  _|    _|_|_|      _|_|
_|              _|                      _|
_|          _|_|                    _|_|
```

```
___________.___  ________.__          __          __        
\_   _____/|   |/  _____/|  |   _____/  |_       |__| ______
 |    __)  |   /   \  ___|  | _/ __ \   __\      |  |/  ___/
 |     \   |   \    \_\  \  |_\  ___/|  |        |  |\___ \
 \___  /   |___|\______  /____/\___  >__| /\ /\__|  /____  >
     \/                \/          \/     \/ \______|    \/
```

## Usage

TBD Commandline example

The ˚figletize˚ goal allows generating ascii banner from specified  text parameter.
```
<plugin>
    <groupId>com.github.maven.plugins</groupId>
    <artifactId>jfiglet-maven-plugin</artifactId>
    <configuration>
    	<driver>jfiglet</driver>
        <text>jfiglet</text>
        <font>slanr</font>
        <!--
        <font>classpath:slant.flf</font>
        <splash>true</splash>
        <outputFileName>banner.txt</outputFileName>
        -->
    </configuration>
</plugin>
```

## Figlet Libraries and fonts
The plugin is tested and packaged with the mentioned `Driver` libraries.

The integration of pyfiglet and figlet-js are based on the Java ScriptEngine abstraction.

Jython is utilized to run the python code from pyfiglet. Nashorn is used to execute the javascript code.
 
The driver runtime exposes an internal java interface to control and postprocess the output.
 
The font files packaged with the driver libraries are made available exclusive when resolving resource fonts. 


## TODO

* -Support and tests bannerFileName option ˚<bannerFileName>banner.txt</bannerFileName>˚-
* -Goal and tests standalone execution (preview printing from cmdline)-
* Enable driver specific options kerning, smushing via cmd
* Goal for printing all packaged fonts figlist
* Goal for font details
* Resolve arbitary http fonts files into driver environment
* Resolve arbitary classpath fonts files driver independent 
* Toilet support for color schemes -> http://caca.zoy.org/wiki/toilet
* Create a list from font files <contributors></contributors>
* Add pre and postprocessing hooks -> additional lines etc. 
* Train a neural network on ascii texts and see what it outputs - Wait wooat

## Testing
The plugin utilizes [takari.io](http://takari.io/) Maven Plugin Testing support
See [takari-plugin-testing-project](https://github.com/takari/takari-plugin-testing-project/blob/master/testproperties.md) pages for details.

## Resources

### Figlet Font
- [FigFont Library](https://github.com/cmatsuoka/figlet-fonts) from github
- [history of FIGlet](http://www.figlet.org/figlet_history.html)
- [FAQ](http://www-personal.umich.edu/~knassen/ians.faq.html)
- [Figlet.org contributed font] ftp://ftp.figlet.org/pub/figlet/fonts/contributed/


- http://www-personal.umich.edu/~knassen/figlet.html
- http://artii.herokuapp.com/
- http://www.jave.de/eclipse/figlet/index.html its not just FIGlet its  much more, includes swing editor and so ...
- http://www.rigaut.com/benoit/CERN/FigletJava/ it contains a single class implementation, so i choose this one.


### Maven
- [Testing Maven Plugin with Takari](http://takari.io/book/70-testing.html)

- [Maven vars and properties overview](https://github.com/cko/predefined_maven_properties/blob/master/README.md)

- [Maven reference book filtering properties](https://books.sonatype.com/mvnref-book/reference/resource-filtering-sect-properties.html)

- [Mojohaus Code Guidelines](http://www.mojohaus.org/development/guidelines.html)

- [Mojohaus Releases](http://www.mojohaus.org/development/performing-a-release.html)

### Python/Jython
- [Jython Modules](https://docs.python.org/2/tutorial/modules.html)
- [Python Packages](https://docs.python.org/2/tutorial/modules.html#packages)


- http://www.network-science.de/ascii/

- https://de.wikipedia.org/wiki/FIGlet-Font
- http://www.jave.de

