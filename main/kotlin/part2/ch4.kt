import java.util.*

fun main(){
    //if_expressions_test()
    //max(90, 10005)
    //when_test2()
    //when_expression(6)
    repeat_test()
    val a = member_functionCalculator().plus(99, 1001) //ch5.kt 的類別
    println(a)

}
fun readLine_input_test(){
    //readLine()，用於從標準輸入流讀取字串輸入行。 它返回讀取的行或null。
    println("輸入你的名字：")
    val name = readLine()
    println("輸入你的年齡：")
    var age: Int =Integer.valueOf(readLine())
    println("你的名字是：$name ，今年 $age 歲")
}
fun readLine_input_test2(){
    //使用readLine()函式時，String之外的輸入行將顯式轉換為其對應的型別。
    //要輸入其他資料型別而不是String，
    //需要使用Java標準庫中的java.util.Scanner類的Scanner物件。
    //nextInt()是一個採用整數輸入並儲存在整數變數中的方法。
    val read = Scanner(System.`in`)
    println("請輸入你的年齡：")
    var age = read.nextInt()
    println("你的年齡是："+age + "歲")
}
fun if_expressions_test(){
    println("key a number to a:")
    val a = readLine()
    println("key a number to b:")
    val b = readLine()
    println("a = $a, b = $b")
    /*var max1 = 0
    //傳統寫法:較沒效率
    max1 = 0
    if (b > a) {
        max1 = b
        println("m1 max = $max1")
    }*/
    //kotlin if寫法
    //宣告改成 val，可以減少後續程式碼不小心改到變數的值的機會，
    //且符合優先使用 val 的準則；
    //再來，程式碼只有一行，寫的少犯錯的機會就減少
    val max = if ((a?.toInt()!!) > (b?.toInt()!!)) a else b
    print("max = $max")
}
fun max(a: Int, b: Int) = if (a > b){
    print("max = $a")
}else{
    print("max = $b")
}
fun when_test(){
    //4.1.2 when
    //Kotlin 沒有 switch 這個關鍵字，而是設計了 when 敍述來取代它
    //可以使用括號 () 來接受要比對的參數
    val x: Any = 9922.26
    when (x) {
        1 -> print("x 是 1")
        2,3,4 -> print("x 可能是 2 或 3 或 4")
        in 5..10 -> print("x 在 5~10 的範圍內")
        is Int -> print("x 是整數")
        else -> {
            print("無法判斷 x")
        }
    }
}
fun when_test2(){
    println("key a 整數 x:")
    var a: String? = readLine()
    val x = a?.toInt()
    print("Number x = ")
    //when不一定要使用括號 () 來接受參數，可以直接寫在比對條件中
    when {
        x == 1 -> print("$x 是 1")
        x == 2 || x == 3 || x == 4 -> print("$x 可能是 2 或 3 或 4")
        x in 5..10 -> print("$x 在 5~10 的範圍內")
        x is Int -> print("$x 是整數")
        else -> {
            print("無法判斷 x")
        }
    }
}
fun when_expression(x: Any){
    val msg = when (x) {
        1 -> "x 是 1"
        2,3,4 -> "x 可能是 2 或 3 或 4"
        in 5..10 -> "x 在 5~10 的範圍內"
        is Int -> "x 是整數"
        else -> {
            // 這裡可以寫很多東西，但是記得要把結果值放在最後一行
            println("...")
            "無法判斷 x"
        }
    }
    println(msg)
}
fun for_condition_test(){
    print("M1:")
    for(i in 0..9){
        print(i)
    }
    println("")
    print("M2:")
    for (i in 0.rangeTo(9)) {
        print(i)
    }
    println("")
    print("M3:")
    for (i in 0 until 10) { // <== 不包含 10
        print(i)
    }
}
fun foe_downTo(){
    //循環順序要反過來，也就是從大到小，可以使用 downTo
    print("M1:")
    for (i in 9 downTo 0) {
        print(i)
    }
    println("")
    print("M2:")
    for (i in 9.downTo(0)) {
        print(i)
    }
}
fun for_step(){
    //每次循環是累進 1，即跳 1 階，
    //如果要一次跳 N 階，可以使用 step 來指定
    print("M1:")
    for (i in 0..27 step 3) {
        print("$i ")
    }
    println("")
    print("M2:")
    for (i in 0.rangeTo(27).step(3)) {
        print("$i ")
    }
}
fun for_in_Iterative(){
    val names = listOf("Tony", "Dawi", "Tiffany", "Super Man")
    for (name in names) {
        println(name)
    }
}
fun for_withIndex(){
    val names = listOf("Tony", "Dawi", "Tiffany", "Super Man")
    for ((index, name) in names.withIndex()) {
        println("$index: $name")
    }
}
fun for_indices(){
    //Kotlin 還有一個方便的屬性叫做 indices，
    //它會回傳陣列或集合的範圍，這樣我們就可以省去自己指定範圍的動作
    val names = listOf("Tony", "Dawi", "Tiffany", "Super Man")
    for (index in names.indices) {
        //indices 會回傳一段範圍值 0..3。
        //可以避免存取索引值時超過陣列或集合範圍的例外
        println("$index: ${names[index]}")
    }
}
fun while_test(){
    //4.2.2 while
    //判斷條件是否符合才執行的 while 迴圈
    var i = 5
    while (i > 0) {
        println(i)
        i--
    }
}
fun do_while_test(){
    //4.2.2 while
    //do while 迴圈會先執行區塊中的程式才去檢查條件
    var i = 5
    do {
        println(i)
        i--
    } while (i > 0)
}
fun Leave_the_loop(){
    for (i in 0..1) {
        //println("i: $i")
        for (j in 0..3) {
            println("j: $j")
            if (j == 2) {
                println(">>> 離開 Leave_the_loop()")
                return
            }
        }
    }
}
fun break_test(){
    for (i in 0..2) {
        for (j in 0..2) {
            println("($i, $j)")
            if (j == 0) {
                break
            }
        }
    }
}
fun foo1() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return // 非局部直接返回到 foo() 的调用者
        print(it)
    }
    println("this point is unreachable")
}
fun foo() {
    listOf(1, 2, 3, 4, 5).forEach aa@{
        if (it == 3) return@aa // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
        print(it)
    }
    print(" done with explicit label")
}
fun break_label_test(){
    loop@ for (i in 0..2) {
        for (j in 0..2) {
            println("($i, $j)")
            if (j == 0) {
                break@loop
            }
        }
    }
}
fun continue_test(){
    for (i in 0..2) {
        if (i == 1) {
            continue
        }
        println(i)
    }
}
fun repeat_test(){
    //單純想要重覆執行某段程式碼一定的次數，可以使用 repeat
    repeat(13) {
        println("Hello")
    }
}