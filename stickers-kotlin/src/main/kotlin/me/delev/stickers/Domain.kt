package me.delev.stickers

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "stickers")
data class Sticker(
        @Id
        val id: String,

        val title: String
)