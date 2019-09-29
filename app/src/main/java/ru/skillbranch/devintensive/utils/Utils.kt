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

        /*
        * Реализуй метод Utils.toInitials(firstName lastName) принимающий в качестве аргументов имя и фамилию пользователя
        *  (null, пустую строку) и возвращающий строку с первыми буквами имени и фамилии
        * в верхнем регистре (если один из аргументов null то вернуть один инициал, если оба аргумента null вернуть null)
            Пример:
            Utils.toInitials("john" ,"doe") //JD
            Utils.toInitials("John", null) //J
            Utils.toInitials(null, null) //null
            Utils.toInitials(" ", "") //null
            * */
        /*"null", null, "ckjdj"*/
        var f_name = firstName?.trim()
        var l_name = lastName?.trim()

        var res = StringBuilder()

        if((f_name==null || f_name=="" || f_name=="null") && (l_name==null || l_name=="" || l_name=="null"))
        {
            return null
        }

        if(f_name!=null && f_name!="" && f_name!="null")
        {
            res.append(f_name[0].toString().toUpperCase())
        }

        if(l_name!=null && l_name!="" && l_name!="null")
        {
            res.append(l_name[0].toString().toUpperCase())
        }


        return res.toString()
        /*
        * возврат либо 2 буквы, либо 1 буква, либо ""*/

    }
}