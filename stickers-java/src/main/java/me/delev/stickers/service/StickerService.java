package me.delev.stickers.service;

import me.delev.stickers.domain.Sticker;
import me.delev.stickers.domain.StickerVote;
import me.delev.stickers.domain.VoteResult;
import me.delev.stickers.repository.StickerRepository;
import me.delev.stickers.repository.StickerVoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

@Service
public class StickerService {

    private final Logger logger = LoggerFactory.getLogger(StickerService.class);

    private final StickerRepository repository;
    private final StickerVoteRepository voteRepository;

    public StickerService(StickerRepository repository, StickerVoteRepository voteRepository) {
        this.repository = repository;
        this.voteRepository = voteRepository;
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

    public List<VoteResult> results() {
        List<StickerVote> votes = voteRepository.findAll();
        return votes.stream()
                .collect(Collectors.groupingBy(StickerVote::getSticker, counting()))
                .entrySet().stream()
                .map(it -> new VoteResult(it.getKey().getId(), it.getKey().getTitle(), it.getValue()))
                .sorted(Comparator.<VoteResult, Long>comparing(it -> it.votes).reversed())
                .collect(Collectors.toList());
    }

    public StickerVote vote(String stickerId, String ipAddress) {
        Sticker sticker = findById(stickerId).orElseThrow(() -> new RuntimeException("Sticker not found"));
        StickerVote vote = new StickerVote(ipAddress, sticker, LocalDateTime.now());
        logger.info("Saving vote [{}]", vote);
        return voteRepository.save(vote);
    }

    private String createId(String name) {
        return Arrays.stream(name.split("\\s+"))
                .map(String::toLowerCase)
                .filter(it -> Pattern.matches("\\w+", it))
                .filter(it -> it.length() > 0)
                .map(it -> String.valueOf(it.charAt(0)))
                .collect(Collectors.joining());
    }
}
