package roomreservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RoomReservationServiceImpl implements RoomReservationService{
	

	 float Total_Rooms_Charge = (float) 0.0;
	 int Release_Room;
	 
	public void   Book_AC_Room(int no_of_rooms,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,ArrayList ReserveRooms) {
		// TODO Auto-generated method stub
		 
		if(no_of_rooms <= Avaiable_AC_Rooms.size())
		{
			for(int i=0;i<no_of_rooms;i++)
			{
			  int j=0;
			  int room = (int) Avaiable_AC_Rooms.remove(j);
			  ReserveRooms.add(room);
			}
			
			Total_Rooms_Charge = no_of_rooms * 2000;
			
		    System.out.println("Total cost of the room:"+Total_Rooms_Charge);
		    System.out.print("\n");
		    Collections.sort(Avaiable_AC_Rooms);
		    Collections.sort(Avaiable_NON_AC_Rooms);
		    System.out.println("Available AC Rooms:"+Avaiable_AC_Rooms);
		    System.out.println("Available NON AC Rooms:"+Avaiable_NON_AC_Rooms);
		    System.out.print("\n");
			
		}
		else
		{
			System.out.println("Sorry!! Number of available AC rooms is fewer than the number of rooms you require. ");
		}	
	
     }
	
	public void   Book_NON_AC_Room(int no_of_rooms,ArrayList Avaiable_NON_AC_Rooms,ArrayList Avaiable_AC_Rooms,ArrayList ReserveRooms) {
		// TODO Auto-generated method stub
		 
		if(no_of_rooms <= Avaiable_NON_AC_Rooms.size())
		{
			for(int i=0;i<no_of_rooms;i++)
			{  
				int j=0;
			    int room = (int) Avaiable_NON_AC_Rooms.remove(j);
			    ReserveRooms.add(room);
			    
			}
			
			Total_Rooms_Charge = no_of_rooms * 1500;
			
		    System.out.println("Total cost of the room:"+Total_Rooms_Charge);
		    System.out.print("\n");
		    
		    System.out.println("Available AC Rooms:"+Avaiable_AC_Rooms);
		    System.out.println("Available NON AC Rooms:"+Avaiable_NON_AC_Rooms);
		    System.out.print("\n");
		}
		else
		{
			System.out.println("Sorry!! Number of available NON AC rooms is fewer than the number of rooms you require. ");
		}	
		
	
     }
	public void  ReleaseRoom(int Booked_Roomno,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,ArrayList Booked_Rooms)
	{
		  for(int i=0;i<Booked_Rooms.size();i++)
		  {
			   if(Booked_Roomno == (int)Booked_Rooms.get(i))
			   {
				   if((int)Booked_Rooms.get(i) <= 5)
				   {
					   Avaiable_AC_Rooms.add((int)Booked_Rooms.get(i));
					   Booked_Rooms.remove(i);
					   Collections.sort(Avaiable_AC_Rooms);
					    Collections.sort(Avaiable_NON_AC_Rooms);
					   System.out.println("AC Rooms Available:"+Avaiable_AC_Rooms);
					   System.out.println("NON AC Available Rooms:"+Avaiable_NON_AC_Rooms);
					   System.out.print("\n");
				   }
				   else if((int)Booked_Rooms.get(i) >=5 && (int)Booked_Rooms.get(i) <=10 )
				   {
					   Avaiable_NON_AC_Rooms.add((int)Booked_Rooms.get(i));
					   Booked_Rooms.remove(i);
					   Collections.sort(Avaiable_AC_Rooms);
					   Collections.sort(Avaiable_NON_AC_Rooms);
					   System.out.println("AC Rooms Available:"+Avaiable_AC_Rooms);
					   System.out.println("NON AC Available Rooms:"+Avaiable_NON_AC_Rooms);
					   System.out.print("\n");
				   }
				   
				   
				   
			   }
			  
			  
		  }
		
			
	}
   
	public String LoginVerification(String username,String password)
	 {
		
	   	if((username.equals("admin")) && (password.equals("567")))
	   	{
				return "admin";
		}
		else if((username.equals("cashier")) && (password.equals("345")))
		{
			return "cashier";
		}else
		{
			return "invalid";
		}
		
		
		
	 }
	public void Add_Ac_NonAc_Room(String RoomType,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,int roomno)
	{
		if(RoomType.equals("AC") || RoomType.equals("ac"))
		{
			Avaiable_AC_Rooms.add(roomno);
			 System.out.println("New  AC Room Added "+roomno);  
	       	  
			
			    Collections.sort(Avaiable_AC_Rooms);
			    Collections.sort(Avaiable_NON_AC_Rooms);
			    System.out.println("Available AC Rooms:"+Avaiable_AC_Rooms);
			    System.out.println("Available NON AC Rooms:"+Avaiable_NON_AC_Rooms);
			
		}
		 else if(RoomType.equals("NONAC") || RoomType.equals("nonac"))
       {
      	   Avaiable_NON_AC_Rooms.add(roomno);
      	   System.out.println("New NON AC Room Added"+roomno);  
      	  
      	    Collections.sort(Avaiable_AC_Rooms);
		    Collections.sort(Avaiable_NON_AC_Rooms);
		    System.out.println("Available AC Rooms:"+Avaiable_AC_Rooms);
		    System.out.println("Available NON AC Rooms:"+Avaiable_NON_AC_Rooms);
       }	 
		
	}
	public void Remove_Ac_NonAc_Room(String RoomType,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,int roomno)
	{
		if(RoomType.equals("AC") || RoomType.equals("ac"))
		{
			for(int i=0;i<Avaiable_AC_Rooms.size();i++)
			{
				if(roomno == (int)Avaiable_AC_Rooms.get(i))
				{
					Avaiable_AC_Rooms.remove(i);
					 System.out.println("Removed the new AC room "+roomno);  
			       	  
				    
				   
					 Collections.sort(Avaiable_AC_Rooms);
				     Collections.sort(Avaiable_NON_AC_Rooms);
				     System.out.println("Available AC Rooms:"+Avaiable_AC_Rooms);
				     System.out.println("Available NON AC Rooms:"+Avaiable_NON_AC_Rooms);
				}
				
			}
		}
		 else if(RoomType.equals("NONAC") || RoomType.equals("nonac"))
       { 
			 for(int i=0;i<Avaiable_NON_AC_Rooms.size();i++)
				{
					if(roomno == (int)Avaiable_NON_AC_Rooms.get(i))
					{
						Avaiable_NON_AC_Rooms.remove(i);
						 System.out.println("Removed the NON AC room "+roomno);  
				       	  
						
						
						Collections.sort(Avaiable_AC_Rooms);
						Collections.sort(Avaiable_NON_AC_Rooms);
						System.out.println("Available AC Rooms:"+Avaiable_AC_Rooms);
						System.out.println("Available NON AC Rooms:"+Avaiable_NON_AC_Rooms);
					}
					
				}
      	  
      	  
       }	
		
	}

}
