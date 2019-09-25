package ru.skillbranchdevintensive.models

import ru.skillbranchdevintensive.utils.Utils
import java.util.*

class User (
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = Date(),
    var isOnline : Boolean = false
){
    constructor( id:String, firstName: String?, lastName: String?) : this(id, firstName, lastName, null)

    constructor(id: String): this(id, "John", "Conor $id")

    init {
        println( if (firstName=="John" && lastName=="Cena")
                    "tu tu ru tuuuu!!!"
                else "A'm Alive")
    }

    fun printMe():Unit{
        println("""
    id: $id
    firstName: $firstName
    lastName: $lastName
    avatar: $avatar
    rating: $rating
    respect: $respect
    lastVisit: $lastVisit
    isOnline: $isOnline
        """.trimIndent())
    }

    companion object Factory{
        private var lastId : Int = -1
        fun makeUser(fullName: String?):User{
            lastId++

            val (f_name, l_name) = Utils.parseFullName(fullName)

            return User(id = "$lastId", firstName = "$f_name", lastName = "$l_name")
        }
    }
}