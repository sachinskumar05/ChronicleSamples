package com.sachin.chronicle.sample.core;

import com.sachin.chronicle.sample.config.ChronicleConfig;
import lombok.extern.log4j.Log4j2;
import net.openhft.chronicle.Chronicle;
import net.openhft.chronicle.ChronicleQueueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@Log4j2
public class CQueue {
    @Autowired
    protected ChronicleConfig chronicleConfig;
    protected Chronicle chronicle ;

    public void init() throws IOException {
        log.info(" chronicleConfig = " + chronicleConfig.getDir());
        Path filePath = Paths.get(chronicleConfig.getDir());
        File queueDir ;
        if(!Files.isReadable(filePath)) {
            queueDir = Files.createDirectory(Paths.get(chronicleConfig.getDir())).toFile();
        } else {
            queueDir = filePath.toFile();
        }
        if(chronicle == null) {
            chronicle = ChronicleQueueBuilder.indexed(queueDir).build();
        }

    }

}
