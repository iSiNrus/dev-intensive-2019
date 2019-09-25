package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?): Pair<String?, String?>{
        val parts : List<String>? = fullName?.split(" ")
        var f_name = parts?.getOrNull(0)
        var l_name = parts?.getOrNull(1)
        if(f_name=="") f_name=null
        if(l_name=="") l_name=null
        return Pair(f_name, l_name)
    }
}