fun groupWordsByLetters(words: List<String>): List<List<String>> {
    return words.groupBy { it.toCharArray().sorted().joinToString("") }
        .values.toList()
}

fun main() {
    println("Введите слова через запятую:")
    val input = readLine() ?: ""
    val words = input.split(",").map { it.trim() }

    val groupedWords = groupWordsByLetters(words)

    println("Сгруппированные слова:")
    for (group in groupedWords) {
        println(group.joinToString(", "))
    }
}