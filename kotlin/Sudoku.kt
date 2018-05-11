import java.io.File


fun main(args: Array<String>) {
    println(puzzleToString(solve(stringToPuzzle(File(args[0]).readText()))))
}

fun solve(puzzle: List<Byte>): List<Byte> {
    return puzzle
}

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

fun puzzleToString(puzzle: List<Byte>): String {
    return (0..71 step 9).map { puzzle.slice(it..it+9).joinToString(" ") } .joinToString("\n")
}

fun stringToPuzzle(v: String): List<Byte> {
    return v.trim().split(regex = "\\s+".toRegex()).map { it.toByte() }
}
