package foodbilling;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext Context) throws Exception {
		System.out.println(" Food Billing Service Start ~");
		FoodBillingService foodbillingservice = new FoodBillingServiceImpl();
		publishServiceRegistration = Context.registerService(
				FoodBillingService.class.getName(), foodbillingservice, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println(" Food Billing Service Stop ~\n");
		System.out.println(" -- The Tharu Hotel --");
		System.out.println("   Have a nice day !\n");
		publishServiceRegistration.unregister();
	}

}
