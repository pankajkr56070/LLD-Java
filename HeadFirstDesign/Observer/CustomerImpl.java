package HeadFirstDesign.Observer;

public class CustomerImpl implements  Customer{
    private  Integer id;

    CustomerImpl(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;

    }
    @Override
    public void update(Integer productId) {
        System.out.println("Product " + productId + " is in stock");
    }
}
