import java.io.File


fun main(args: Array<String>) {
    println(puzzleToString(solve(stringToPuzzle(File(args[0]).readText()))))
}

fun solve(puzzle: List<Byte>): List<Byte> {
    var possible = puzzle.map { if (it == 0.toByte()) (1..9).map { it.toByte() }.toSet() else setOf(it) }
    while (true) {
        val next = possible.map { it.toMutableSet() }
        for (i in (0..80)) {
            if (next[i].size == 1) {
                for (buddy in buddies(i)) {
                    next[buddy].remove(next[i].first())
                }
            }
        }
        if (next == possible) break
        possible = next
    }
    return possible.map { if (it.size == 1) it.first() else 0 }
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
        it != i && (row == row2
                || col == col2
                || box == box2)
    }
}

fun puzzleToString(puzzle: List<Byte>): String {
    return (0..71 step 9).map { puzzle.slice(it..it + 9).joinToString(" ") }.joinToString("\n")
}

fun stringToPuzzle(v: String): List<Byte> {
    return v.trim().split(regex = "\\s+".toRegex()).map { it.toByte() }
}
