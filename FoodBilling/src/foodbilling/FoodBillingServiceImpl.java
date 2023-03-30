package foodbilling;

import java.util.ArrayList;


public class FoodBillingServiceImpl implements FoodBillingService{
	
	ArrayList<String> items = new ArrayList<String>();
	ArrayList<Float> price = new ArrayList<Float>();
		
		public void defaultList() {
			
			items.add("Rice & Curry ");
			price.add((float) 250.00);
			
			items.add("Fried Rice   ");
			price.add((float) 350.00);
			
			items.add("Buriyani     ");
			price.add((float) 500.00);
			
			items.add("Kottu        ");
			price.add((float) 450.00);
			
			items.add("Noodles      ");
			price.add((float) 300.00);
		}

		public void printItemList() {
			System.out.println(" ------------Item List-------------");
			for (int i = 0; i < price.size(); i++)
			  {
		        System.out.println(i+1 + "  " +items.get(i) +"  Rs:"+price.get(i));
		      }
			System.out.println(" ----------------------------------");
		}
		
		public String LoginVerification(String username,String password) {
			if((username.equals("admin")||username.equals("ADMIN")||username.equals("Admin")) && (password.equals("111"))){
				return "admin";
			} else if ((username.equals("cashier")||username.equals("CASHIER")||username.equals("Cashier")) && (password.equals("000"))) {
				return "cashier";
			} else {
				return "Invalid Login";
			}
		}
		
		public void addItem(String itemName, float itemPrice) {
			items.add(itemName);
			price.add((float) itemPrice);
		}
		
		public void removeItem(int itemId) {
			items.remove(itemId-1);
			price.remove(itemId-1);
		}
		
		public float calculateBill(int itemId, int Qty,int count) {
			float itemPrice = price.get(itemId-1);
			float total = (itemPrice*Qty);
			System.out.println(" ");
			System.out.println((count+1) +") "+ items.get(itemId-1) +" X "+ Qty + " = Rs " + total);
			return total;
		}
		
		public float calcSubTotal(float total, float discount) {
			float subtotal = (total-((total/100)*discount));
			return subtotal;
		}

		public int getListSize() {
			return items.size();
		}
		
		public float calcBalance(float subTotal, float cash) {
			return (cash - subTotal);
		}

}
