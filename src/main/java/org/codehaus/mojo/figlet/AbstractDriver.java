package com.github.maven.plugins;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class AbstractDriver<R extends FigletRequest> implements Driver<R> {

	protected abstract void handleFigletRequestInternal(R req) throws Exception;

	@Override
	public final void handleFigletRequest(R req) {
		try {
			handleFigletRequestInternal(req);
		} catch (Exception e) {
			throw new FigletRenderingError("unexpected error: " + e.getMessage(), e);
		}
	}
	
	protected Set<String> doFindAllClassPathResources(String path) throws IOException {
		Set<String> result = new LinkedHashSet<String>(16);
		ClassLoader cl = getClassLoader();
		Enumeration<URL> resourceUrls = (cl != null ? cl.getResources(path) : ClassLoader.getSystemResources(path));
		while (resourceUrls.hasMoreElements()) {
			URL url = resourceUrls.nextElement();
			result.add(convertClassLoaderURL(url));
		}
//		if ("".equals(path)) {
//			// The above result is likely to be incomplete, i.e. only containing file system references.
//			// We need to have pointers to each of the jar files on the classpath as well...
//			addAllClassLoaderJarRoots(cl, result);
//		}
		return result;
	}	
		
	
	private String convertClassLoaderURL(URL url) {
		// TODO Auto-generated method stub
		return null;
	}

	private ClassLoader getClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}


	public static class FigletRenderingError extends RuntimeException {
		public FigletRenderingError(String string, Exception e) {
			super(string, e);
		}

		private static final long serialVersionUID = -1899379068265830033L;
		
	}
	
	@Override
	public final String toString() {
		return getName();
	}

	protected String getName() {
		return getClass().getSimpleName().toLowerCase().replace("driver", "");
	}
	
}
