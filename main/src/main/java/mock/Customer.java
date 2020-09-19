package mock;
//3.	Write a few unit test cases for the calculateBill method using Mocks.
// You can choose whatever mocking library you are comfortable with. E.g.: Mockito
import java.util.List;

public class Customer {
    String name;
    List<Item> listOfItems;

    public int calculateBill()
    {
        int total = 0;
        for (Item item:listOfItems) {
            total+=item.getPrice(item.getName());
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }
}