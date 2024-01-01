package com.company.xyz.Message;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MessageDao {
    private final JdbcTemplate jdbcTemplate;
    public MessageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int sendNewMessage(int connId, int senderId, String message) {
        String query = "";
        return 1;
    }

	public int addNewMessageToDb(int connId, int senderId, String message) {
		String query = "insert into messages (con_id , sender_id, message_content) values (?, ?, ?);";
		return this.jdbcTemplate.update(query, connId, senderId, message);
	}

    public List<Map<String, Object>> showChat(int conversationId) {
        try {
            String query = "select message_content, sender_id, timestp from messages where con_id = (?)";
            return this.jdbcTemplate.queryForList(query, conversationId);
        }
        catch (Exception e) {
            e.printStackTrace();;
        }
        return null;
    }
}
