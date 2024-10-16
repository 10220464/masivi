val alphabet = arrayOf(
    'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я'
)
val alphabetMap = mapOf(
    'А' to 21, 'Б' to 13, 'В' to 4, 'Г' to 20, 'Д' to 22, 'Е' to 1, 'Ё' to 25, 'Ж' to 12, 'З' to 24, 'И' to 14, 'Й' to 2, 'К' to 28,
    'Л' to 9, 'М' to 23, 'Н' to 3, 'О' to 29, 'П' to 6, 'Р' to 16, 'С' to 15, 'Т' to 11, 'У' to 26, 'Ф' to 5, 'Х' to 30, 'Ц' to 27,
    'Ч' to 8, 'Ш' to 18, 'Щ' to 10, 'Ь' to 33, 'Ы' to 31, 'Ъ' to 32, 'Э' to 19, 'Ю' to 7, 'Я' to 17
)

fun encrypt(text: String, key: String): String {
    val result = StringBuilder()

    // Приводим к верхнему регистру, чтобы не учитывать регистр букв
    val upperText = text.uppercase()
    val upperKey = key.uppercase()

    for (i in upperText.indices) {
        val letter = upperText[i]
        val letterPos = alphabetMap[letter] ?: continue // Пропускаем символы, которых нет в алфавите
        val shiftLetter = upperKey[i % upperKey.length]
        val shiftPos = alphabetMap[shiftLetter] ?: 0

        // Закольцованный массив алфавита
        val encryptedPos = (letterPos + shiftPos - 1) % 33
        result.append(alphabet[encryptedPos])
    }

    return result.toString()
}

fun main() {
    println("Введите ключевое слово:")
    val key = readLine() ?: ""

    println("Введите текст для шифрования:")
    val text = readLine() ?: ""

    val encryptedText = encrypt(text, key)
    println("Зашифрованный текст: $encryptedText")
}