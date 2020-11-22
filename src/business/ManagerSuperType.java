package business;

import service.IService;
import service.ServiceFactory;
import service.exception.ServiceLoadException;

/**
 * This is a superclass that will be the parent for all of the manager classes in the business layer. 
 * This class will allow each of its children to be able to use the factory to get the services it needs to complete the user's requests.
 * @author johannablumenthal
 *
 */
public abstract class ManagerSuperType {
	
	private ServiceFactory serviceFactory = ServiceFactory.getInstance();
	
	protected IService getService(String serviceName) throws ServiceLoadException {
		
		return serviceFactory.getService(serviceName);
	}

}
