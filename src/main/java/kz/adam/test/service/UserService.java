package kz.adam.test.service;

import kz.adam.test.modal.UserDto;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

    UserDto saveUser(@Valid UserDto userDto);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUser();
}
