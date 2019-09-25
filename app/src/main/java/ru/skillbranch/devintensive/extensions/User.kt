package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView

fun User.toUserView() : UserView
{
    val nickname = ""
    val initials = ""
    val status = if(lastVisit == null) "Ещё не разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickname,
        initials = initials,
        status = status
    )
}
