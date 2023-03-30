package roomreservationconsumer;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import roomreservation.RoomReservationService;
import roomreservation.RoomReservationServiceImpl;

public class Activator implements BundleActivator {
	//Bundle's context.
		private static BundleContext context = null;
		
		//The Service tacker object
		private ServiceTracker m_tracker = null;

		static BundleContext getContext() {
			return context;
		}

		public void start(BundleContext bundleContext) throws Exception {
			Activator.context = bundleContext;
		
		    m_tracker = new ServiceTracker(context, context.createFilter("(&(objectClass="+RoomReservationService.class.getName()+")"+"(Language=*))"),null);   
		    m_tracker.open();
		    System.out.println("Room Consumer Service start successfully");
		    
		    try 
		    {
		    	String Book_Release_Room,username,password,choice,Room_Add_type;
		    	int Booked_Room_No,Add_Room_No,Remove_Room_No;
		    	String Room_type = null;
				int no_of_rooms = 0;
				float Total_Room_Charge;
				 
				
				 ArrayList<Integer> Avaiable_AC_Rooms  = new ArrayList<Integer>();
				 ArrayList<Integer> Avaiable_NON_AC_Rooms  = new ArrayList<Integer>();
				 ArrayList<Integer> Booked_Rooms = new ArrayList<Integer>();
				 
				 
				 Avaiable_AC_Rooms.add(1);
				 Avaiable_AC_Rooms.add(2);
				 Avaiable_AC_Rooms.add(3);
				 Avaiable_AC_Rooms.add(4);
				 Avaiable_AC_Rooms.add(5);
				 
				 
				 Avaiable_NON_AC_Rooms.add(6);
				 Avaiable_NON_AC_Rooms.add(7);
				 Avaiable_NON_AC_Rooms.add(8);
				 Avaiable_NON_AC_Rooms.add(9);
				 Avaiable_NON_AC_Rooms.add(10);
				 
				

				 
				 System.out.println("Available A/C Rooms:"+Avaiable_AC_Rooms);
				 System.out.println("Available NON A/C Rooms:"+Avaiable_NON_AC_Rooms);
				 
				Scanner scan = new Scanner(System.in);
				RoomReservationService roomservice = new RoomReservationServiceImpl();
				
			  while(true)	
			  {		
				  
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
				  
				  
				  
				  
				  
				  
				  System.out.println("====== Login =========================");
				  System.out.print("Enter UserName : ");
				  username = scan.next();
					
					if(username.equals("end")||username.equals("End")||username.equals("END"))
					{
						System.out.println("Ending The service~ ");
						break;
					}
					

					System.out.print("Enter Password : ");
					password = scan.next();
					System.out.println("======================================\n");
					
					choice = roomservice.LoginVerification(username, password);
				  
			    if(choice=="admin"||choice=="Admin"||choice=="ADMIN")
					{
						System.out.println("~~~~~~~~~~~ Welcome Admin ~~~~~~~~~~~");
						System.out.println("Available A/C Rooms:"+Avaiable_AC_Rooms);
						System.out.println("Available NON A/C Rooms:"+Avaiable_NON_AC_Rooms);
				        
						System.out.print("You wont Add Room or Remove Room or logout (add / remove) :");
						choice = scan.next();
						
						if(choice.equals("add")||choice.equals("Add")||choice.equals("ADD"))
						{
							  System.out.print("Enter Room Type(AC,ac or NONAC,nonac):");
					          Room_Add_type = scan.next();
					          
					          System.out.print("Enter Add Room No:");
					          Add_Room_No = scan.nextInt();
					          
					          roomservice.Add_Ac_NonAc_Room(Room_Add_type,Avaiable_AC_Rooms,Avaiable_NON_AC_Rooms,Add_Room_No);
							
						}
						else if(choice.equals("remove")||choice.equals("Remove")||choice.equals("REMOVE"))
						{
							  System.out.print("Enter Room Type(AC,ac or NONAC,nonac):");
					          Room_Add_type = scan.next();
					          
					          System.out.print("Enter Remove Room No:");
					          Remove_Room_No = scan.nextInt();
					          
								
					          roomservice.Remove_Ac_NonAc_Room(Room_Add_type, Avaiable_AC_Rooms, Avaiable_NON_AC_Rooms, Remove_Room_No);
						      
					          System.out.print("\n Removed Successfully!! \n");
						}	
						
						
					}
				  
				  
			    else if(choice=="cashier"||choice=="Cashier"||choice=="CASHIER")
			   {
			    	System.out.println("~~~~~~~~~~~ Welcome Cashier ~~~~~~~~~~~");
			    	
			    	 System.out.println("A/C Room Charge: Rs 2000/=");
					 System.out.println("NON A/C Room Charge: Rs 1500/=");		    	
			    	 
					 System.out.println("Available A/C Rooms:"+Avaiable_AC_Rooms);
					 System.out.println("Available NON A/C Rooms:"+Avaiable_NON_AC_Rooms);
					 
				  	  
				     System.out.print("Enter Room Service Type(BOOK,book or RELEASE,Release):");
			         Book_Release_Room = scan.next();
			         
			         if((Book_Release_Room.equals("BOOK") || Book_Release_Room.equals("book")) )
			         { 
				          System.out.print("Enter Room Type(AC,ac or NONAC,nonac):");
				          Room_type = scan.next();
				
				         System.out.print("Enter No Of Rooms:");
				         no_of_rooms = scan.nextInt();
			         }
				    
				
				 if(Room_type.length() == 0 || Book_Release_Room.length() == 0)
				 {
					 break;
				 }	 
				 else if(roomservice == null)
				 {
					 System.out.println("No Service Available");
				 }		 
				 else if((Book_Release_Room.equals("BOOK") || Book_Release_Room.equals("book")) )
				 {  
					
					 if(Room_type.equals("AC") || Room_type.equals("ac"))
					 { 
						 roomservice.Book_AC_Room(no_of_rooms,Avaiable_AC_Rooms,Avaiable_NON_AC_Rooms,Booked_Rooms);
					 
					 }
					 else if(Room_type.equals("NONAC") || Room_type.equals("nonac"))
					 {
						 roomservice.Book_NON_AC_Room(no_of_rooms,Avaiable_NON_AC_Rooms,Avaiable_AC_Rooms,Booked_Rooms);
					 }
					 else
					 {
						 System.out.println("Room Type is not  Available");
					 }	 
			  
				 }	 
				 else if((Book_Release_Room.equals("RELEASE") || Book_Release_Room.equals("release")))
				 {
					 
						 
						 System.out.print("Enter Release Room No:");
	                     Booked_Room_No = scan.nextInt();
						 
						 roomservice.ReleaseRoom(Booked_Room_No,Avaiable_AC_Rooms,Avaiable_NON_AC_Rooms,Booked_Rooms);
				    
				 }
				 else
				 {
					 System.out.println("Type is not available");
					 
				 }	
				 
				 
			   } 
			    
			 }	 
			}			
		      catch (Exception e)
		      {
				// TODO: handle exception
		    
			   } 
		    
		}

		public void stop(BundleContext bundleContext) throws Exception {
			Activator.context = null;
			System.out.println("Room Consumer Service stop successfully");
		}

}
