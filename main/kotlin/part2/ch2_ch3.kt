import kotlin.math.roundToInt
//使用 Kotlin 提供的 data class 來建立類別，比較結構時才會相等，
//這是因為 data class 幫我們實做了等式判斷用的 equals() 方法，
//如果使用一般的類別而又沒有實作 equals() 方法，
//比較結構的結果等同於比較參考的結果。
data class User(val name: String)
fun main() {
    nativate_string__test()
    trimMargin_string_test()
}
fun array_test(){
    val names: Array<String> = arrayOf<String>("Tony", "Andy", "Bob")
    //println(names[1])

    val data: Array<Int> = arrayOf(1,2,3,4,5) // 宣告Array並賦予 1-5 數值
    data.forEach { println(it) }              // 利用 forEach 分別印出數值
}
fun Any_test(){
    //Any 型別是 Kotlin 中所有類別的根，每個 Kotlin 類別都繼承自 Any，它相當於 Java 中的 Object 類別。
    val a: Any = "123"
    val b: Any = 123

    println("a: ${a}, b: ${b}")
    println("type a is Int? ${a is Int}")        //is 可以用來檢查該物件是否屬於某個型別
    println("type a is not Int? ${a !is Int}")   //!is 反過來檢查該物件不是屬於某個型別
    println("type b is Int? ${b is Int}")
    println("type b is not Int? ${b !is Int}")
}
fun type_return_test() {
    //檢查型別不符合時執行 return ，這樣之後的敍述都不會被執行
    //只有在 a 是 String 的情況下，才會被智慧轉型並執行
    val a: Any = 123
    if (a !is String) return
    println("the length: ${a.length}")
}
fun NullPointerException_test(){
    val a: String = "Tony"
    println("string a length = ${a.length}")

    //method1: 對於變數 b 則有風險，立即被編譯器發現而編譯失敗，我們必須檢查該變數的值是否為 null
    val b: String? = "Tony"
    //println(b.length) // <-- 編譯失敗
    if (b != null) {
        println("string b length = ${b.length}")
    }
    //method2: 使用 ?. 符號來安全呼叫成員
    //?. 的意思是「如果變數 b1 有值就存取它的 length 屬性，如果是 null 就不要做任何動作
    val b1: String? = "Tony"
    println("string b1 length = ${b1?.length}")

    //一旦我們使用了一個安全呼叫，在其後的呼叫鏈也必須使用安全呼叫
    val c: String? = "Tony"
    println(c?.toUpperCase()?.replace("Y", "")?.length)
}
fun Elvis_Operator_test(){
    //把 "3.14" 字串直接轉 Int 會發生 NumberFormatException
    //用了貓王運算子 ?:，當 null 的時候預設給 0，所以結果會是 0
    val numStr2 = "abfffffffc"
    val num2 = numStr2.toIntOrNull() ?: 0
    val num3 = numStr2.toBigDecimalOrNull() ?: 0
    println(num2)
    println(num3)
}
fun float_format_test(){
    val x = 10.1
    val y = 5.53
    val result = x - y
    println("x = $x, y = $y")
    println("x - y = $result")                      //4.569999999999999
    println("x - y = ${"%.2f".format(result)}")     // 4.57
    println("四捨五入(x-y): ${result.roundToInt()}") //5
}
fun safe_convert_test(){
    //as 轉型時，如果轉型失敗會丟出 ClassCastException
    //建議使用安全的轉型 as?
    val a: Any = 123
    println(a as? String ?: "無法轉型為字串")
}
fun Structure_comparison(){
    //Kotlin 的 == 和 Java 的 == 行為是不同的
    //Java 的 == 比較的是參考 (位址)， equals() 方法則是比較值。
    //Kotlin 使用 == 或 equals() 來比較值，使用 === 是比較參考 (位址)。
    val a: Int = 1
    val b: Long = 1L
    val c: Double = 1.0
    print("a = $a, b = $b, c = $c\n")
    println("a:${a::class.simpleName}, b:${b::class.simpleName}, c:${c::class.simpleName}")
    println("a.toLong() == b: ${a.toLong() == b}") // true
    println("a.toDouble() == c: ${a.toDouble() == c}") // true
    println("a.compareTo(b): ${a.compareTo(b)}") // 0
    println("a.compareTo(c): ${a.compareTo(c)}") // 0
}
fun data_types_test(){
    //Kotlin 在資料型別與 Java 非常相似，只差在變數型態必須使用首字大寫
    val byte: Byte = 1
    val short: Short = 2
    val int: Int = 3
    val long: Long = 4L
    val float: Float = 5f
    val double: Double = 6.0

    println("Byte => $byte")
    println("Short => $short")
    println("Int => $int")
    println("Long => $long")
    println("Float => $float")
    println("Double => $double")
}
fun data_types_test2(){
    //當 a 變數為 127 時，判斷兩個裝箱變數會為 true，
    //因為 Int 型態定義數值範圍為 -128 ~ 127，
    //當 b 變數超過 127 數值時，Kotlin 在記憶體分配上會有不同位置狀況發生。
    val a: Int = 127
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 128
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println(boxedA === anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false
}
fun Unit_type_test(){
    //在 Java 中，當我們所設計的 function 不需回傳值時，我們會使用到 void 型別
    //在 Kotlin 可使用 Unit 型別代替，且若不特地為 function 設定回傳型態時，
    //Kotlin 會自動幫我們預設型態為 Unit 型別，會返回 Unit 型別
    val username = getUserName()
    println("username : ${username::class.simpleName}") // 印出 Unit 型別
}
fun getUserName() {
    println("this is getUserName function")
}
fun Use_Nothing_type_test(): Nothing {
    throw NotImplementedError() // 丟出異常
}
fun Use_Nothing_type_test2(): Nothing? {
    return null
}
fun type_convert_automatic_test(){
    //隱性轉換
    //兩個數值為不同型態時，會自動以定義數值範圍較大的型態為轉換後的最終型態
    //999為 Long 型態，1為 Int 型態，兩數相加後的結果 number 為 Long 型態
    val number = 999L + 1
    println(number::class.simpleName) // 印出資料型別為 Long
}
fun Dominant_conversion_test(){
    //避免隱性轉換時自動選擇型態問題，在開發上可使用顯性轉換方式
    val number: Int = 65
    println("${(number.toByte())::class.simpleName}: ${number.toByte()}")     //Byte: 65
    println("${(number.toShort())::class.simpleName}: ${number.toShort()}")   //Short: 65
    println("${(number.toLong())::class.simpleName}: ${number.toLong()}")     //Long: 65
    println("${(number.toFloat())::class.simpleName}: ${number.toFloat()}")   //Float: 65.0
    println("${(number.toDouble())::class.simpleName}: ${number.toDouble()}") //Double: 65.0
    println("${(number.toChar())::class.simpleName}: ${number.toChar()}")     //Char: A
    println("${(number.toString())::class.simpleName}: ${number.toString()}") //String: 65
}
fun equals_compare_test(){
    //Kotlin 的 == 和 Java 的 == 行為是不同的，
    //Java 的 == 比較的是參考 (位址)， equals() 方法則是比較值。
    //Kotlin 使用 == 或 equals() 來比較值，使用 === 比較參考 (位址)。
    //3.2.1 結構的比較
    val a = null
    val b = null
    val c = 123
    println(a?.equals(b) ?: (b === null))
    // 要比較某變數是否為 null 時，必須使用 === 比較其參考，
    // 但是我們不必明確的使用 ===，
    // 當我們使用 == 來比較是否為 null 時，
    // Kotlin 會自動幫我們轉換為 ===。
}
fun compareTo_test(){
    //對於不同的數值型別，必須轉換成相同型別才能比較，或是使用 compareTo() 方法
    val a: Int = 1
    val b: Long = 1L
    val c: Double = 3.0
    println(a.toLong() == b)
    println(a.toDouble() == c)
    //compareTo() 方法
    //如果此對像等於指定的其他對象，則返回0；
    //如果小於其他對象，則返回-1(負數)；
    //如果大於其他對象，則返回1(正數)。
    println(a.compareTo(b))
    println(a.compareTo(c))
}
fun object_compare_test(){
    //3.2.2 物件的比較
    //當我們建立一個物件時，會得到一個參考 (記憶體位址)，
    //要比較兩個物件是否屬於同一個參考，必須使用 ===
    val a = User("dawi")
    val b = User("dawi")
    val c = a          // 同一個物件，即相同參考
    println(a === b)   // false
    println(a === c)   // true
    //比較結構
    println(a == b)    // true
    println(a == c)    // true
}
fun string_template_test(){
    //3.3.1 字串模板
    val name = "Dawi"
    val age = 25
    println("My name is $name, $age years old.")
    //額外使用大括號 {}，可取用該變數的屬性或做任何的運算
    println("My name have ${name.length} characters.")
    println("1 + 2 = ${1 + 2}")
}
fun nativate_string__test(){
    //3.3.2 原生字串
    val code = """
    val names = arrayOf("Tony", "Tom", "John")
    for (name in names) {
      println(name)
    }
  """
    println(code)
}
fun trimMargin_string_test(){
    //trimMargin() 可以讓我們指定行的開頭，
    //預設使用 | 符號，輸出的內容會以這個符號當成行的起點。
    val code =
      """
      |val names = arrayOf("Tony", "Tom", "John")
      |for (name in names) {
        |println(name)
      |}
      """.trimMargin()
    println(code)
}
