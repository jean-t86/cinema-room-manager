package cinema

import kotlin.math.floor

class Theatre {

    fun totalPriceSoldOut(rows: Int, seats: Int): Int {
        val isLargeRoom = rows * seats > LARGE_ROOM_MIN_SEATS
        return if (isLargeRoom) {
            val frontHalf = floor(rows / 2.0).toInt()
            val backHalf = rows - frontHalf

            ((frontHalf * seats) * TICKET_PRICE_10) + ((backHalf * seats) * TICKET_PRICE_8)
        } else {
            (rows * seats) * TICKET_PRICE_10
        }
    }

    fun ticketPrice(rows: Int, seats: Int, rowNumber: Int): Int {
        val isLargeRoom = rows * seats > LARGE_ROOM_MIN_SEATS
        return if (isLargeRoom) {
            val frontHalf = floor(rows / 2.0).toInt()
            if (rowNumber <= frontHalf) {
                TICKET_PRICE_10
            } else {
                TICKET_PRICE_8
            }
        } else {
            TICKET_PRICE_10
        }
    }

    private val reservations: MutableList<Pair<Int, Int>> = mutableListOf()
    fun reserveSeat(rowNumber: Int, seatInRow: Int) =
        reservations.add(Pair(rowNumber, seatInRow))

    fun cinemaScheme(rows: Int, seats: Int): String {
        val strBuilder: StringBuilder = StringBuilder()
        strBuilder.append(CINEMA)
        for (i in 0..rows) {
            if (i == 0) {
                strBuilder.appendLine()
                strBuilder.append(" ")
            } else {
                strBuilder.appendLine()
                strBuilder.append(i)
            }
            for (j in 0..seats) {
                if (j == 0) {
                    strBuilder.append(" ")
                } else if (i == 0) {
                    strBuilder.append("$j ")
                } else if (reservations.any { (row, seat) ->
                        row == i && seat == j
                    }) {
                    strBuilder.append("$RESERVED_SEAT ")
                } else {
                    strBuilder.append("$SEAT ")
                }
            }
        }
        return strBuilder.toString()
    }
}

private const val SEAT = 'S'
private const val RESERVED_SEAT = 'B'
private const val CINEMA = "Cinema:"
private const val LARGE_ROOM_MIN_SEATS = 60
private const val TICKET_PRICE_10 = 10
private const val TICKET_PRICE_8 = 8
