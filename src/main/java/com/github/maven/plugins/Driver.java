package com.github.maven.plugins;

/**
 * really crappy strategy to the figletizing implementations.
 * @param <R>
 */
@FunctionalInterface
public interface Driver<R extends FigletRequest> {
	
	public enum Types {
		// NATIVE,
		figletjs (JsFigletDriver.class),
		pyfiglet (PyFigletDriver.class),
		jfiglet (JFigletDriver.class);
		
		private Class<Driver<?>> defaultJavaType;
		
		private Types(Class clazz) {
				// Assert.isTrue(clau);
			this.defaultJavaType =  clazz;
		}

		public Class<Driver<?>> getDefaultJavaType() {
			return defaultJavaType;
		}
	}
	
	/**
	 * handler steez foglet 
	 */
	void handleFigletRequest(R req);
	
//	public boolean supports(R req);
	
}
