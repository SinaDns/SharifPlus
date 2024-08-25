import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Order {
    static int id = 10;
    public User user;
    List<Product> productList = new ArrayList<>();

    static HashMap<Integer, String> allOrderIDs = new HashMap<>();


    public Order(User user) {
        this.user = user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProductList() {
        return productList;
    }

}
