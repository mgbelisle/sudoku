import java.io.File

fun buddies(i: Int): List<Int> {
    return (0..80).filter {
        i / 9 == it / 9
        || i % 9 == it % 9
    }
}

fun main(args: Array<String>) {
    val puzzle = File(args[0]).readText().trim().split(regex = "\\s+".toRegex())
            .map { if (it == "0") (1..9).toSet() else setOf(it.toByte()) }
    for (i in (0..puzzle.size-1)) {
        println(buddies(i))
    }
}
