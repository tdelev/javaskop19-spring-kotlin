package me.delev.stickers;
/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StickerService {

    private final Logger logger = LoggerFactory.getLogger(StickerService.class);

    private final StickerRepository repository;

    public StickerService(StickerRepository repository) {
        this.repository = repository;
    }

    public Sticker create(String name) {
        Sticker sticker = new Sticker(createId(name), name);
        logger.info("Saving sticker [{}]", sticker);
        return repository.save(sticker);
    }

    public List<Sticker> findAll() {
        return repository.findAll();
    }

    public Optional<Sticker> findById(String id) {
        return repository.findById(id);
    }

    private String createId(String name) {
        return Arrays.stream(name.split("\\s+"))
                .map(String::toLowerCase)
                .filter(it -> it.length() > 0)
                .filter(it -> Character.isAlphabetic(it.charAt(0)))
                .map(it -> String.valueOf(it.charAt(0)))
                .collect(Collectors.joining());
    }
}*/
