
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RestaurantTest {

    
    
    //REFACTOR ALL THE REPEATED LINES OF CODE
   static LocalTime openingTime; 
   static LocalTime closingTime;
   static List<Item> menu ;
   static Restaurant restaurant ;
   Restaurant restaurant1;
 

  
   @BeforeAll
   public static void setup()
   {
	   openingTime = LocalTime.parse("10:30:00");
	   closingTime = LocalTime.parse("22:00:00");
	   restaurant = new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
	   restaurant.addToMenu("Sweet corn soup",119);
       restaurant.addToMenu("Vegetable lasagne", 269);
       restaurant.addToMenu("vadapaav", 269);
       restaurant.addToMenu("samose", 269);
       menu = new ArrayList<Item>();
   }
   
   public void restaurantCreation(){
       LocalTime openingTime = LocalTime.parse("10:30:00");
       LocalTime closingTime = LocalTime.parse("22:00:00");
       restaurant1 = new Restaurant("Amma cafe","Chennai",openingTime,closingTime);
       restaurant1.addToMenu("Sweet corn soup",119);
       restaurant1.addToMenu("Vegetable lasagne", 269);
   }
 
    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERe       
    
    	restaurant.setClosingTime( LocalTime.now().plusMinutes(1));
    	 assertTrue(restaurant.isRestaurantOpen());
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE  
    	// I tried using mocking but was getting error
    
    	restaurant.setClosingTime( LocalTime.now().minusMinutes(1));
      
        assertFalse(restaurant.isRestaurantOpen());
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Test
    public void order_value_should_reduce_total_when_an_item_removed(){

        menu = restaurant.getMenu();
        int total = restaurant.getOrderValue(menu);
        int afterTotal = menu.get(1).getPrice();
        menu.remove(1);
        assertEquals(total-afterTotal,restaurant.getOrderValue(menu));
    }
    
    
    @Test
    public void order_value_should_get_total_when_collection_of_items_selected(){
    	restaurantCreation();
        menu = restaurant1.getMenu();
        assertEquals(388,restaurant1.getOrderValue(menu));
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        
      

        int initialMenuSize = restaurant.getMenu().size();
        //adding item to menu
        restaurant.addToMenu("Sizzling brownie",319);
        
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {


        int initialMenuSize = restaurant.getMenu().size();
        //remove item from menu
        restaurant.removeFromMenu("vadapaav");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {



        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}