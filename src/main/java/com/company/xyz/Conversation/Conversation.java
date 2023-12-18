package com.company.xyz.Conversation;

public class Conversation {
    private int con_id;
    private int participant1_id;
    private int participant2_id;

    public Conversation(int con_id, int participant1_id, int participant2_id) {
        this.con_id = con_id;
        this.participant1_id = participant1_id;
        this.participant2_id = participant2_id;
    }

    public Conversation(int participant1_id, int participant2_id) {
        this.participant1_id = participant1_id;
        this.participant2_id = participant2_id;
    }

    public Conversation() {
    }

    public int getCon_id() {
        return con_id;
    }

    public void setCon_id(int con_id) {
        this.con_id = con_id;
    }

    public int getParticipant1_id() {
        return participant1_id;
    }

    public void setParticipant1_id(int participant1_id) {
        this.participant1_id = participant1_id;
    }

    public int getParticipant2_id() {
        return participant2_id;
    }

    public void setParticipant2_id(int participant2_id) {
        this.participant2_id = participant2_id;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "con_id=" + con_id +
                ", participant1_id=" + participant1_id +
                ", participant2_id=" + participant2_id +
                '}';
    }
}
