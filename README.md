# jfiglet-maven-plugin
Decorate your builds with [figlet](http://www.figlet.org/) ascii banners like
```
  _________ _______________          ______      _____
  ______  /____  ____/___(_)_______ ____  /_____ __  /_
  ___ _  / ___  /_    __  / __  __ `/__  / _  _ \_  __/
  / /_/ /   _  __/    _  /  _  /_/ / _  /  /  __// /_  
  \____/    /_/       /_/   _\__, /  /_/   \___/ \__/  
  jflight-maven-plugin
```


Based on the [jfiglet](https://lalyos.github.io/jfiglet/) java implementation available from central
```
<dependency>
	<groupId>com.github.lalyos</groupId>
	<artifactId>jfiglet</artifactId>
	<version>0.0.7</version>
</dependency>
```

## Usage
The figletize goal allows generating ascii banner for your build. 
```
<plugin>
    <groupId>com.github.maven.plugins</groupId>
    <artifactId>jfiglet-maven-plugin</artifactId>
    <version>${it-plugin.version}</version>
    <configuration>
        <text>jfiglet-maven-plugin</text>
        <font>slanr</font>
        <!--<font>classpath:slant.flf</font>-->
        <splash>true</splash>
        <outputFileName>banner.txt</outputFileName>
    </configuration>
</plugin>
```

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