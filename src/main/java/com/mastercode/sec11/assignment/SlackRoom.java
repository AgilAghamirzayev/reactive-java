package com.mastercode.sec11.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SlackRoom {
    private String name;
    private Sinks.Many<SlackMessage> sink;
    private Flux<SlackMessage> flux;

    public SlackRoom(String name) {
        this.name = name;
        this.sink = Sinks.many().replay().all();
        this.flux = this.sink.asFlux();
    }

    public void joinRoom(SlackMember slackMember) {
        printMessage(slackMember);
        subscribe(slackMember);
        slackMember.setMessageConsumer(message ->
                postMessage(message, slackMember));
    }

    private void printMessage(SlackMember slackMember) {
        System.out.println();
        System.out.println(slackMember.getName() + "----- Joined -----" + this.name);
        System.out.println();
    }

    private void subscribe(SlackMember slackMember) {
        flux
                .filter(slackMessage -> !slackMessage.getSender().equals(slackMember.getName()))
                .doOnNext(slackMessage -> slackMessage.setReceiver(slackMember.getName()))
                .map(SlackMessage::toString)
                .subscribe(slackMember::receives);
    }

    private void postMessage(String message, SlackMember slackMember) {
        SlackMessage slackMessage = SlackMessage.builder()
                .sender(slackMember.getName())
                .message(message)
                .build();

        sink.tryEmitNext(slackMessage);
    }

}
