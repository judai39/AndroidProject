package com.haoyudu.gallerytest

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Pixbay(val totalHits:Int,val hits:Array<PhotoItem>,val total:Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Pixbay

        if (totalHits != other.totalHits) return false
        if (!hits.contentEquals(other.hits)) return false
        if (total != other.total) return false

        return true
    }

    override fun hashCode(): Int {
        var result = totalHits
        result = 31 * result + hits.contentHashCode()
        result = 31 * result + total
        return result
    }

}

@Parcelize
data class PhotoItem(
    @SerializedName("webformatURL") val previewUrl:String,
    @SerializedName("id")var id:Int,
    @SerializedName("largeImageURL")var imageUrl:String
    ):Parcelable