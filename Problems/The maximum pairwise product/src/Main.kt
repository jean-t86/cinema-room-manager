fun main() {
    // write your code here
    val n = readLine()!!.toInt()

    val listIn = mutableListOf<Int>()
    for (i in 1..n) {
        listIn.add(readLine()!!.toInt())
    }

    if (listIn.size == 1) {
        println(listIn[0])
        return
    }

    var maxProduct = 0
    for (i in 0 until listIn.size) {
        for (j in 1 until listIn.size) {
            if (i == j) continue
            val product = listIn[i] * listIn[j]
            if (product > maxProduct) maxProduct = product
        }
    }

    println(maxProduct)
}
