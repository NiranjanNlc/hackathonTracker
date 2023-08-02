package org.nlc.hsackathontracker.modal

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MyCustomConverter {


    var gson: Gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<String> {
        if (data == null) {
            return emptyList<String>()
        }
        val listType: Type = object : TypeToken<List<String?>?>() {}.getType()
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someListToString(someObjects: List<String?>?): String {
        return gson.toJson(someObjects)
    }

}
