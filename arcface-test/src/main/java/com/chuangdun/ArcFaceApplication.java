package com.chuangdun;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Nick
 */
@Log4j2
@SpringBootApplication
public class ArcFaceApplication implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(ArcFaceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ArcFaceApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) {
        logger.debug("启动ArcFaceEngine");
    }
}
