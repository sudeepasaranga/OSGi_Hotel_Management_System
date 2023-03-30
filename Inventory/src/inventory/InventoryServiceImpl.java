package inventory;

import java.util.HashMap;

public class InventoryServiceImpl implements InventoryService{

	HashMap<String, Double> food = new HashMap<String, Double>();
	HashMap<String, Integer> kitchenware = new HashMap<String, Integer>();

	@Override
	public String userLogin(String username, String password) {
		if ((username.equals("admin")) && (password.equals("678"))) {
			return "admin";
		} else if ((username.equals("supplier")) && (password.equals("456"))) {
			return "supplier";
		} else {
			return "invalid";
		}
	}

	@Override
	public void ProductList() {
		food.put("Carrot", 12.50);
		food.put("Rice", 100.00);
		food.put("Apple", 25.50);
		food.put("Leeks", 32.00);
		food.put("Sugar", 30.00);
		food.put("Milk", 45.00);
		kitchenware.put("Knives", 20);
		kitchenware.put("Spoons", 1000);
		kitchenware.put("Cups", 1000);
		kitchenware.put("Plates", 1000);
	}

	@Override
	public void printProducts() {
		System.out.println("\n============Inventory Products============");
		System.out.println("\n\tFood Products\tAmount(kg)\n");
		for (String i : food.keySet()) {
			System.out.println("\t" + i + "\t\t" + food.get(i));
		}

		System.out.println("\n\tKitchenware\tAmount\n");
		for (String i : kitchenware.keySet()) {
			System.out.println("\t" + i + "\t\t" + kitchenware.get(i));
		}
		System.out.println();
	}

	@Override
	public void addFoodItem(String productName, Double amount) {
		food.put(productName, amount);
	}

	@Override
	public void addKitchenware(String productName, Integer amount) {
		kitchenware.put(productName, amount);
	}

	@Override
	public void addFoodAmount(String productName, Double productAmount) {
		if (food.get(productName) != null) {
			food.put(productName, (food.get(productName) + productAmount));
		} else {
			System.out.println("No such product exist");
		}
	}

	@Override
	public void addKitchenwareAmount(String productName, Integer productAmount) {
		if (kitchenware.get(productName) != null) {
			kitchenware.put(productName, (kitchenware.get(productName) + productAmount));
		} else {
			System.out.println("No such product exist");
		}

	}

	@Override
	public void removeFoodItem(String productName) {
		if (food.get(productName) != null) {
			food.remove(productName);
		} else {
			System.out.println("No such product exist");
		}

	}

	@Override
	public void removeKitchenware(String productName) {
		if (kitchenware.get(productName) != null) {
			kitchenware.remove(productName);
		} else {
			System.out.println("No such product exist");
		}
	}

	@Override
	public void removeFoodAmount(String productName, Double productAmount) {

		if (food.get(productName) != null) {
			food.put(productName, (food.get(productName) - productAmount));
		} else {
			System.out.println("No such product exist");
		}

	}

	@Override
	public void removeKitchenwareAmount(String productName, Integer productAmount) {
		if (kitchenware.get(productName) != null) {
			kitchenware.put(productName, (kitchenware.get(productName) - productAmount));
		} else {
			System.out.println("No such product exist");
		}

	}

	@Override
	public double calculateFoodTotal(Double productPrice, Double productQty) {
		return (productPrice * productQty);
	}

	@Override
	public double calculateKitchenTotal(Double supplyPrice, Integer supplyQty) {
		return (supplyPrice * (double) supplyQty);

	}

	@Override
	public void generateStockOrder(String productName, Integer kitchenwareAmount, double foodAmount) {
		if (foodAmount != 0.00) {
			food.put(productName, foodAmount);
		} else if (kitchenwareAmount != 0) {
			kitchenware.put(productName, kitchenwareAmount);
		} else {
			System.out.println("Please Enter Valid Inputs");
		}

	}

	@Override
	public void printStockOrder() {
		System.out.println("\n============Inventory Order============");
		System.out.println("\n\tFood Products\tAmount(kg)\n");
		for (String i : food.keySet()) {
			System.out.println("\t" + i + "\t\t" + food.get(i));
		}

		System.out.println("\n\tKitchenware\tAmount\n");
		for (String i : kitchenware.keySet()) {
			System.out.println("\t" + i + "\t\t" + kitchenware.get(i));
		}
		System.out.println();
	}

	@Override
	public void printSupplyReport(double foodTotal, double kitchenTotal, Double rate) {
		double totalPrice = foodTotal + kitchenTotal;
		double discount = totalPrice * rate / 100.0;
		System.out.println();
		System.out.println("Total Price = " + totalPrice);
		System.out.println("Discount = " + discount);
		System.out.println("Discounted Price = " + (totalPrice-discount));
		System.out.println("===================================================");
	}

	@Override
	public void supplyReport(String supplyProduct, Double supplyAmount, Integer supplyQty, Double supplyPrice) {
		if (supplyAmount != 0.00) {
			System.out.println("\n\tFood Products\tAmount(kg)\tPrice(Rs)\n");
			System.out.println("\t" + supplyProduct + "\t\t" + supplyAmount + "\t\t"
					+ calculateFoodTotal(supplyPrice, supplyAmount));
		} else if (supplyQty != 0) {
			System.out.println("\n\tKitchenware\tAmount\t\tPrice(Rs)\n");
			System.out.println(
					"\t" + supplyProduct + "\t\t" + supplyQty + "\t\t" + calculateKitchenTotal(supplyPrice, supplyQty));

		}

	}
}
