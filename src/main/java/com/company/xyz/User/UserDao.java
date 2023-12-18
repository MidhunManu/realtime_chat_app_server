package com.company.xyz.User;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addNewUser(String username, String email, String password) {
        try {
            String query = "call chat_app_add_new_user(?,?,?)";

            return this.jdbcTemplate.update(query, username, email, password);
        }
        catch (DataAccessException e) {
            e.printStackTrace();
            return 1;
        }
    }
    public boolean loginUser(String email, String password) {
        String query = "SELECT check_user_exists(?, ?)";
        System.out.println();
        return Boolean.TRUE.equals(this.jdbcTemplate.queryForObject(query, Boolean.class, email, password));
    }

    public List<Map<String, Object>> showUsers() {
        String query = "select username, user_avatar from users";
        return this.jdbcTemplate.queryForList(query);
    }

    public List<Map<String, Object>> showAvatars() {
        String query = "select a_id, avatar_url, avatar_name from avatars";
        return this.jdbcTemplate.queryForList(query);
    }

    public List<Map<String, Object>> getSpecificUserName(String usernameOrEmail) {
        String query = "select chat_app_get_specific_username(?)";
        return this.jdbcTemplate.queryForList(query, usernameOrEmail);
    }

    public int setAvatar(String username, String avatar_url) {
        String query = "call update_user_avatar (?,?);";
        System.out.println(username + " : " + avatar_url);
        return this.jdbcTemplate.update(query, username, avatar_url);
    }

    public List<Map<String, Object>> showSpecificUserDetails(String username) {
        String query = "select username, email, user_avatar from users where username = (?)";
        return this.jdbcTemplate.queryForList(query, username);
    }
}
