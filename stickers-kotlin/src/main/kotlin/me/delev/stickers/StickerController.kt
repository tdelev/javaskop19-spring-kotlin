package me.delev.stickers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/stickers")
class StickerController(val service: StickerService) {

    @GetMapping
    fun getAll(): List<Sticker> {
        return service.findAll()
    }

    @PostMapping
    fun create(@RequestBody title: String): Sticker {
        return service.create(title)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): ResponseEntity<Sticker> {
        return service.findById(id)
                .map { ResponseEntity.ok(it) }
                .orElseGet { ResponseEntity.notFound().build() }
    }
}