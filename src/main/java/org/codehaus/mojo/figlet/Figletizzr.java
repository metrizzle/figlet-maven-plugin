package org.codehaus.mojo.figlet;

import org.codehaus.mojo.figlet.Driver.Types;

/**
 * Static methods to output and configure figlet prints
 * 
 */
public abstract class Figletizzr {
	
    //TODO
	private static final Driver<FigletOptionsRequest> fallback = new JFigletDriver();
	
	/**
	 * delegate to the driver using and args String
	 * @param cmdline
	 */
	public static void fig(String cmdline) {
		//get default driver
		Driver<FigletCmdRequest> d = lookupDefaultDriver(FigletCmdRequest.class);
		FigletCmdRequest req = new FigletCmdRequest(cmdline);
		
		//validate options
		d.handleFigletRequest(req);
	}
	
	//TODO use builder callbacks
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
	
	public static FigletOptionsRequest byType(Types driverType) {
		if(driverType == null) {
			throw new IllegalArgumentException("DriverType must be set");
		}
		
		Driver<FigletOptionsRequest> driver = createDriver(driverType.getDefaultJavaType());
		FigletOptionsRequest req  = new FigletOptionsRequest(driver, null);
		return req;
	}	
	
	@SuppressWarnings("unchecked")
	private static Driver<FigletOptionsRequest> createDriver(Class<Driver<?>> class1) {
		try {
			return (Driver<FigletOptionsRequest>) class1.newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException("Driver seems not to be available: " + e.getMessage(), e); 
		}
	}
	
	private static <RequestType extends FigletRequest> Driver<RequestType> lookupDefaultDriver(Class<RequestType> requestType) {
	//	TODO lookup defaults
//		List<Driver<RequestType>> available = new LinkedList<>();
		
		Driver<RequestType> defaultDriver = (Driver<RequestType>) fallback;
		return defaultDriver;
	}	
}
