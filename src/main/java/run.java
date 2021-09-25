import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class run {
	public static RestaurantService restser1;
	
	public static void addrestaurents() {
		 List<Restaurant> restaurants = new ArrayList<>();
		restser1  = new RestaurantService();
		
		
		//restaurant1 
		LocalTime openingtime = LocalTime.parse("10:00:00");
		LocalTime closingtime = LocalTime.parse("20:00:00");
		restser1.addRestaurant("Cafediety", "Kanpur", openingtime, closingtime);
	    
		
		//restaurant2
		 openingtime = LocalTime.parse("22:00:00");
		 closingtime = LocalTime.parse("06:00:00");
		 
		restser1.addRestaurant("Cafeday", "Kanpur", openingtime, closingtime);
		
		
		//restaurant3
		 openingtime = LocalTime.parse("12:00:00");
		 closingtime = LocalTime.parse("21:00:00");
		 
		restser1.addRestaurant("Cafegirja", "Kanpur", openingtime, closingtime);
		
		
		//restaurant4
		 openingtime = LocalTime.parse("11:00:00");
		 closingtime = LocalTime.parse("22:00:00");
		 
		restser1.addRestaurant("Cafegirja", "lucknow", openingtime, closingtime);
		
		restaurants =  restser1.getRestaurants();
		
		for( Restaurant rest : restaurants ){
			
			rest.addToMenu("tea", 10);
			rest.addToMenu("coffee", 10);
			rest.addToMenu("Bagels", 100);
			rest.addToMenu("muffins", 200);
			rest.addToMenu("bunmaska", 10);
			rest.addToMenu("badapaav", 14);
			rest.addToMenu("mishalpaav", 30);
			rest.addToMenu("samoshapav", 25);
			rest.addToMenu("lassi", 70);
			
			rest.displayDetails();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addrestaurents();
		Restaurant rest ;
		/* rest = restser1.findRestaurantByName("Cafeday");
		 if	(rest.isRestaurantOpen()) {
			 System.out.println("restaurant " + rest.getName() + " is open");
		 }
		 else {
			 System.out.println("restaurant " + rest.getName() + " is close");
		 }*/
		 
	
	}

}
