package ru.skillbranch.devintensive.extentions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60* SECOND
const val HOUR = 60* MINUTE
const val DAY = 24* HOUR

fun Date.humanizeDiff(currentDate:Date = Date()): String {
 val difference = currentDate.time-this.time
    return when(currentDate.time-this.time){
        in 0          .. 1 * SECOND ->  "только что"
        in 1 * SECOND .. 45* SECOND ->"несколько секунд назад"
        in 45* SECOND .. 75* SECOND -> "минуту назад"
        in 75* SECOND .. 45* MINUTE -> "${difference/ MINUTE} минут назад"
        in 45* MINUTE .. 75* MINUTE -> "час назад"
        in 75* MINUTE .. 22* HOUR   -> "${difference/ HOUR} часов назад"
        in 22* HOUR   .. 26* HOUR   -> "день назад"
        in 26* HOUR   .. 360* DAY   -> "${difference/DAY} дней назад"
        else                        -> "более года назад"
    }
}


fun Date.format(pattern:String="HH:mm:ss dd.MM.yy") : String{
    val dateFormat = SimpleDateFormat(pattern,Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) :Date{
   var time = this.time

    time += when(units){
        TimeUnits.SECOND ->value * SECOND
        TimeUnits.MINUTE ->value * MINUTE
        TimeUnits.HOUR ->value * HOUR
        TimeUnits.DAY ->value * DAY
    }
    this.time = time
    return this
}



enum class TimeUnits{
    SECOND{
        override fun plural(value: Int) = when(value) {
            0 ->"Только что"
            1,in 21..51 step(10)-> "$value секунда"
            in 2..4, in 22..60, in 32..34, in 42..44,in 52..54-> "$value секунды"
            in 5..20,in 25..30,in 35..40, in 45..50,in 55..59 -> "$value секунд"
            else ->"Более минуты"
        }
          },
    MINUTE{
        override fun plural(value: Int) = when(value) {
            0 ->"Меньше минуты"
            1,in 21..51 step(10) -> "$value минута"
            in 2..4, in 22..24, in 32..34, in 42..44,in 52..54-> "$value минуты"
            in 5..20,in 25..30,in 35..40, in 45..50,in 55..59 -> "$value минут"
            else ->"Более часа"
        }
          },
    HOUR{
        override fun plural(value: Int)= when(value) {
            0 -> "Меньше часа"
            1,21 -> "$value час"
            in 2..4, in 22..24 -> "$value часа"
            in 5..20 -> "$value часов"
            else ->"Более дня"
        }
        },
    DAY{
        override fun plural(value: Int)= when(value) {
            0->"Меньше дня"
            1,1,in 21..361 step(10) -> "$value день"
            in 2..4, in 22..24, in 32..34, in 42..44,in 52..54
                ,in 62..64
                ,in 72..74
                ,in 82..84
                ,in 92..94
                ,in 102..104
                ,in 112..114
                ,in 122..124
                ,in 132..134
                ,in 142..144
                ,in 152..154
                ,in 162..164
                ,in 172..174
                ,in 182..184
                ,in 192..194
                ,in 202..204
                ,in 212..214
                ,in 222..224
                ,in 232..234
                ,in 242..244
                ,in 252..254
                ,in 262..264
                ,in 272..274
                ,in 282..284
                ,in 292..294
                ,in 302..304
                ,in 312..314
                ,in 322..324
                ,in 332..334
                ,in 342..344
                ,in 352..354-> "$value дня"
            in 5..20,
            in 25..30,
            in 35..40,
            in 45..50,
            in 55..60
                ,in 65..70
                ,in 75..80
                ,in 85..90
                ,in 95..100
                ,in 105..110
                ,in 115..120
                ,in 125..130
                ,in 135..140
                ,in 145..150
                ,in 155..160
                ,in 165..170
                ,in 175..180
                ,in 185..190
                ,in 195..200
                ,in 205..210
                ,in 215..220
                ,in 225..230
                ,in 235..240
                ,in 245..250
                ,in 255..260
                ,in 265..270
                ,in 275..280
                ,in 280..285
                ,in 295..300
                ,in 305..310
                ,in 315..320
                ,in 325..330
                ,in 335..340
                ,in 345..350,
                 in 355..360
            -> "$value дней"
            else ->"Более года"
        }
    };

    abstract fun plural(value:Int):String
}

