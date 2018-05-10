import java.io.File

fun solve(puzzle: List<Set<Byte>>): List<Set<Byte>> {
    return emptyList()
}

fun main(args: Array<String>) {
    val puzzle = File(args[0]).readText().trim().split(regex = "\\s+".toRegex())
            .map { if (it == "0") (1..9).toSet() else setOf(it.toByte()) }
    println(puzzle)
}
