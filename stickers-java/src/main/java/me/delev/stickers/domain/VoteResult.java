package me.delev.stickers.domain;

public class VoteResult {
    public String id;
    public String name;
    public Long votes;

    public VoteResult(String id, String name, Long votes) {
        this.id = id;
        this.name = name;
        this.votes = votes;
    }
}
