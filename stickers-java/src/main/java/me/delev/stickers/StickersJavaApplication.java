package me.delev.stickers;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;

@SpringBootApplication
public class StickersJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StickersJavaApplication.class, args);
    }

}

@Component
class StickerInitializer implements ApplicationRunner {

    private final StickerService service;

    StickerInitializer(StickerService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        File file = new ClassPathResource("stickers.txt").getFile();
        String stickersText = new String(Files.readAllBytes(file.toPath()));
        Arrays.stream(stickersText.split(System.lineSeparator()))
                .forEach(service::create);
    }
}
