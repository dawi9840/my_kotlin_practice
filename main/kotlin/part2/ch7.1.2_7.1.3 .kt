
fun main (){
/** 7.1.2 呼叫函式型別的實體 **/
//函式型別分為無接收型別，如前一節的例子，及有接收型別 (receiver type) 兩種，呼叫語法略有不同。
//無接收型別的函式型別的值可以透過它的 invoke(...) 運算子來呼叫，像是 f.invoke(x) 或是直接 f(x)。
    println("===== 有接收型別的函式型別 =====")
    /* ===== 有接收型別的函式型別 ===== */
    // String. 為接收型別
    // 呼叫時 String 必須是第一個參數，或前置
    val aaa1: String.(Int) -> Int = fun String.(m: Int): Int {
        return this.toInt() + m
    }
    val aaa2: String.(Int) -> Int = { m -> this.toInt() + m }  //Lambda 改寫
    //3 種呼叫方式均可
    println("aaa1: ${aaa1.invoke("6", 9)}, ${aaa1("6", 9)}, ${"6".aaa1(9)}")
    println("aaa2: ${aaa2.invoke("6", 9)}, ${aaa2("6", 9)}, ${"6".aaa2(9)}")

    println("===== 無接收型別的函式型別 =====")
    /* ===== 無接收型別的函式型別 ===== */
    val bbb1: (Int, Int) -> Int = fun (m: Int, n: Int): Int {
        return m - n
    }
    val bbb2: (Int, Int) -> Int = { m, n -> m - n }  //Lambda 改寫
    //少了一種呼叫方式，因為它沒有接收型別
    println("bbb1: ${bbb1.invoke(1, 2)}, ${bbb1(1, 2)}")
    println("bbb2: ${bbb2.invoke(1, 2)}, ${bbb2(1, 2)}")

/** 7.1.3 兩種函式型別的互換**/
//有接收型別的函式型別可以和無接收型別的函式型別互換
//也就是 A.(B) -> C 相等於 (A, B) -> C

    // 無接收型別的函式型別
    val a: (Int, Int) -> String = fun (m: Int, n: Int): String {
        return "$m + $n = ${m + n}"
    }
    val a713: (Int, Int) -> String ={m, n -> "$m + $n = ${m+n}"}
    // 將無接收型別的函式型別，指派給有接收型別的函式型別
    val b: Int.(Int) -> String = a
    println(a713(1, 2))
    println(a(1, 2))
    println(b(1, 2))
    println(1.b(2))
}