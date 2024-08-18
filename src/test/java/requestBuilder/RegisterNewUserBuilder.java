package requestBuilder;

import com.github.javafaker.Faker;
import requests.RegisterUser;

public class RegisterNewUserBuilder {
    Faker faker = new Faker();

    public RegisterUser createNewUserforRegister(){
        return RegisterUser
                .builder()
                .email(faker.name().username()+"@gmail.com")
                .password(faker.superhero().name()).build();

    }

    public RegisterUser createPartialNewUserRegisteration(){
        return RegisterUser.builder()
                .email(faker.name().username()+"@reqres.in")
                .build();
    }
}
