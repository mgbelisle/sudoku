fun sudoku(puzzle: Array<Int>): Array<Int> {
    return arrayOf()
}

fun main(args: Array<String>) {
    println(sudoku(arrayOf(
            4, 9, 0,  2, 0, 1,  7, 0, 0,
            1, 2, 3,  0, 0, 0,  0, 8, 0,
            0, 0, 0,  0, 4, 0,  0, 2, 1,

            0, 0, 0,  8, 0, 0,  3, 0, 7,
            0, 0, 2,  4, 7, 9,  1, 0, 0,
            9, 0, 8,  0, 0, 3,  0, 0, 0,

            8, 3, 0,  0, 5, 0,  0, 0, 0,
            0, 4, 0,  0, 0, 0,  8, 6, 5,
            0, 0, 9,  6, 0, 8,  0, 1, 3
    )))
}