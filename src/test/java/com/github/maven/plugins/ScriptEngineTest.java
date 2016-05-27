package com.github.maven.plugins;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

import org.junit.Test;


public class ScriptEngineTest {

	ScriptEngineManager mgr = new ScriptEngineManager();	

	@Test
	public void listEngines() {
		System.out.println(
				ScriptEngineInfo.readInfos(mgr).stream());
//				.
				
				//.map(ScriptEngineInfo::toString).collect(Collectors.joining("\n")));
	}

	static class ScriptEngineInfo {
		
		String engName;
		String engVersion;
		String langName;
		String langVersion;
		List<String> engNames;
		
		public static final List<ScriptEngineInfo> readInfos(ScriptEngineManager mgr) {
			List<ScriptEngineFactory> factories = mgr.getEngineFactories();
			List<ScriptEngineInfo> result = new LinkedList<ScriptEngineInfo>();
			for (ScriptEngineFactory factory : factories) {
				ScriptEngineInfo info = new ScriptEngineInfo();
				info.engName = factory.getEngineName();
				info.engVersion = factory.getEngineVersion();
				info.langName = factory.getLanguageName();
				info.langVersion = factory.getLanguageVersion();
				info.engNames = factory.getNames();
				
				result.add(info);
			}
			return result;
		}		
		
		@Override
		public String toString() {
			return String.format("Script Engine: %s (%s)\n"
					+ "\tEngine Languages: %s\n"
					+ "\tEngine Alias: %s\n", engName, engVersion, langName, engNames);
		}

	}

}