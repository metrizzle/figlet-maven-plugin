package com.github.maven.plugins;

import java.util.LinkedList;
import java.util.List;

public abstract class Figletizzr {
	
	private static final Driver<FigletOptionsRequest> fallback = new JFigletDriver();
	
	public static class Builder {
		
	}
	
	public static Builder f() {
		return new Builder();
	}
	
	public static void fig(String cmdline) {
		//get default driver
		Driver<FigletCmdRequest> d = lookupDefaultDriver(FigletCmdRequest.class);
		FigletCmdRequest req = new FigletCmdRequest(cmdline);
		
		//validate options
		d.handleFigletRequest(req);
	}
	
	private static <RequestType extends FigletRequest> Driver<RequestType> lookupDefaultDriver(Class<RequestType> requestType) {
		
		List<Driver<RequestType>> available = new LinkedList<>();
		
		//TODO
		Driver<RequestType> defaultDriver = (Driver<RequestType>) fallback;
		return defaultDriver;
	}

	public static void print(Driver<FigletOptionsRequest> fig, String string) {		
		FigletOptionsRequest req = new FigletOptionsRequest()
			.out(System.out)
			.text(string);
		fig.handleFigletRequest(req);
	}

	public static void print(Driver<FigletOptionsRequest> fig) {
		FigletOptionsRequest f = new FigletOptionsRequest(fig, "default")
			.out(System.out);		
		fig.handleFigletRequest(f);
	}

	public static void print(FigletOptionsRequest fig) {
		Driver<FigletOptionsRequest> d = lookupDefaultDriver(FigletOptionsRequest.class);
		d.handleFigletRequest(fig);
//		fig.driver.handleFigletRequest(fig);
	}

	public static void print(Driver<FigletOptionsRequest> fig, FigletOptionsRequest req) {
		//redirect system.out
		fig.handleFigletRequest(req);
		
	}	
}
