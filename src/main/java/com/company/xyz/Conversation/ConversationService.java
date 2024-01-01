package com.company.xyz.Conversation;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ConversationService {
    private final ConversationDao conversationDao;
    public ConversationService(ConversationDao conversationDao) {
        this.conversationDao = conversationDao;
    }
    public int getUserId(String username) {
        return this.conversationDao.getUserId(username);
    }

    public Map<String, Object> getConversationIdService(String username1, String username2) throws IndexOutOfBoundsException{
        return this.conversationDao.getConversationId(username1, username2).get(0);
    }
}
