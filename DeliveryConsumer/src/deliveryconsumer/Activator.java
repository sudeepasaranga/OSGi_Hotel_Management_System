package deliveryconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import delivery.DeliveryService;
import delivery.DeliveryServiceImpl;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("start subscriber service");
		serviceReference = context.getServiceReference(DeliveryService.class.getName());
		DeliveryService deliveryServicePublish = (DeliveryService) context.getService(serviceReference);
		System.out.println(deliveryServicePublish.publicService());
		
		
		try
		{  
			String username, password,choice,dName ;
			float dCost, discount,cash, balance;
			int dId;
			
			deliveryServicePublish.defaultList();
			Scanner scanner = new Scanner(System.in);
			while(true) {
				System.out.println(" ");
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
				System.out.println(" ");
				System.out.println("<< if you wont exit enter 'end' for username >>");
				System.out.println("================= Login =====================");
				System.out.print("Enter UserName : ");
				username = scanner.next();
				if( username.equals("end")) {
					System.out.println("Ending Delivery Service Billing");
					break;
				}
				System.out.print("Enter Password : ");
				password = scanner.next();
				System.out.println("==========================================\n");
				choice = deliveryServicePublish.LoginVerification(username, password);
				if(choice=="admin") {
					System.out.println("~~~~~~~~~~~ Welcome to Delivery Management ~~~~~~~~~~~");
					deliveryServicePublish.printItemList();
					while(true) {
						System.out.print("Do you want to Add/ Remove delivery area or logout (add / remove / logout)? :");
						choice = scanner.next();
						if(choice.equals("add")) {
							System.out.print("Enter Delivery place : ");
							dName = scanner.next();
							System.out.print("Enter Delivery Cost : ");
							dCost = scanner.nextFloat();
							deliveryServicePublish.addItem(dName, dCost);
							deliveryServicePublish.printItemList();
						}else if(choice.equals("remove")) {
							System.out.print("Enter Delivery Id : ");
							dId = scanner.nextInt();
							deliveryServicePublish.removeItem(dId);
							deliveryServicePublish.printItemList();
						}else if(choice.equals("logout")) {
							break;
						}else {
							System.out.println("Error: Not found! Please recheck!");
						}
					}
				}
				else if (choice == "cashier") {
					System.out.println("THARU HOTEL");
					System.out.println("~~~~~~~~~~~ Welcome cashier ~~~~~~~~~~~");
					while(true) {
						float total =0;
						System.out.print("You wont logout? (y / n) : ");
						choice = scanner.next();
						System.out.print("\n");
						if(choice.equals("y")) {
							break;
						}else {
							deliveryServicePublish.printItemList();
							System.out.println("<< If need get total enter 0 >>");
							System.out.println("_______________INVOICE___________________");
							int count = 0;
							while(true) {
								System.out.print("Enter Delivery Area Id : ");
								dId = scanner.nextInt();
								if(dId == 0) {
									break;
								}else if((dId<=deliveryServicePublish.getListSize()) && dId>0) {
									System.out.print("Enter Number of km : ");
									int Qty = (int) scanner.nextFloat();
									total = total + deliveryServicePublish.calculateBill(dId, Qty, count);
									System.out.println("--------------------------------------");
									count++;
								}else {
									System.out.println("Error : Invalid Number");
								}
							}
							System.out.println("---------------------------------------");
							System.out.println("Total Amount = " + total);
							System.out.print("Enter Discount % : " );
							discount = scanner.nextFloat();
							float subTotal = deliveryServicePublish.calcSubTotal(total, discount);
							System.out.println("========================================");
							System.out.println("Sub Total = " + subTotal);
							System.out.println("========================================");
							System.out.print("Enter Cash : " );
							cash = scanner.nextFloat();
							balance = deliveryServicePublish.calcBalance(subTotal, cash);
							System.out.println("Balance = " + balance);
							System.out.println("No of Delivery Areas = " + count);
							System.out.println("~~ Delivery Charges added. Order is placed! ~~ ");
							System.out.println("__________________________________________");
						}
					}
				}
				else {
					System.out.println("Error: Invalid!");
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}	
	}

	

	public void stop(BundleContext context) throws Exception {
		System.out.println("THARU HOTEL-COLOMBO \n Good bye!!");
		context.ungetService(serviceReference);
	}

}
