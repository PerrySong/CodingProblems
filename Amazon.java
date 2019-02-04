import java.util.Date;
import java.util.List;
import java.util.Map;

public class Amazon {

    class User {
        String firstname;
        String lastname;
        String location;
        String id;
        Cart cart;
    }

    class Cart {
        Map<Merchandise, Integer> merchandises;

    }

    class Merchandise {
        String name;
        String id;
        double price;
        String description;
    }

    class Coupon {
        String merchandiseId;
        double discount;

    }

    class order {
        User user;
        Merchandise merchandise;
        Date date;
    }
}
