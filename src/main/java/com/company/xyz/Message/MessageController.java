package com.company.xyz.Message;

import com.company.xyz.Conversation.Conversation;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService, SimpMessagingTemplate simpMessagingTemplate) {
        this.messageService = messageService;

    }



    //public Map<String, Object> getSpecificMessage(Conversation conversation) {

    //}

    @GetMapping("/api/v1/getChat")
    public List<Map<String, Object>> getChatById(Conversation conversation) {
        return this.messageService.getChatByIdService(conversation);
    }
    @GetMapping("/api/v1/default")
    public String index() {
        return "Hello Message";
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")

    public Message sendMessage(@Payload Message message) {
        message.setCurrentTimeStamp(new Date().toInstant());
//        message.setConnectionId(conId);
        System.out.println(message);

//        this.simpMessagingTemplate.convertAndSend("/topic/messages/"+conId, message);
        return message;
    }

    @MessageMapping("/chat/{conversationId}")
    @SendTo("/user/{conversationId}/topic/messages")

    public Message sendPrivateMessage(@DestinationVariable String conversationId, @Payload Message message) {
        message.setCurrentTimeStamp(new Date().toInstant());
        return message;
    }
}
