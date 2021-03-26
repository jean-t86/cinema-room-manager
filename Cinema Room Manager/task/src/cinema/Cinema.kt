package cinema

fun main() {

    //region Room size input
    println("Enter the number of rows:")
    val rows: Int = readLine()!!.toInt()
    println("Enter the number of seats in each row: ")
    val seats: Int = readLine()!!.toInt()
    //endregion

    val theatre = Theatre(rows, seats)
    val sales = Sales(theatre)

    do {
        println()
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        val menuChoice = readLine()!!.toInt()
        println()

        when (menuChoice) {
            1 -> {
                println(theatre.cinemaScheme())
            }
            2 -> {
                var validCoords = false
                do {
                    println("Enter a row number:")
                    val rowNumber = readLine()!!.toInt()
                    println("Enter a seat number in that row:")
                    val seatInRow = readLine()!!.toInt()

                    if (theatre.isSeatTaken(rowNumber, seatInRow)) {
                        println("That ticket has already been purchased!")
                        continue
                    }

                    if (rowNumber > rows || seatInRow > seats) {
                        println("Wrong input!")
                        continue
                    }

                    validCoords = true
                    if (!theatre.reserveSeat(rowNumber, seatInRow)) {
                        println("That ticket has already been purchased!")
                    } else {
                        print("Ticket price: ")
                        println("\$${sales.ticketPrice(rowNumber)}")
                    }
                } while (!validCoords)
            }
            3 -> {
                println("Number of purchased tickets: ${sales.totalTicketsSold()}")
                println("Percentage: ${sales.totalTicketsSoldAsPercentage()}")
                println("Current income: ${sales.currentIncome()}")
                println("Total income: ${sales.totalIncome()}")
            }
            0 -> break
        }
    } while (menuChoice != 0)
}
