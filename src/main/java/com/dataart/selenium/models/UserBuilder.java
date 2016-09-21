package com.dataart.selenium.models;

import static com.dataart.selenium.models.User.Role;

public class UserBuilder {
    public static User admin() {
        User user = new User ("admin", "Ivan", "Petrov", Role.USER, "admin");
        return user;
    }

    public static User developer() {
        User developer = new User("admin", "Ivan", "Petrov", Role.DEVELOPER, "admin");
        return developer;
    }


}
