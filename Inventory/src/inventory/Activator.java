package inventory;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Stock Producer Service Started!");
		InventoryService stockService = new InventoryServiceImpl();
		publishServiceRegistration = context.registerService(InventoryService.class.getName(),stockService,null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stock Producer Service Stopped!");
		publishServiceRegistration.unregister();
	}

}
