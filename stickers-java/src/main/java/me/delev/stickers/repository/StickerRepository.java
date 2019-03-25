package me.delev.stickers.repository;

import me.delev.stickers.domain.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickerRepository extends JpaRepository<Sticker, String> {
}
