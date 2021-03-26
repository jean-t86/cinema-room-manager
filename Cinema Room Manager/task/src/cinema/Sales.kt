package cinema

import kotlin.math.floor

class Sales(private val theatre: Theatre) {

    private val reservations = theatre.reservations

    fun totalTicketsSold() = reservations.size

    fun totalTicketsSoldAsPercentage(): String {
        val twoDecimalPoints = "%.2f".format((100.0 / theatre.totalSeats) * reservations.size)
        return "$twoDecimalPoints%"
    }

    fun currentIncome(): String {
        val total = reservations
            .map { ticketPrice(it.first) }
            .sum()
        return "\$$total"
    }

    fun totalIncome(): String {
        var totalIncome = 0
        for (i in 1..theatre.rows) {
            for (j in 1..theatre.seats) {
                totalIncome += ticketPrice(i)
            }
        }
        return "\$$totalIncome"
    }

    fun totalPriceSoldOut(): Int {
        val isLargeRoom = theatre.rows * theatre.seats > LARGE_ROOM_MIN_SEATS
        return if (isLargeRoom) {
            val frontHalf = floor(theatre.rows / 2.0).toInt()
            val backHalf = theatre.rows - frontHalf

            ((frontHalf * theatre.seats) * TICKET_PRICE_10) + ((backHalf * theatre.seats) * TICKET_PRICE_8)
        } else {
            (theatre.rows * theatre.seats) * TICKET_PRICE_10
        }
    }

    fun ticketPrice(rowNumber: Int): Int {
        val isLargeRoom = theatre.rows * theatre.seats > LARGE_ROOM_MIN_SEATS
        return if (isLargeRoom) {
            val frontHalf = floor(theatre.rows / 2.0).toInt()
            if (rowNumber <= frontHalf) {
                TICKET_PRICE_10
            } else {
                TICKET_PRICE_8
            }
        } else {
            TICKET_PRICE_10
        }
    }

}

private const val LARGE_ROOM_MIN_SEATS = 60
private const val TICKET_PRICE_10 = 10
private const val TICKET_PRICE_8 = 8
