package com.sachin.chronicle.sample.core;

import lombok.extern.log4j.Log4j2;
import net.openhft.chronicle.ExcerptTailer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
@Log4j2
public class CQueueReader extends CQueue {

    ExcerptTailer tailer;

    @PostConstruct
    @Override
    public void init() throws IOException {
        super.init();
        tailer = chronicle.createTailer();
    }

    public void read() {
        while (tailer.nextIndex()) {
            log.info(" tailer = " + tailer.readUTF());
        }
        tailer.finish();
    }

}
