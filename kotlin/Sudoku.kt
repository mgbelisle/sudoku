import java.io.File

/**
 * Returns a list of indices that are in the same row, column, or box.
 */
fun buddies(i: Int): List<Int> {
    val row = i / 9
    val col = i % 9
    val box = 3 * (row / 3) + col / 3
    return (0..80).filter {
        val row2 = it / 9
        val col2 = it % 9
        val box2 = 3 * (row2 / 3) + col2 / 3
        it != i
                && row == row2
                || col == col2
                || box == box2
    }
}

fun main(args: Array<String>) {
    val puzzle = File(args[0]).readText().trim().split(regex = "\\s+".toRegex())
            .map { if (it == "0") (1..9).toSet() else setOf(it.toByte()) }
    for (i in (0..puzzle.size-1)) {
        println("$i: ${buddies(i)}")
    }
}
