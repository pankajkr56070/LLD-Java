package HeadFirstDesign.Observer;

public interface EcommerceSystem {

    void registerCustomer(Integer productId, Customer customer);
    void unregisterCustomer(Integer productId, Customer customer);
    void notifyCustomer(Integer productId);
}
