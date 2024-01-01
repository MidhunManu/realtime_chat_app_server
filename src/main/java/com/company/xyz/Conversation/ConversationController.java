package com.company.xyz.Conversation;

import com.company.xyz.User.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ConversationController {
    private final ConversationService conversationService;
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping("/api/v1/getUserId")
    public int getUserId(@RequestParam String username) {
        return this.conversationService.getUserId(username);
    }

    @GetMapping("/api/v1/getUserIdJson")
    public Map<String , Integer> getUserIdJson(@RequestParam String username) {
        int userId = this.conversationService.getUserId(username);
        Map<String, Integer> map = new HashMap<>();
        map.put("userId", userId);
        return map;
    }

    @GetMapping("/api/v1/getConversationId")
    public Map<String,Object> getConversationId(@RequestParam String user1, @RequestParam String user2) {
        return this.conversationService.getConversationIdService(user1, user2);
    }
}
