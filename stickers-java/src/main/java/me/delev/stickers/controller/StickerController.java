package me.delev.stickers.controller;

import me.delev.stickers.domain.Sticker;
import me.delev.stickers.domain.StickerVote;
import me.delev.stickers.domain.VoteResult;
import me.delev.stickers.service.StickerService;
import me.delev.stickers.utils.IpUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/stickers")
public class StickerController {

    private final StickerService service;

    public StickerController(StickerService service) {
        this.service = service;
    }

    @PostMapping
    public Sticker create(@RequestBody String name) {
        return service.create(name);
    }

    @GetMapping
    public List<Sticker> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sticker> find(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/vote")
    public StickerVote vote(@PathVariable String id, HttpServletRequest request) {
        return service.vote(id, IpUtils.getClientIpAddress(request));
    }

    @GetMapping("/results")
    public List<VoteResult> results() {
        return service.results();
    }
}
