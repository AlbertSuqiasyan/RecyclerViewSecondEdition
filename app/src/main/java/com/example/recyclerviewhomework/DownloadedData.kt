package com.example.recyclerviewhomework

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

// TODO:  Add  moshi anotations
data class DownloadedData(
    val response: Response
)

data class Response(
    @Json(name = "currentPage")
    val currentPage: Int,
    @Json(name = "orderBy")
    val orderBy: String,
    @Json(name = "pageSize")
    val pageSize: Int,
    @Json(name = "pages")
    val pages: Int,
    val results: List<Result>,
    val startIndex: Int,
    val status: String,
    val total: Int,
    val userTier: String
)

@Entity(tableName = "result_table")
data class Result(

    @ColumnInfo(name = "api_url" )
    val apiUrl: String,

    @ColumnInfo(name = "fields" )
    val fields: Fields,

    @PrimaryKey(autoGenerate = true)
    val id: String,

    @ColumnInfo(name = "is_hosted")
    val isHosted: Boolean,

    @ColumnInfo(name = "pillar_id")
    val pillarId: String,

    @ColumnInfo(name = "pillar_name" )
    val pillarName: String,

    @ColumnInfo(name = "section_id")
    val sectionId: String,

    @ColumnInfo(name = "section_name")
    val sectionName: String,

    @ColumnInfo(name = "tags")
    val tags: List<Tag>,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "web_publication_date")
    val webPublicationDate: String,

    @ColumnInfo(name = "web_title")
    val webTitle: String,

    @ColumnInfo(name = "web_url")
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