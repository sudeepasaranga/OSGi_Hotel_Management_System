package roomreservation;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceListener;

import roomreservation.RoomReservationService;
import roomreservation.RoomReservationServiceImpl;

import org.osgi.framework.ServiceEvent;

import java.util.Hashtable;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("Language","English");
		bundleContext.registerService(RoomReservationService.class.getName(),new RoomReservationServiceImpl(),props);
       System.out.println("Room Producer Service registered and started successfully");
	
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Room Producer Service  stop successfully");
	}


}
