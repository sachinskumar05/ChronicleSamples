package com.sachin.chronicle.sample.core;

import net.openhft.chronicle.ExcerptAppender;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class CQueueWriter extends CQueue {

    ExcerptAppender appender;

    @PostConstruct
    @Override
    public void init() throws IOException {
        super.init();
        appender = chronicle.createAppender();
        appender.startExcerpt();
    }

    public void write(String value) {
        appender.writeUTF(value);
        appender.finish();
    }

    public void write(CharSequence charSequence) {
        String stringVal = charSequence.toString();
        write(stringVal);
    }

}
