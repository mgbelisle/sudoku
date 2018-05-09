import java.io.File

/**
 * Parses a file of integers
 */
fun parse(file: String): List<Int> {
    return File(file).readText().trim().split(regex="\\s+".toRegex()).map { it.toInt() }
}

fun main(args: Array<String>) {
    println(parse(args[0]))
}
