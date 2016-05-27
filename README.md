
```
  _________ _______________          ______      _____
  ______  /____  ____/___(_)_______ ____  /_____ __  /_
  ___ _  / ___  /_    __  / __  __ `/__  / _  _ \_  __/
  / /_/ /   _  __/    _  /  _  /_/ / _  /  /  __// /_  
  \____/    /_/       /_/   _\__, /  /_/   \___/ \__/  
  jflight-maven-plugin      \____/
```
[![Build Status](https://api.travis-ci.org/metrizzle/jfiglet-maven-plugin.svg)](https://api.travis-ci.org/metrizzle/jfiglet-maven-plugin)

# jfiglet-maven-plugin
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

The ˚figletize˚ goal allows generating ascii banner from specified 
text parameter.
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

The integration of pyfiglet and figlet-js are based on
the Java ScriptEngine abstraction.
jython is utilized to run the python code from pyfiglet
nashorn is used to execute the javascript code.
 
The driver runtime exposes an internal java interface 
to control and postprocess the output.
 
The font files packaged with the driver libraries
are made available exclusive when resolving
resource fonts. 


## TODO

* Gaol and example standalone
* Goal for testing and listing
* Enable driver specific options
* Support and tests for ˚<outputFileName>banner.txt</outputFileName>˚
* Resolve arbitary http fonts
* Resolve arbitary classpath fonts


## Testing
The plugin utilizes [takari.io](http://takari.io/) Maven Plugin Testing support
See [takari-plugin-testing-project](https://github.com/takari/takari-plugin-testing-project/blob/master/testproperties.md) pages for details.

## Figlet Links
- [FigFont Library](https://github.com/cmatsuoka/figlet-fonts) from github
- [history of FIGlet](http://www.figlet.org/figlet_history.html)
- [Maven Vars and Properies Oerview](https://github.com/cko/predefined_maven_properties/blob/master/README.md)
- ftp://ftp.figlet.org/pub/figlet/fonts/contributed/
- [FAQ](http://www-personal.umich.edu/~knassen/ians.faq.html)
- https://books.sonatype.com/mvnref-book/reference/resource-filtering-sect-properties.html

- [Jython Modules](https://docs.python.org/2/tutorial/modules.html)
- https://docs.python.org/2/tutorial/modules.html#packages


- http://www-personal.umich.edu/~knassen/figlet.html
- http://artii.herokuapp.com/
- http://www.jave.de/eclipse/figlet/index.html its not just FIGlet its  much more, includes swing editor and so ...
- http://www.rigaut.com/benoit/CERN/FigletJava/ it contains a single class implementation, so i choose this one.
- http://takari.io/book/70-testing.html Testing Maven Plugin
- http://www.network-science.de/ascii/

- http://www.mojohaus.org/development/guidelines.html
- https://de.wikipedia.org/wiki/FIGlet-Font
- http://www.jave.de
- http://www.mojohaus.org/development/performing-a-release.html
