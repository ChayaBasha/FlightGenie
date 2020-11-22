package service;

import java.io.FileInputStream;
import java.util.Properties;

import service.exception.ServiceLoadException;

/**
 * Factory to create the various services as needed
 * 
 * @author johannablumenthal
 *
 */

public class ServiceFactory {
	/**
	 * cache the props so that we can use it during the whole session
	 */
	private Properties props;

	private ServiceFactory() {

	}

	private static ServiceFactory serviceFactory = new ServiceFactory();

	public static ServiceFactory getInstance() {
		return serviceFactory;
	}

	public IService getService(String serviceName) throws ServiceLoadException {

		try {
			Class<?> c = Class.forName(getImplName(serviceName));
			return (IService) c.newInstance();
		} catch (Exception e) {
			throw new ServiceLoadException(serviceName + " not loaded");
		}
	}

	/**
	 * refactored this to only create properties once
	 * 
	 * @param serviceName
	 * @return
	 * @throws Exception
	 */

	private String getImplName(String serviceName) throws Exception {
		if (props == null) {
			props = new Properties();
			FileInputStream fis = new FileInputStream("config/serviceNames.properties");
			props.load(fis);
			fis.close();
		}

		return props.getProperty(serviceName);
	}

}
