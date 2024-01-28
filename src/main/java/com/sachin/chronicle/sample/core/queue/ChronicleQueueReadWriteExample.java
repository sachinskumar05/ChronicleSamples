package com.sachin.chronicle.sample.core.queue;

import lombok.extern.log4j.Log4j2;

import net.openhft.chronicle.queue.ExcerptAppender;
import net.openhft.chronicle.queue.ExcerptTailer;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;

@Log4j2
public class ChronicleQueueReadWriteExample {

    public static void main(String[] args) {
        // Writing to Chronicle Queue
        try {
            SingleChronicleQueueBuilder queueBuilder = SingleChronicleQueueBuilder.single(
                    System.getProperty("user.dir")+"/chronicle/queue");
            ExcerptAppender appender = queueBuilder.build().acquireAppender();
            appender.writeText("Hello, Chronicle Queue!");
        } catch (Exception e) {
            log.error("Failed to WRITE ", e);
        }

        // Reading from Chronicle Queue
        try {
            SingleChronicleQueueBuilder queueBuilder = SingleChronicleQueueBuilder.single(
                    System.getProperty("user.dir")+"/chronicle/queue");
            ExcerptTailer tailer = queueBuilder.build().createTailer();
            String message = tailer.readText();
            System.out.println("Read from Chronicle Queue: " + message);
        } catch (Exception e) {
            log.error("Failed to READ ", e);
        }
    }
}
