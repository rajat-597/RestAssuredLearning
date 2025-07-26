package practice07;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {

    @Test
    public void testGenerateRandomData(){
        Faker faker = new Faker();

        String firstname =  faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = faker.name().fullName();
        String userName = faker.name().username();

        String email =  faker.internet().emailAddress();
        String password =  faker.internet().password();
        String phoneNo = faker.phoneNumber().cellPhone();

        System.out.println("FirstName : " + firstname);
        System.out.println("LastName : " + lastName);
        System.out.println("FullName : " + fullName);
        System.out.println("UserName : " + userName);
        System.out.println("Email : " + email);
        System.out.println("Password : " + password);
        System.out.println("phoneNumber : " + phoneNo);
    }
}
