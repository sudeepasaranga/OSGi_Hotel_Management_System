package inventory;

public interface InventoryService {
	public String userLogin(String username,String password);
	public void ProductList();
	public void printProducts();
	public void addFoodItem(String productName, Double amount);
	public void addKitchenware(String productName, Integer amount);
	public void addFoodAmount(String productName, Double productAmount);
	public void addKitchenwareAmount(String productName, Integer productAmount);
	public void removeFoodItem(String productName);
	public void removeKitchenware(String productName);
	public void removeFoodAmount(String productName,Double productAmount);
	public void removeKitchenwareAmount(String productName,Integer productAmount);
	public void generateStockOrder(String productName, Integer kitchenwareAmount, double foodAmount);
	public void printStockOrder();
	public void supplyReport(String supplyProduct, Double supplyAmount, Integer supplyQty, Double supplyPrice);
	public void printSupplyReport(double foodTotal, double kitchenTotal, Double rate);
	public double calculateFoodTotal(Double supplyPrice, Double supplyAmount);
	public double calculateKitchenTotal(Double supplyPrice, Integer supplyQty);
}
