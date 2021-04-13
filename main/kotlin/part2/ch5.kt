fun main(){
    //println(sum())
    //println(sum1(9, 10))

    /*sum2(1, 2, 3)      // 所有參數必須依序指定值
    sum2(a = 1, c = 3)         // 使用參數名稱指定值，略過有預設值的 b
    sum2(c = 1, a = 2, b = 3)  // 只要以名稱指定參數的值，就可以忽略原始參數的順序*/
    /*sum_vararg()
    sum_vararg(1, 2)
    sum_vararg(3, 4, 5)*/
    //val numbers = intArrayOf(2, 4, 6)
    //sum_vararg(*numbers)
    //sum_many_vararg("aaa", 1, 1, 2, 3) // 多出來的參數值都會分配給 numbers
    //println(1.plus(2))             // 呼叫方法
    //println(1 plus 2)                    // 中綴表示法
    val a = member_functionCalculator().plus(2, 3) //// 實體化類別成為物件並呼叫其方法
    //println("a: $a")
    New_User("Dawi", 200).showInfo()
}

fun foo1(z:Int){
    val b = z+1
    println("foo1, $b")
}
fun foo2(): Unit {
    // 函式一定會有回傳值，如果沒有指定回傳值，預設會回傳「空值 Unit」
    println("foo2")
}
//5.3名稱指定參數的值
fun sum(a: Int = 0, b: Int = 0): Int {
    // 有參數、有回傳值的函式
    return a + b
}
fun sum1(a: Int = 0, b: Int  =0) = a + b  //使用函式表達式
fun sum2(a: Int, b: Int = 10, c: Int) {
    // 參數 b 有指定預設值
    println(a + b + c)
}
//5.4數量不固定的參數 (Varargs)
fun sum_vararg (vararg numbers: Int) {
    //vararg 關鍵字，代表此參數的數量是不固定的，在函式內部會以陣列來表示這個參數值，
    var total = 0
    for (i in numbers.indices) {
        total += numbers[i]
    }
    println(total)
}
fun sum_many_vararg(a: String, b: Int, vararg numbers: Int) {
    //如果一個函式有多個參數，而其中一個是 vararg 參數，最好把它放在最後面，
    var total = 0
    for (b in numbers.indices) {
        total += numbers[b]
    }
    println("this is $a, you key the $total, ")
}

//5.5 函式表達式
fun plus1(a: Int, b: Int): Int {
    // 函式敍述
    return a + b
}
fun plus2(a: Int, b: Int): Int = a + b // 函式表達式

//Kotlin 提供 infix 這個關鍵字，
//當我們加在函式宣告前面時，
//此函式可以被當成中綴符號來使用，替代原本的 .() 呼叫方式
infix fun Int.plus(x: Int) = this + x
//infix 函式有幾個要求:
    //1.必須是成員函式 (即類別的方法) 或擴充函式 (extension function)
    //2.必須有、且只有一個參數
    //3.參數不能是數量不固定的 vararg 參數
    //4.參數不能有預設值

fun plus_test(a: Int = 2, b: Int = 3): Int {
    val result = a + b
    // 5.7.1 區域函式
    fun showResult() {
        // 區域函式可以存取外部函式的變數
        println(result)
    }
    // 呼叫區域函式
    showResult()
    return result
}
class member_functionCalculator() {
    // 成員函式 (方法)
    fun plus(a: Int, b: Int) = a + b
}

