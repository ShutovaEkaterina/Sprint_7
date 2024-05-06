package OrderPackage;

import org.apache.commons.lang3.RandomStringUtils;

public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;

    public Order() {
        this.firstName = RandomStringUtils.randomAlphabetic(5, 15);
        this.lastName = RandomStringUtils.randomAlphabetic(5, 15);
        this.address = RandomStringUtils.randomAlphabetic(5, 15);
        this.metroStation = RandomStringUtils.randomAlphabetic(5, 15);
        this.phone = "89122222222";
        this.rentTime = 4;
        this.deliveryDate = "12-05-2024";
        this.comment = RandomStringUtils.randomAlphabetic(5, 15);
    }

    public Order(String[] color) {
        this();
        this.color = color;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public static Order random() {
        return new Order();
    }
}
