package service;

import service.exception.ServiceLoadException;

/**
 * Factory to create the various services as needed
 * 
 * @author johannablumenthal
 *
 */

public class ServiceFactory {
	private ServiceFactory() {
		
	}
	
	private static ServiceFactory serviceFactory = new ServiceFactory();
	
	public static ServiceFactory getInstance() {
		return serviceFactory;
	};
	
	public IService getService(String serviceName) throws ServiceLoadException {
		
		try {
			Class<?> c = Class.forName(getImplName(serviceName));
			return (IService )c.newInstance();
		} catch (Exception e) {
			throw new ServiceLoadException(serviceName + " not loaded");
		}
	};
	
	private String getImplName (String serviceName) throws Exception {
		java.util.Properties props = new java.util.Properties();
		java.io.FileInputStream fis = new java.io.FileInputStream("config/serviceNames.txt");
		props.load(fis);
		fis.close();
		return props.getProperty(serviceName);
	}

}
