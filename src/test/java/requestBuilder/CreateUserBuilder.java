package requestBuilder;

import com.github.javafaker.Faker;
import requests.CreateUser;

public class CreateUserBuilder {

    Faker faker = new Faker();
    public CreateUser createUser(){

        return CreateUser.builder()
                .name(faker.name().fullName())
                .job("Astronaut")
                .build();
    }

    public CreateUser createPartialUser(){
        return CreateUser.builder()
                .name(faker.name().fullName())
                .build();

    }
}
