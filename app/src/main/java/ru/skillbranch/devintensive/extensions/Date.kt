package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND):Date
{
    var time = this.time
    time += when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date = Date()): String {

    var difTime : Long = date.time - this.time

    var res = ""

    var back_time = true
    if(difTime < 0)
    {
        res += "через "
        back_time = false
        difTime = -difTime
    }

    res += when(difTime)
    {
        in (0..1* SECOND) -> "только что"
        in (SECOND..45* SECOND) -> "несколько секунд"
        in (45* SECOND..75* SECOND) -> "минуту"
        in (75* SECOND..45* MINUTE) ->
            when((difTime/ MINUTE) % 10 ){
                1L -> "${difTime/ MINUTE} минуту"
                in 2..4 -> "${difTime/ MINUTE} минуты"
                else -> "${difTime/ MINUTE} минут"
            }

        in (45* MINUTE..75* MINUTE) -> "час"
        in (75* MINUTE..22* HOUR) ->
            when((difTime/ HOUR)%10){
                1L -> "${difTime/ HOUR} час"
                in 2..4 -> "${difTime/ HOUR} часа"
                else -> "${difTime/ HOUR} часов"
            }
        in (22* HOUR..26* HOUR) -> "день"
        in (26* HOUR..360* DAY) ->
            when((difTime/ DAY) % 10)
            {
                1L -> "${difTime/ DAY} день"
                in 2..4 -> "${difTime/ DAY} дня"
                else -> "${difTime/ DAY} дней"
            }
        else -> "более года"
    }
    if(back_time) res+=" назад"

    return res
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}