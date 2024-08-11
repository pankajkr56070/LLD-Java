package HeadFirstDesign.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EcommerceSystemImpl implements  EcommerceSystem {

    private HashMap<Integer, List<Customer>> productCustomerListMap = new HashMap<>();

    @Override
    public void registerCustomer(Integer productId, Customer customer) {
        if(!productCustomerListMap.containsKey(productId)) {
            productCustomerListMap.put(productId, new ArrayList<>());
        }
        productCustomerListMap.get(productId).add(customer);
    }

    @Override
    public void unregisterCustomer(Integer productId, Customer customer) {
        productCustomerListMap.get(productId).remove(customer);
    }

    @Override
    public void notifyCustomer(Integer productId) {
        if(!productCustomerListMap.containsKey(productId)) {
            System.out.println("Product " + productId + " does not exist");
            return;
        }
        List<Customer> customerList = productCustomerListMap.get(productId);
        for(Customer c : customerList) {
            c.update(productId);
        }
    }


}
