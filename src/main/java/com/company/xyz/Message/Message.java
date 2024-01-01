package com.company.xyz.Message;

import java.time.Instant;

public class Message {
    private int messageId;
    private int connectionId;
    private int senderId;
    private String messageContent;
    private Instant currentTimeStamp;

    public Message(int connectionId, int senderId, String messageContent, Instant currentTimeStamp) {
        this.connectionId = connectionId;
        this.senderId = senderId;
        this.messageContent = messageContent;
        this.currentTimeStamp = currentTimeStamp;
    }

    public Message(int messageId, int connectionId, int senderId, String messageContent, Instant currentTimeStamp) {
        this.messageId = messageId;
        this.connectionId = connectionId;
        this.senderId = senderId;
        this.messageContent = messageContent;
        this.currentTimeStamp = currentTimeStamp;
    }

    public Message() {
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Instant getCurrentTimeStamp() {
        return currentTimeStamp;
    }

    public void setCurrentTimeStamp(Instant currentTimeStamp) {
        this.currentTimeStamp = currentTimeStamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", connectionId=" + connectionId +
                ", senderId=" + senderId +
                ", messageContent='" + messageContent + '\'' +
                ", currentTimeStamp=" + currentTimeStamp +
                '}';
    }
}
