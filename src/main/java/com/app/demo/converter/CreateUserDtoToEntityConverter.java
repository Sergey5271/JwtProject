package com.app.demo.converter;

import com.app.demo.dto.CreateUserDto;
import com.app.demo.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDtoToEntityConverter implements Converter<CreateUserDto, User> {
    @Override
    public User convert(CreateUserDto source) {

        User user = new User();
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setUsername(source.getUsername());
        user.setPassword(source.getPassword());
        return user;
    }
}
