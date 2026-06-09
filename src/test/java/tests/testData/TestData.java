package tests.testData;

import com.github.javafaker.Faker;
import java.util.Locale;
import static utils.RandomUtils.*;

public class TestData {

    Faker faker = new Faker(new Locale("en"));

    public String userName = faker.name().fullName();
    public String userEmail = faker.internet().emailAddress();
    public String currentAddress = faker.address().fullAddress();
    public String permanentAddress = faker.address().streetAddress();

    public String userFirstName = getRandomString(10);
    public String userLastName = getRandomString(10);
    public String userCorrectEmail = getRandomEmail();
    public String userGender = getRandomGender();
    public String phoneNumber = getRandomPhone();
    public String dayBirth = String.valueOf(getRandomInt(1,28));
    public String monthBirth = getRandomMonth();
    public String yearBirth = String.valueOf(getRandomInt(1900, 2100));
    public String dateOfBirth = String.format("%02d", Integer.parseInt(dayBirth)) + " " +
            monthBirth + "," + yearBirth;
    public String subject = getRandomSubjects();
    public String hobby = getRandomHobbies();
    public String picture = getRandomPicture();
    public String currentAddressField = getRandomString(10);
    public String state = getRandomState();
    public String city = getRandomCity(state);
    public String invalidPhoneNumber = getRandomInvalidPhone();
    public String invalidUserEmail = getRandomString(10);
}
