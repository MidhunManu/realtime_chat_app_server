package com.company.xyz.Conversation;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ConversationDao {
    private final JdbcTemplate jdbcTemplate;

    public ConversationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    int hiddenUserIdGetter(String username) throws EmptyResultDataAccessException {
        String query = "select u_id from users where username = (?)";
        Object obj = this.jdbcTemplate.queryForList(query, username).get(0).get("u_id");
        if(obj != null) {
            return Integer.parseInt(obj.toString());
        }
        else {
            return -1;
        }
    }
    public int getUserId(String username) {
        return this.hiddenUserIdGetter(username);
    }

    int createNewConversation(String userName1, String userName2) {
        String query = "call new_conversation (?, ?)";
        int userId1 = hiddenUserIdGetter(userName1);
        int userId2 = hiddenUserIdGetter(userName2);

        return this.jdbcTemplate.update(query, userId1, userId2);
    }

    public List<Map<String, Object>> getConversationId (String participant1UserName, String participant2UserName) {
        String query = "select get_conversation_by_id(?, ?)";
        int participant1Id = hiddenUserIdGetter(participant1UserName);
        int participant2Id = hiddenUserIdGetter((participant2UserName));

        List<Map<String, Object>> resList = this.jdbcTemplate.queryForList(query, participant1Id, participant2Id);
        if(resList.get(0).get("get_conversation_by_id") == null) {
            int x = createNewConversation(participant1UserName, participant2UserName);
            System.out.println("output => => =>  " + x);
            return this.jdbcTemplate.queryForList(query, hiddenUserIdGetter(participant1UserName), hiddenUserIdGetter(participant2UserName));
        }
        else {
            System.out.println(resList.get(0).get("get_conversation_by_id"));
            return resList;
        }
    }
}