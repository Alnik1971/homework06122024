package ru.netology.homework241206.domain;

import ru.netology.homework241206.enums.Authorities;

import java.util.List;

public interface IUserRepository {
    public List<Authorities> getUserAuthorities(String user, String password);
}
