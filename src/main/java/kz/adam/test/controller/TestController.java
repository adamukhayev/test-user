package kz.adam.test.controller;

import kz.adam.test.modal.UserDto;
import kz.adam.test.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final UserService userService;

    @GetMapping("/{user_id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("user_id") @NotBlank Integer userId) {
        log.info("User id: {}", userId);

        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping
    public  ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.ok(userService.saveUser(userDto));
    }
}
