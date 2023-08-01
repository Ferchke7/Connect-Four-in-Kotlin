package connectfour

fun promptBoard(): Pair<Int, Int> {

    while (true) {

        println("Set the board dimensions (Rows x Columns)")
        println("Press Enter for default (6 x 7)")
        val input = readln().replace(Regex("[ \t]"), "")
        if (input == "") return Pair(6, 7)
        if (!input.matches(Regex("[0-9]+[xX][0-9]+"))) {
            println("Invalid input")
            continue
        }
        val (rows, cols) = input.split(Regex("[Xx]")).map { it.toInt() }
        if (rows < 5 || rows > 9) {
            println("Board rows should be from 5 to 9")
            continue
        }
        if (cols < 5 || cols > 9) {
            println("Board columns should be from 5 to 9")
            continue
        }
        return Pair(rows, cols)
    }
}
fun drawBoard(rows: Int,cols: Int) {
    println()
    for(i in 1..rows) {
        repeat(cols) {
            print("║ ")
        }
        print("║")
        println()
    }
    print("╚")
    repeat(cols-1) {
        print("═╩")
    }
    print("═╝")
}
fun main() {
    println("Connect Four")
    println("First player's name:")
    val player1 = readln()
    println("Second player's name:")
    val player2 = readln()
    val (rows, cols) = promptBoard()
    println("$player1 VS $player2")
    println("$rows X $cols board")
    for(i in 1..cols) print(" $i")
    drawBoard(rows,cols)
}

