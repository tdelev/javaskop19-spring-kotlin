package me.delev.stickers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

inline fun <reified T> loggerFor(): Logger = LoggerFactory.getLogger(T::class.java)

@Service
class StickerService(val repository: StickerRepository) {

    val logger = loggerFor<StickerService>()

    fun create(title: String): Sticker {
        val sticker = Sticker(title.id(), title)
        logger.info("Saving sticker [{}]", sticker)
        return repository.save(sticker)
    }

    fun findById(id: String): Optional<Sticker> {
        return repository.findById(id)
    }

    fun findAll() = repository.findAll()

    fun String.id() = this.split("\\s+".toRegex())
            .asSequence()
            .filter { it.isNotBlank() }
            .map { it[0].toLowerCase() }
            .filter { Character.isAlphabetic(it.toInt()) }
            .map { it.toString() }
            .joinToString("")
}