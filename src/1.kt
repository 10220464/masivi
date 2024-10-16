fun countUniqueDigits(matrix: Array<IntArray>): Int {
    val digits = mutableSetOf<Char>()

    // Преобразуем все числа массива в строки и собираем все уникальные цифры
    for (row in matrix) {
        for (num in row) {
            digits.addAll(num.toString().toSet())
        }
    }
    return digits.size
}

fun main() {
    println("Введите количество строк и столбцов:")
    val (rows, cols) = readLine()!!.split(" ").map { it.toInt() }

    val matrix = Array(rows) { IntArray(cols) }
    println("Введите трехзначные числа для заполнения массива:")

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            matrix[i][j] = readLine()!!.toInt()
        }
    }

    // Выводим двумерный массив
    println("Введенный массив:")
    for (row in matrix) {
        println(row.joinToString("\t"))
    }

    // Подсчитываем количество уникальных цифр
    val uniqueDigitCount = countUniqueDigits(matrix)
    println("В массиве использовано $uniqueDigitCount различных цифр")
}