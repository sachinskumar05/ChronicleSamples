package com.sachin.chronicle.sample;

import com.sachin.chronicle.sample.config.AppConfig;
import com.sachin.chronicle.sample.core.CQueueReader;
import com.sachin.chronicle.sample.core.CQueueWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	@Autowired
	private AppConfig appConfig;

	@Autowired
	private CQueueReader cQueueReader;

	@Autowired
	private CQueueWriter cQueueWriter;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		Application application = ctx.getBean(Application.class);
		application.run();
	}

	public void run() {

		cQueueWriter.write("SK");
		cQueueReader.read();

	}

}
