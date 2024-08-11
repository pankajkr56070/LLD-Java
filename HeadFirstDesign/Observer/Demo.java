package HeadFirstDesign.Observer;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        /*
        E-commerce system has different products. And each product is added in customer watchlist
        Customer can be notified through email and sms if the product is in stock

        //P1 : C1, C2, C3
        //P2 : C2, C4
        //P3 : C3, C5

        //Subject :  Product
        //Observer : CustomerList<id>  : [email, sms]

         */

        EcommerceSystemImpl system = new EcommerceSystemImpl();
        List<Customer> customers = new ArrayList<>();

        for(int i = 1 ; i<= 10; i++) {
            customers.add(new CustomerImpl(i));
        }

        system.registerCustomer(1, customers.get(0));
        system.registerCustomer(1, customers.get(1));
        system.registerCustomer(1, customers.get(2));


        system.registerCustomer(2, customers.get(1));
        system.registerCustomer(2, customers.get(3));
        system.registerCustomer(2, customers.get(2));
        system.registerCustomer(2, customers.get(4));

        //now product is in stock
        system.notifyCustomer(1);
        system.notifyCustomer(2);
        system.notifyCustomer(3);

        system.unregisterCustomer(1, customers.get(0));

        system.notifyCustomer(1);
        system.notifyCustomer(2);
        system.notifyCustomer(3);

    }
}
