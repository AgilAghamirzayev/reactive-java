package com.mastercode.sec11.assignment;

import static com.mastercode.utils.Util.sleep;

public class Slack {
    public static void main(String[] args) {
        SlackRoom java = new SlackRoom("Java");

        SlackMember ali = SlackMember.builder().name("Ali").build();
        SlackMember vali = SlackMember.builder().name("Vali").build();
        SlackMember pirvali = SlackMember.builder().name("Pirvali").build();

        java.joinRoom(ali);
        java.joinRoom(vali);

        ali.says("Hi there ✌️");
        sleep(3);

        vali.says("Hey!");
        ali.says("How are you?");

        sleep(3);

        java.joinRoom(pirvali);
        pirvali.says("Hello i am new there");
    }
}
