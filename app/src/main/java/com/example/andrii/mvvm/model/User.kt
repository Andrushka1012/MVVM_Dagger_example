package com.example.andrii.mvvm.model
import android.os.Parcel
import android.os.Parcelable

data class User constructor(var id:String?) : Parcelable {

    companion object CREATOR : Parcelable.Creator<User> {

        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }

    }

    var login:String? = null
    var avatar_url:String? = null
    var name:String? = null
    var company:String? = null
    var blog:String? = null
    var location:String? = null
    var bio:String? = null
    var followers:Int? = null
    var following:Int? = null
    var updated_at:String? = null

    constructor(parcel: Parcel) : this(parcel.readString()) {
        login = parcel.readString()
        avatar_url = parcel.readString()
        name = parcel.readString()
        company = parcel.readString()
        blog = parcel.readString()
        location = parcel.readString()
        bio = parcel.readString()
        followers = parcel.readValue(Int::class.java.classLoader) as? Int
        following = parcel.readValue(Int::class.java.classLoader) as? Int
        updated_at = parcel.readString()
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(login)
        parcel.writeString(avatar_url)
        parcel.writeString(name)
        parcel.writeString(company)
        parcel.writeString(blog)
        parcel.writeString(location)
        parcel.writeString(bio)
        parcel.writeValue(followers)
        parcel.writeValue(following)
        parcel.writeString(updated_at)
    }

    override fun describeContents(): Int {
        return 0
    }

}
