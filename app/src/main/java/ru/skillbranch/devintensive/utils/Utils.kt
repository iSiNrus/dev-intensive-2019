package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder

object Utils {
    fun parseFullName(fullName:String?): Pair<String?, String?>{
        val parts : List<String>? = fullName?.split(" ")
        var f_name = parts?.getOrNull(0)
        var l_name = parts?.getOrNull(1)
        if(f_name=="") f_name=null
        if(l_name=="") l_name=null
        return Pair(f_name, l_name)
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val translit : StringBuilder = StringBuilder()
        for (literal in payload.toCharArray())
        {
            var lower : Boolean = literal.isLowerCase()

            var lit = literal.toLowerCase()

            var res = when(lit)
            {
                ' '-> divider
                'а'-> "a"
                'б'-> "b"
                'в'-> "v"
                'г'-> "g"
                'д'-> "d"
                'е'-> "e"
                'ё'-> "e"
                'ж'-> "zh"
                'з'-> "z"
                'и'-> "i"
                'й'-> "i"
                'к'-> "k"
                'л'-> "l"
                'м'-> "m"
                'н'-> "n"
                'о'-> "o"
                'п'-> "p"
                'р'-> "r"
                'с'-> "s"
                'т'-> "t"
                'у'-> "u"
                'ф'-> "f"
                'х'-> "h"
                'ц'-> "c"
                'ч'-> "ch"
                'ш'-> "sh"
                'щ'-> "sh'"
                'ъ'-> ""
                'ы'-> "i"
                'ь'-> ""
                'э'-> "e"
                'ю'-> "yu"
                'я'-> "ya"
                else -> literal.toString()
            }
            if (!lower) res = res.toUpperCase()
            translit.append(res)
        }
        return translit.toString()
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        var f_lit = ""
        var l_lit = ""

        if(firstName!="null" && firstName!=null) f_lit = firstName.get(0).toString()
        if(lastName!="null" && lastName!=null) l_lit = lastName.get(0).toString()
        if (f_lit=="" && l_lit=="") return null
        return (f_lit+l_lit).toUpperCase()

    }
}