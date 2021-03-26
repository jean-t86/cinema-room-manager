package cinema

fun main() {
    // write your code here
    println("Enter the number of rows:")
    val rows: Int = readLine()!!.toInt()
    println("Enter the number of seats in each row: ")
    val seats: Int = readLine()!!.toInt()

    println()
    println(Theatre.cinemaScheme(rows, seats))
    println()

    println("Enter a row number:")
    val rowNumber = readLine()!!.toInt()
    println("Enter a seat number in that row:")
    val seatInRow = readLine()!!.toInt()

    println()
    print("Ticket price: ")
    println("\$${Theatre.ticketPrice(rows, seats, rowNumber)}")
    println()
    println(Theatre.cinemaScheme(rows, seats, rowNumber, seatInRow))
}
