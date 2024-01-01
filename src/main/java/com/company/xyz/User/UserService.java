package com.company.xyz.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public ResponseEntity<String> addNewUserService(User user) {
        int response = this.userDao.addNewUser(user.getUsername(), user.getEmail(), user.getPassword());
        System.out.println(response);
        if (response == 0) {
            return ResponseEntity.status(200).body("added user");
        }
        else {
            return ResponseEntity.status(406).body("credentials not acceptable");
        }
    }

    public ResponseEntity<String> loginExistingUserService(User  user) {
        boolean response = this.userDao.loginUser(user.getEmail(), user.getPassword());
        if (response) {
            System.out.println("success");
        }
        else {
            System.out.println("wrong credentials");
        }
        if (response) {
            return ResponseEntity.status(200).body("login successful");
        }
        else {

            return ResponseEntity.status(406).body("login failed");
        }
    }

    public List<Map<String, Object>> showUsersService() {
        return this.userDao.showUsers();
    }

    public List<Map<String, Object>> showAvatarService() {
        return this.userDao.showAvatars();
    }

    public ResponseEntity<String> setUserAvatarService(User user) {
        int response = this.userDao.setAvatar(user.getUsername(), user.getAvatar());
        if(response == 0) {
            return ResponseEntity.status(200).body("ok");
        }
        else {
            return ResponseEntity.status(500).body("couldn't set avatar");
        }
    }

    public List<Map<String, Object>> getSpecificUsernameService(String usernameOrEmail) {
        return this.userDao.getSpecificUserName(usernameOrEmail);
    }

    public Map<String, Object> showSpecificUserDetails(String username) {
        return this.userDao.showSpecificUserDetails(username).get(0);
    }

	public Map<String, Object> getAllUserDetailsJsonService(String username) throws IndexOutOfBoundsException {
		return this.userDao.getUserDetailsAllJson(username).get(0);
	}
}
