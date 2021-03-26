package cinema

fun main() {

    //region Room size input
    println("Enter the number of rows:")
    val rows: Int = readLine()!!.toInt()
    println("Enter the number of seats in each row: ")
    val seats: Int = readLine()!!.toInt()
    //endregion

    val theatre = Theatre()

    do {
        println()
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("0. Exit")
        val menuChoice = readLine()!!.toInt()
        println()

        when (menuChoice) {
            1 -> {
                println(theatre.cinemaScheme(rows, seats))
            }
            2 -> {
                println("Enter a row number:")
                val rowNumber = readLine()!!.toInt()
                println("Enter a seat number in that row:")
                val seatInRow = readLine()!!.toInt()

                theatre.reserveSeat(rowNumber, seatInRow)

                print("Ticket price: ")
                println("\$${theatre.ticketPrice(rows, seats, rowNumber)}")
            }
            0 -> break
        }
    } while (menuChoice != 0)
}
