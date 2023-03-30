package foodbillingconsumer;

import foodbilling.FoodBillingService;
import foodbilling.FoodBillingServiceImpl;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {


	ServiceReference serviceReference;

	public void start(BundleContext Context) throws Exception {
		System.out.println(" Food Billing Consumer Service Start ~");
		serviceReference = Context.getServiceReference(FoodBillingService.class.getName());
		FoodBillingService foodBillingService = (FoodBillingService) Context.getService(serviceReference);

try
		{  
			String username, password,choice,itemName ;
			float itemPrice, discount,cash, balance;
			int itemId;
			FoodBillingService foodbillingservice = new FoodBillingServiceImpl();
			foodbillingservice.defaultList();
			Scanner scanner = new Scanner(System.in);
			while(true) {
				
				System.out.println(" \n ************************************************************************* ");
				System.out.println(" **************************************************************************** ");
				System.out.println(" ****************************  *******  ************************************* ");
				System.out.println(" ****************************  ****        ********************************** ");
				System.out.println(" ****************************  **             ******************************* ");
				System.out.println(" ****************************  *                ***************************** ");
				System.out.println(" ****************************                     *************************** ");		
				System.out.println(" **************************                         ************************* ");
				System.out.println(" ***************************                      *************************** ");
				System.out.println(" ***************************        WELCOME       *************************** ");
				System.out.println(" ***************************          to          *************************** ");
				System.out.println(" ***************************    THE THARU HOTEL   *************************** ");
				System.out.println(" ***************************     --------------   *************************** ");
				System.out.println(" ***************************                      *************************** ");
				System.out.println(" ****************************************************************************\n");
				
				System.out.println(" ===========   Login   ======================================================\n");
				System.out.println(" ** If you wont exit enter 'end' for username ! ** ");
				System.out.print("         Enter UserName : ");
				
				username = scanner.next();
				if( username.equals("end")||username.equals("End")||username.equals("END")) {
					System.out.println("\n >>>>>>>>  Ending Food billing ");
					break;
				}
				
				System.out.print("         Enter Password : ");
				password = scanner.next();
				System.out.println(" ==================================\n");
				choice = foodbillingservice.LoginVerification(username, password);
				
				if(choice=="admin"||choice=="Admin"||choice=="ADMIN") {
					System.out.println(" ********* Welcome Admin **********\n");
					foodbillingservice.printItemList();
					while(true) {
						System.out.print(" You wont Add item or Remove item or logout (add / remove / logout) : ");
						choice = scanner.next();
						
						if(choice.equals("add")||choice.equals("Add")||choice.equals("ADD")) {
							System.out.print("         Enter Item Name  : ");
							itemName = scanner.next();
							System.out.print("         Enter Item Price : ");
							itemPrice = scanner.nextFloat();
							System.out.print("\n ");
							foodbillingservice.addItem(itemName, itemPrice);
							foodbillingservice.printItemList();
							
						} else if (choice.equals("remove")||choice.equals("Remove")||choice.equals("REMOVE")) {
							System.out.print("         Enter Item Id : ");
							itemId = scanner.nextInt();
							foodbillingservice.removeItem(itemId);
							System.out.print("\n         Removed Successfully ! \n\n");
							foodbillingservice.printItemList();
						} else if (choice.equals("logout")||choice.equals("Logout")||choice.equals("LOGOUT")) {
							System.out.print("\n         Logout Successfully ! \n\n");
							break;
						} else {
							System.out.println(" Error: Invalide Input !");
						}
					}
				}
				else if (choice == "cashier"||choice == "Cashier"||choice == "CASHIER") {
					System.out.println(" ********* Welcome Cashier ********\n");
					while(true) {
						float total =0;
						System.out.print(" You wont logout? (y / n) : ");
						choice = scanner.next();
						System.out.print("\n");
						if(choice.equals("y")||choice.equals("Y")) {
							System.out.print("         Logout Successfully ! \n\n");
							break;
						}else {
							foodbillingservice.printItemList();
							System.out.println(" \n =============  Bill  =============\n");
							System.out.println(" ** If need get total enter 0 ! **   \n" );
							int count = 0;
							while(true) {
								System.out.print("         Enter Item Id : ");
								itemId = scanner.nextInt();
								if(itemId == 0) {
									break;
								} else if ((itemId<=foodbillingservice.getListSize()) && itemId>0) {
									System.out.print("             Enter Qty : ");
									int Qty = (int) scanner.nextFloat();
									total = total + foodbillingservice.calculateBill(itemId, Qty, count);
									System.out.println("-----------------------------------\n");
									count++;
								} else {
									System.out.println(" Error : Invalide Input");
								}
							}
							System.out.println(" ==================================");
							System.out.println(" ");
							System.out.println("         Tatal Amount = Rs " + total);
							System.out.print("         Enter Discount % : " );
							
							discount = scanner.nextFloat();
							float subTotal = foodbillingservice.calcSubTotal(total, discount);
							
							System.out.println(" ==================================");
							System.out.println("         Sub Tatal = Rs " + subTotal);
							System.out.println(" ==================================");
							System.out.print("         Enter Cash : Rs " );
							
							cash = scanner.nextFloat();
							balance = foodbillingservice.calcBalance(subTotal, cash);
							System.out.println("         Balance = Rs " + balance);
							System.out.println("         No of Items = " + count);
							System.out.println(" ____________________________________________________________________________\n");
						}
					}
				} else {
					System.out.println(" Error: Invalide Input !");
				}
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}	
	} public void stop(BundleContext Context) throws Exception {
		System.out.println(" Stop Food Billing Consumer Service ~\n");
		System.out.println(" -- The Tharu Hotel --");
		System.out.println("   Have a nice day !\n");
		Context.ungetService(serviceReference);
	}

}
