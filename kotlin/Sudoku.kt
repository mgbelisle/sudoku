func buddies(i: Int): List<int> {

}

fun solve(puzzle: Array<Int>): Array<Int> {
    return puzzle
}

fun main(args: Array<String>) {
    val array = arrayOf(
            4, 9, 0,  2, 0, 1,  7, 0, 0,
            1, 2, 3,  0, 0, 0,  0, 8, 0,
            0, 0, 0,  0, 4, 0,  0, 2, 1,

            0, 0, 0,  8, 0, 0,  3, 0, 7,
            0, 0, 2,  4, 7, 9,  1, 0, 0,
            9, 0, 8,  0, 0, 3,  0, 0, 0,

            8, 3, 0,  0, 5, 0,  0, 0, 0,
            0, 4, 0,  0, 0, 0,  8, 6, 5,
            0, 0, 9,  6, 0, 8,  0, 1, 3
    )
    println(solve(array))
}