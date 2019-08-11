package com.chuangdun;

import com.chuangdun.arcface.autoconfigure.ArcEngineProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author nick
 */
@Log4j2
@SpringBootApplication
public class ArcFaceApplication implements ApplicationRunner {

    @Autowired
    ArcEngineProperties properties;

    public static void main(String[] args) {
        SpringApplication.run(ArcFaceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("启动ArcFaceEngine" + properties);
    }
}
