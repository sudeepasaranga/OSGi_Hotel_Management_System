package delivery;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Delivery Publisher start");
		DeliveryService deliveryservicepublish = new DeliveryServiceImpl();
		publishServiceRegistration = context.registerService(
				DeliveryService.class.getName(), deliveryservicepublish, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Delivery Publisher stop");
		publishServiceRegistration.unregister();
	}

}
