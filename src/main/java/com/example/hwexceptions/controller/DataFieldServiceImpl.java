package com.example.hwexceptions.controller;

import com.example.hwexceptions.controller.exceptions.WrongLoginException;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.W;

@Service
public class DataFieldServiceImpl implements DataFieldService {
    @Override
    public boolean field(String login, String password, String confirmPassword) throws RuntimeException {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин должен быть не больше 20 символов");
        }
        if (!login.matches("\\w{1,20}")) {
            throw new WrongLoginException("Логин может содержать только латинские буквы, цифры и знак подчеркивания");
        }
        if (password.length() > 19) {
            throw new WrongPasswordException("Пароль должен быть меньше 20 символов");
        }
        if (!password.matches("\\w{1,19}")) {
            throw new WrongPasswordException("Пароль может содержать только латинские буквы, цифры и знак подчеркивания");
        }
        if (!Objects.equals(password, confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        return true;
    }
}
