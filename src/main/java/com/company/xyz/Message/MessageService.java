package com.company.xyz.Message;

import com.company.xyz.Conversation.Conversation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageService {
    private final MessageDao messageDao;
    public MessageService(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public List<Map<String, Object>> getChatByIdService(Conversation conversation) {
        return this.messageDao.showChat(conversation.getCon_id());
    }

	public ResponseEntity<String> addNewMessageToDb(Message message) {
		int response = this.messageDao.addNewMessageToDb(message.getConnectionId(), message.getSenderId(), message.getMessageContent());
		if(response == 0) {
            return ResponseEntity.status(200).body("added message to db");
		}
		else {
            return ResponseEntity.status(502).body("can't added message to db");
		}
	}
}
