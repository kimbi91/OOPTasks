package task3_customers;

public class Customer {

    private final int id;
    private String name;
    private String postalCode;
    private String country;
    private String city;

    public Customer(int id) {
        this.id = id;
    }

    public Customer(int id, String name, String postalCode, String country, String city) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.country = country;
        this.city = city;
    }

    public Customer(String line) {
        String[] parts = line.split(",");
        this.id = Integer.parseInt(parts[0]);
        this.name = parts[1];
        this.postalCode = parts[2];
        this.country = parts[3];
        this.city = parts[4];
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
