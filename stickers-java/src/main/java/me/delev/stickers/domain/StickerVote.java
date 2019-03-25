package me.delev.stickers.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "sticker_votes")
public class StickerVote {

    @Id
    @Column(name = "ip_address")
    private String ipAddress;

    @ManyToOne
    @JoinColumn(name = "sticker_id")
    private Sticker sticker;

    private LocalDateTime time;

    public StickerVote() {
    }

    public StickerVote(String ipAddress, Sticker sticker, LocalDateTime time) {
        this.ipAddress = ipAddress;
        this.sticker = sticker;
        this.time = time;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public void setSticker(Sticker sticker) {
        this.sticker = sticker;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StickerVote that = (StickerVote) o;
        return Objects.equals(ipAddress, that.ipAddress) &&
                Objects.equals(sticker, that.sticker) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress, sticker, time);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StickerVote.class.getSimpleName() + "[", "]")
                .add("ipAddress='" + ipAddress + "'")
                .add("sticker=" + sticker)
                .add("time=" + time)
                .toString();
    }
}
