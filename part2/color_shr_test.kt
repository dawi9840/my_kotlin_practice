package part2

const val MAX_CHANNEL_VALUE = 123456
fun main() {
    val color: Int = 0x0012faff;
    val green: Int = (color and 0x0000ff00 shr 8)
    println(green)
    println(ttT(green))
}
fun ttT(a:Int): Int {
    val checkBoundaries = { x: Int ->
        when {
            x > MAX_CHANNEL_VALUE -> MAX_CHANNEL_VALUE
            x < 0 -> 0
            else -> x
        }
    }
    var a = checkBoundaries(a)
    return a
}