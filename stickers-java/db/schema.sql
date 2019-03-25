CREATE TABLE stickers
(
  id    TEXT PRIMARY KEY,
  title TEXT NOT NULL
);

CREATE TABLE sticker_votes
(
  ip_address TEXT PRIMARY KEY,
  sticker_id TEXT      NOT NULL REFERENCES stickers (id),
  time       TIMESTAMP NOT NULL
);
