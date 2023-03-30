package inventoryconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import inventory.InventoryService;
import inventory.InventoryServiceImpl;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Stock Consumer Service Started!");
		serviceReference = context.getServiceReference(InventoryService.class.getName());
		InventoryService servicePublish = (InventoryService) context.getService(serviceReference);

		try {
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

			String username, password, choice, productName, supplyProduct;
			Double productAmount, supplyAmount = 0.00, supplyPrice, discount;
			double kitchenTotal = 0.00, foodTotal = 0.00;
			Integer kitchenwareAmount, supplyQty = 0;

			InventoryService stockService = new InventoryServiceImpl();
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("\n!!!!!! Enter 'exit' for username to exit the system !!!!!!\n");
				System.out.println("============ Login ============");
				System.out.print("Enter UserName : ");
				username = scanner.next();
				if (username.equals("exit")) {
					System.out.println("Exiting from Inventory Management Service !!!!");
					break;
				}
				System.out.print("Enter Password : ");
				password = scanner.next();
				System.out.println("\n=================Logged for Inventory Management=====================\n");
				choice = stockService.userLogin(username, password);

				// admin operations
				if (choice == "admin") {

					System.out.println("~~~~~~~~~~~ Welcome Admin ~~~~~~~~~~~");

					System.out.print("Do you want to generate a stock order (yes/no) : ");
					choice = scanner.next();

					// Generating an order for the supplier
					if (choice.equals("yes")) {
						System.out.println("\n======= Enter 'print' to print the order ======\n");
						while (true) {
							System.out.print("Enter product type required (food/kitchenware) : ");
							choice = scanner.next();
							if (choice.equals("kitchenware")) {
								System.out.print("Enter the product name : ");
								productName = scanner.next();
								System.out.print("Enter amount required :");
								kitchenwareAmount = scanner.nextInt();
								stockService.generateStockOrder(productName, kitchenwareAmount, 0.00);
							} else if (choice.equals("food")) {
								System.out.print("Enter the product name : ");
								productName = scanner.next();
								System.out.print("Enter amount required in kg :");
								productAmount = scanner.nextDouble();
								stockService.generateStockOrder(productName, 0, productAmount);
							} else if (choice.equals("print")) {
								stockService.printStockOrder();
								break;
							} else {
								System.out.println("Invalid Input");
							}
						}
					}

					// Modifying the stocks
					else {
						stockService.ProductList();
						stockService.printProducts();
						while (true) {

							System.out.print("Which stocks you want to modify? (food/kitchenware)  :");
							choice = scanner.next();
							if (choice.equals("food")) {
								System.out.print("State the action you need to perform (add/remove) :");
								choice = scanner.next();

								if (choice.equals("add")) {
									System.out.print("What do you want to add (product/amount) : ");
									choice = scanner.next();

									if (choice.equals("product")) {
										System.out.print("Enter the product name:");
										productName = scanner.next();
										System.out.print("Enter the amount in kg:");
										productAmount = scanner.nextDouble();
										stockService.addFoodItem(productName, productAmount);
										stockService.printProducts();
									} else if (choice.equals("amount")) {
										System.out.print("Enter the product name to add the amount :");
										productName = scanner.next();
										System.out.print("Enter the amount in kg:");
										productAmount = scanner.nextDouble();
										stockService.addFoodAmount(productName, productAmount);
										stockService.printProducts();
									} else {
										System.out.println("Invalid Input");
									}
								} else if (choice.equals("remove")) {
									System.out.print("What do you want to remove (product/amount) : ");
									choice = scanner.next();

									if (choice.equals("product")) {
										System.out.print("Enter the product name of the product you want to remove:");
										productName = scanner.next();
										stockService.removeFoodItem(productName);
										stockService.printProducts();
									} else if (choice.equals("amount")) {
										System.out.print("Enter the product name to remove the amount :");
										productName = scanner.next();
										System.out.print("Enter the amount in kg:");
										productAmount = scanner.nextDouble();
										stockService.removeFoodAmount(productName, productAmount);
										stockService.printProducts();
									} else {
										System.out.println("Invalid Input");
									}
								} else {
									System.out.println("Invalid Operation");
								}

							} else if (choice.equals("kitchenware")) {
								System.out.print("State the action you need to perform (add/remove) :");
								choice = scanner.next();

								if (choice.equals("add")) {
									System.out.print("What do you want to add (product/amount) : ");
									choice = scanner.next();

									if (choice.equals("product")) {
										System.out.print("Enter the product name:");
										productName = scanner.next();
										System.out.print("Enter the amount:");
										kitchenwareAmount = scanner.nextInt();
										stockService.addKitchenware(productName, kitchenwareAmount);
										stockService.printProducts();
									} else if (choice.equals("amount")) {
										System.out.print("Enter the product name to add the amount :");
										productName = scanner.next();
										System.out.print("Enter the amount :");
										kitchenwareAmount = scanner.nextInt();
										stockService.addKitchenwareAmount(productName, kitchenwareAmount);
										stockService.printProducts();
									} else {
										System.out.println("Invalid Input");
									}
								} else if (choice.equals("remove")) {
									System.out.print("What do you want to remove (product/amount) : ");
									choice = scanner.next();

									if (choice.equals("product")) {
										System.out.print("Enter the product name of the product you want to remove:");
										productName = scanner.next();
										stockService.removeKitchenware(productName);
										stockService.printProducts();
									} else if (choice.equals("amount")) {
										System.out.print("Enter the product name to remove the amount :");
										productName = scanner.next();
										System.out.print("Enter the amount :");
										kitchenwareAmount = scanner.nextInt();
										stockService.removeKitchenwareAmount(productName, kitchenwareAmount);
										stockService.printProducts();
									} else {
										System.out.println("Invalid Input");
									}
								} else {
									System.out.println("Invalid Operation");
								}
							} else if (choice.equals("logout")) {
								break;
							} else {
								System.out.println("Invalid Input");
							}
						}
					}
				}
				// supplier operations
				else if (choice == "supplier") {
					System.out.println("\n~~~~~~~~~~~ Welcome Supplier ~~~~~~~~~~~\n");
					while (true) {

						System.out.print("Do you want to proceed?(yes/no) : ");
						choice = scanner.next();
						System.out.print("\n");
						if (choice.equals("no")) {
							break;
						} else {
							System.out.println("\n======= Enter 'report' to print the total supply ======\n");
							System.out.print("Do you want to supply food/kitchenware : ");
							choice = scanner.next();

							if (choice.equals("food")) {
								supplyQty = 0;
								System.out.print("Enter the product name : ");
								supplyProduct = scanner.next();
								System.out.print("Enter the amount in kg : ");
								supplyAmount = scanner.nextDouble();
								System.out.print("Enter the price of 1kg : ");
								supplyPrice = scanner.nextDouble();
								foodTotal += stockService.calculateFoodTotal(supplyPrice, supplyAmount);
								stockService.supplyReport(supplyProduct, supplyAmount, supplyQty, supplyPrice);
							} else if (choice.equals("kitchenware")) {
								supplyAmount = 0.00;
								System.out.print("Enter the product name : ");
								supplyProduct = scanner.next();
								System.out.print("Enter the amount : ");
								supplyQty = scanner.nextInt();
								System.out.print("Enter the price of one item : ");
								supplyPrice = scanner.nextDouble();
								kitchenTotal += stockService.calculateKitchenTotal(supplyPrice, supplyQty);
								stockService.supplyReport(supplyProduct, supplyAmount, supplyQty, supplyPrice);
							} else if (choice.equals("report")) {
								System.out.print("Enter the discount percentage : ");
								discount = scanner.nextDouble();
								stockService.printSupplyReport(foodTotal, kitchenTotal, discount);
								break;
							} else {
								System.out.println("Invalid Input");
							}

						}
					}
				} else {
					System.out.println("Invalid login");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Inventory Consumer Service Stopped!");
		context.ungetService(serviceReference);
	}

}
