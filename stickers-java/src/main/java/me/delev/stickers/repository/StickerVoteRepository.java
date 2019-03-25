package me.delev.stickers.repository;

import me.delev.stickers.domain.StickerVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickerVoteRepository extends JpaRepository<StickerVote, String> {
}
