package me.delev.stickers

import org.springframework.data.jpa.repository.JpaRepository

interface StickerRepository : JpaRepository<Sticker, String> {
}