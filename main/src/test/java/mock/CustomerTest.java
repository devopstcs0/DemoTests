package mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

/* annotating to run with MockitoJUnitRunner
*
* here im using mockito to mock and dependency has been added the POM.XML
*
* */


@RunWith(MockitoJUnitRunner.class)
public class CustomerTest {

    Customer customer;

    // Creating a setup the mock for test case using @Before
    @Before
    public void mockSetupForTest() {
        customer =new Customer();

        //Create a list of customer items in an array using Mockito mock
        List<Item> lists =new ArrayList<Item>();
        Item vegetables = Mockito.mock(Item.class);
        Item cheese = Mockito.mock(Item.class);
        Item soda = Mockito.mock(Item.class);

        //and add the these mock items to the arraylist
        lists.add(vegetables);
        lists.add(cheese);
        lists.add(soda);

        // set the ist of of items using setListOfItems method
        customer.setListOfItems(lists);
        // using getName adding mock data for list of items added by the customer
        when(vegetables.getName()).thenReturn("Broccoli");
        when(cheese.getName()).thenReturn("Pepper Jack");
        when(soda.getName()).thenReturn("coca-cola");

        // using getPrice adding mock price for list of items added by the customer
        when(vegetables.getPrice("Broccoli")).thenReturn(7);
        when(cheese.getPrice("Pepper Jack")).thenReturn(10);
        when(soda.getPrice("coca-cola")).thenReturn(2);
    }

    // Testing calculate Bill method using mock data
    @Test
    public void calculateBill() {
        {
            int totalAmount = customer.calculateBill();
            Assert.assertEquals(19, totalAmount);
            // asserting the total amount is equal to the amount from arraylist
        }
    }

    //Testing size of List items added by the customer
    @Test
    public void calculateBilllistSize() {
        {
            int listSize = customer.getListOfItems().size();
            Assert.assertEquals(3, listSize);
            // asserting the size is equal to the size from arraylist
        }
    }
}