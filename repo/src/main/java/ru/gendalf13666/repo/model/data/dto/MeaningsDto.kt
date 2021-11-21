package ru.gendalf13666.repo.model.data.dto

import com.google.gson.annotations.SerializedName

class MeaningsDto(
    @field:SerializedName("translation") val translation: TranslationDto?,
    @field:SerializedName("imageUrl") val imageUrl: String?
)