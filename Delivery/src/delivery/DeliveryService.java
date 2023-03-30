package delivery;

public interface DeliveryService {
	public String publicService();
	public String LoginVerification(String username,String password);
	public void defaultList();
	public void printItemList();
	public void addItem(String dName, float dCost);
	public void removeItem(int dId);
	public float calculateBill(int dId, int Qty,int count);
	public float calcSubTotal(float total, float discount);
	public int getListSize();
	public float calcBalance(float subTotal, float cash);
}
