package com.haoyudu.roomcrud.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity

@Entity
data class Student(var name: String?, var classmate: String?, var age:Int) : Parcelable {

    var id:Int=0

    constructor():this("user","null",0)

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
        id = parcel.readInt()
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }

}