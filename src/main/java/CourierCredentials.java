import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierCredentials {

    public String login;
    public String password;

    public CourierCredentials setLogin(String login) {
        this.login = login;
        return this;
    }

    public CourierCredentials setPassword(String password) {
        this.password = password;
        return this;
    }

    public static CourierCredentials from(Courier courier) {
        return new CourierCredentials(courier.login, courier.password);
    }

    public static CourierCredentials courierLoginWithoutLogin(Courier courier) {
        return new CourierCredentials().setPassword(courier.password);
    }

    public static CourierCredentials courierLoginWithoutPassword(Courier courier) {
        return new CourierCredentials().setLogin(courier.login);
    }

    public static CourierCredentials courierLoginWithWrongLogin(Courier courier) {
        return new CourierCredentials().setLogin(RandomStringUtils.randomAlphabetic(10)).setPassword(courier.password);
    }

    public static CourierCredentials courierLoginWithWrongPassword(Courier courier) {
        return new CourierCredentials().setLogin(courier.login).setPassword(RandomStringUtils.randomAlphabetic(10));
    }

    public static CourierCredentials courierLoginWithWrongLoginPassword(Courier courier) {
        return new CourierCredentials().setLogin(RandomStringUtils.randomAlphabetic(10)).setPassword(RandomStringUtils.randomAlphabetic(10));
    }
}