package cinema

class Theatre(val rows: Int, val seats: Int) {

    private val _reservations: MutableList<Pair<Int, Int>> = mutableListOf()
    val reservations: List<Pair<Int, Int>>
        get() = _reservations

    val totalSeats: Int
        get() = rows * seats

    fun reserveSeat(rowNumber: Int, seatInRow: Int): Boolean =
        if (_reservations.contains(Pair(rowNumber, seatInRow))) {
            false
        } else {
            _reservations.add(Pair(rowNumber, seatInRow))
            true
        }

    fun cinemaScheme(): String {
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
                } else if (_reservations.any { (row, seat) ->
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
