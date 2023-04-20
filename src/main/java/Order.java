import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Data
public class Order {

    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private Date deliveryDate;
    private String comment;
    private List<String> color;

    static Faker faker = new Faker();

    public static Order getRandom(List<String> selectColor) {
        final String firstName = faker.name().firstName();
        final String lastName = faker.name().lastName();
        final String address = faker.address().fullAddress();
        final String metroStation = faker.address().streetName();
        final String phone = faker.phoneNumber().phoneNumber();
        final int rentTime = faker.number().numberBetween(1,7);
        final Date deliveryDate = faker.date().future(7, TimeUnit.DAYS);
        final String comment = faker.lorem().sentence(5);
        final List<String> color = selectColor;

        return new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }
}