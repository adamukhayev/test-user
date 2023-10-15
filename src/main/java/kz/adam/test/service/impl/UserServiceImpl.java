package kz.adam.test.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.adam.test.domain.UserEntity;
import kz.adam.test.modal.UserDto;
import kz.adam.test.repository.UserRepository;
import kz.adam.test.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Override
    public UserDto saveUser(UserDto userDto) {

        return objectMapper.convertValue(
                userRepository.save(objectMapper.convertValue(userDto, UserEntity.class)),
                UserDto.class);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return objectMapper.convertValue(userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Not found")),
                UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(e -> objectMapper.convertValue(e, UserDto.class))
                .collect(Collectors.toList());
    }
}
