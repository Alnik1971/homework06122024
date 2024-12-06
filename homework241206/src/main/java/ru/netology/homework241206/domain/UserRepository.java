package ru.netology.homework241206.domain;

import ru.netology.homework241206.enums.Authorities;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserRepository {
    private final String userLogin;
    private final String userPassword;

    public UserRepository() {
        this.userLogin = "admin";
        this.userPassword = "admin";
    }
    public List<Authorities> getUserAuthorities(String user, String password) {
        if (Objects.equals(this.userLogin, user) && Objects.equals(this.userPassword, password)) {
            return Arrays.asList(Authorities.values());
        }
        else {
            return List.of();
        }
    }
}
