package part1

fun main(){
    val myPlusA = Plus(9, 2)                                // 使用屬性
    println("${myPlusA.first}${myPlusA.second}")

    val (textA, resultA) = Plus(2, 3)                       // 使用解構式
    println("$textA$resultA")

    val b = Plus(1, 2, 3)                                // 使用屬性
    println("${b.first}${b.second} (${b.third})")

    val (textB, resultB, isPositiveB) = Plus(4, 5, 6)    // 使用解構式
    println("$textB$resultB ($isPositiveB)")
}
fun Plus(a: Int, b: Int): Pair<String, Int> {
    //為了區隔內建的 plus 函式，這裡故意命名為 myPlus
    val result = a + b
    val text = "$a + $b = "
    return Pair(text, result)
}
fun Plus(a: Int, b: Int, c: Int): Triple<String, Int, Boolean> {
    val result = a + b + c
    val text = "$a + $b + $c = "
    val isPositive = (result >= 0)
    return Triple(text, result, isPositive)
}