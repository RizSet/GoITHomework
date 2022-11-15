package module13.task1;

public class NewObjectToPostMethod {

    int id = 1;
    String name = "Leanner Graham";
    String username = "Bret";
    String email = "Sincere@april.biz";
    Address address = new Address();
    String phone = "1-770-736-8031 x56442";
    String website = "hildegard.org";
    Company company = new Company();






    class Address {
        String street = "Kulas Light";
        String suite = "Apt. 556";
        String city = "Gwenborough";
        String zipcode = "92998-3874";
        Geo geo = new Geo();

        class Geo {
            double lat = -37.3159;
            double lng = 81.1496;
        }
    }

    class Company {
        String name = "Romaguera-Crona";
        String catchPhrase = "Multi-layered client-server neural-net";
        String bs = "harness real-time e-markets";
    }
}

