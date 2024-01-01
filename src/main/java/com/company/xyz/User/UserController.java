package com.company.xyz.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/api/v1/addNewUser")
    public ResponseEntity<String> addNewUser(@RequestBody User user) {
        return this.userService.addNewUserService(user);
    }

    @PostMapping("/api/v1/loginUser")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        return this.userService.loginExistingUserService(user);
    }

    @GetMapping("/api/v1/showUsers")
    public List<Map<String, Object>> showUsers() {
        return this.userService.showUsersService();
    }

    @GetMapping("/api/v1/showAvatars")
    public List<Map<String, Object>> showAvatars() {
        return this.userService.showAvatarService();
    }

    @PostMapping("/api/v1/setAvatar")
    public ResponseEntity<String> setUserAvatar(@RequestBody User user) {
        return this.userService.setUserAvatarService(user);
    }

    @GetMapping("/api/v1/specificUsername")
    public Map<String, Object> getSpecificUsername(@RequestParam String username) throws IndexOutOfBoundsException{
        return this.userService.getSpecificUsernameService(username).get(0);
    }

    @GetMapping("/api/v1/specificUser")
    public Map<String, Object> getSpecificUser(@RequestParam String username) throws IndexOutOfBoundsException {
        return this.userService.showSpecificUserDetails(username);
    }

	@GetMapping("/api/v1/getAllDetails")
	public Map<String,Object> getAllDetails(@RequestParam String username) throws IndexOutOfBoundsException {
		return this.userService.getAllUserDetailsJsonService(username);
	}
}
