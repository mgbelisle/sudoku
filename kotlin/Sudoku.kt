import java.io.File

/**
 * Parses a file of integers
 */
fun parse(file: String): List<Short> {
    return File(file).readText().trim().split(regex="\\s+".toRegex()).map { it.toShort() }
}

fun main(args: Array<String>) {
    println(parse(args[0]))
}
