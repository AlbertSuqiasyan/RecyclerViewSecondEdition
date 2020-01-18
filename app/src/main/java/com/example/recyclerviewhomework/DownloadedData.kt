package com.example.recyclerviewhomework

import androidx.room.Entity
import androidx.room.PrimaryKey


data class DownloadedData(
    val response: Response
)

data class Response(
    val currentPage: Int,
    val orderBy: String,
    val pageSize: Int,
    val pages: Int,
    val results: List<Result>,
    val startIndex: Int,
    val status: String,
    val total: Int,
    val userTier: String
)

@Entity(tableName = "Result")
data class Result(
    val apiUrl: String,
    val fields: Fields,

    @PrimaryKey(autoGenerate = true)
    val id: String,

    val isHosted: Boolean,
    val pillarId: String,
    val pillarName: String,
    val sectionId: String,
    val sectionName: String,
    val tags: List<Tag>,
    val type: String,
    val webPublicationDate: String,
    val webTitle: String,
    val webUrl: String
)

data class Fields(
    val headline: String,
    val shortUrl: String,
    val starRating: String,
    val thumbnail: String
)

data class Tag(
    val apiUrl: String,
    val bio: String,
    val bylineImageUrl: String,
    val bylineLargeImageUrl: String,
    val firstName: String,
    val id: String,
    val lastName: String,
    val references: List<Any>,
    val twitterHandle: String,
    val type: String,
    val webTitle: String,
    val webUrl: String
)