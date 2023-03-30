package roomreservation;


import java.util.ArrayList;
import java.util.HashMap;

public interface RoomReservationService {

	public void Book_AC_Room(int no_of_rooms,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,ArrayList Booked_Rooms);
	public void Book_NON_AC_Room(int no_of_rooms,ArrayList Avaiable_NON_AC_Rooms,ArrayList Avaiable_AC_Rooms,ArrayList Booked_Rooms);
	public void ReleaseRoom(int Booked_Roomno,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,ArrayList Booked_Rooms);
	public String LoginVerification(String username,String password);
	public void Add_Ac_NonAc_Room(String RoomType,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,int roomno);
	public void Remove_Ac_NonAc_Room(String RoomType,ArrayList Avaiable_AC_Rooms,ArrayList Avaiable_NON_AC_Rooms,int roomno);
}
