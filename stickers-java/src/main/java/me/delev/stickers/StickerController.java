package me.delev.stickers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
