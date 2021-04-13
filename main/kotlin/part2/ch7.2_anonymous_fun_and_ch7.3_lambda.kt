fun main() {
/** 7.2 匿名函式 **/
//匿名函式就是沒有名稱的函式，我們可以將其指派給變數來使用
//或是將其當成另一個函式的參數
    /*
    /** 匿名函式單獨存在並沒有任何意義，必須指派給變數或其他函式的參數 **/
    fun (m: Int, n: Int): String {                         // 這是一個匿名函式
        return "$m + $n = ${m + n}"
    }
    fun (m: Int, n: Int): String = "$m + $n = ${m + n}"    // 可以使用函式表達式語法來簡化
    */

    // 將匿名函式指派給變數
    val a: (Int, Int) -> String = fun(m: Int, n: Int): String = "$m + $n = ${m + n}"
    val a1: (Int, Int) -> String = fun(m, n) = "$m + $n = ${m + n}"  // 依據型別推論，可以簡化成這樣
    val a2 = fun(m: Int, n: Int) = "$m + $n = {m + n}"   //或這樣 (在熟悉 Kotlin 之後建議這種寫法)

    /** 這是一個高階函式 **/
    // 接受 (Int, Int) -> String 這種函式型別的參數
    fun demo(x: (Int, Int) -> String) {
        println(x(1, 3))
    }

    fun ddaa(x: (Int, Int) -> String) = println(x(5, 6))
    //ddaa(a) //// 將擁有「型別相符的函式型別的匿名函式」的變數傳入
    //demo(a) //// 將擁有「型別相符的函式型別的匿名函式」的變數傳入

    //通常會直接將匿名函式當成函式的參數傳入，而不用另外宣告一個變數
    fun abc(x: (Int, Int) -> String) {
        println(x(7, 8))
    }
    //abc(fun (m: Int, n: Int) = "$m + $n = ${m + n}")

/** 7.3 Lambda 表達式 **/
//Lambda 表達式可以讓匿名函式的語法更精簡。Lambda 表達式的語法一定被大括號 {} 包圍，
//裡面由箭號 -> 分成左右兩邊，參數宣告在箭號左邊，必須指定資料型別
//如果能夠型別推斷則可以省略；箭號右邊是函式的主體。
//假如推斷的回傳值型別不是 Unit ，表示會有回傳值，那在函式主體中的最後一行 (也可能只有一行) 敍述就會被當成回傳值。
    val ab: (Int, Int) -> String = fun(m: Int, n: Int): String = "$m + $n = ${m + n}" // 將匿名函式指派給變數
    val aLambda = { m: Int, n: Int -> "$m + $n = ${m + n}" } // 使用 Lambda 改寫

    /** 這是一個高階函式 **/
    // 接受 (Int, Int) -> String 這種函式型別的參數
    fun demo1(x: (Int, Int) -> String) {
        println(x(1, 185))
    }
    //demo1(ab)
    //demo1(aLambda)
    /*
    demo1(fun (m: Int, n: Int) = "$m + $n = ${m + n}")  //改成直接將匿名函式當成函式的參數傳入
    demo1 ({ m, n -> "$m + $n = ${m + n}" })            // 改成 Lambda 表達式
    demo1() { m, n -> "$m + $n = ${m + n}" }            //但是強烈建議寫成這樣，見下節說明
    demo1 { m, n -> "$m + $n = ${m + n}" }              // 最後簡化成這樣 (這是熟練之後的最佳語法)
    */

/** 7.3.1 Lambda 作為最後一個參數 **/
//Kotlin 的 Lambda 表達式有一個特性，
//如果高階函式的最後一個參數是函式，
//當Lambda 表達式當成該參數的值傳入時，
//可以將其移到括號 () 後面，
//而如果這個 Lambda 表達式是唯一的參數，還可以省略括號 ()
    fun DM(x: (Int, Int) -> Int) {            /*只有一個參數，並且是函式型別*/
        println(x(1, 2))
    }
    //DM { m, n -> m + n }                      // 使用方式

    fun DM2(a: Int, x: (Int, Int) -> Int) {   /* 有兩個參數，最後一個是函式型別 */
        println(a + x(1, 4))
    }
    //DM2(a=1, { m, n -> m + n })              // 不推薦的使用方式
    //DM2(1) { m, n -> m + n }               // 較佳的使用方式

/** 7.3.2 隱含的單一參數名稱：it **/
//Lambda 表達式如果只有一個參數，而編譯器可以識別這個函式型別，
//我們就可以省略宣告這個唯一參數的動作
//Kotlin 會隱含的以 it 這個名稱來宣告這個唯一參數，
//我們可以直接使用它
    //建立一個有接收型別的高階函式 ()
    //接收型別為 Int.傳入的參數為 (Int) -> Boolean 函式型別，最後回傳布林值
    //fun Int.d_Int2Bool(f: (Int) -> Boolean): Boolean {   // 完整寫法
    //  return f(this)
    //}
    fun Int.d_Int2Bool(f: (Int) -> Boolean) = f(this)  // 簡化改寫如下，return 換成 = 並省略 {}
    1.d_Int2Bool(fun (x: Int): Boolean { return x % 2 == 0 }) //1. 使用時，傳入一個匿名函式
    1.d_Int2Bool(fun (x: Int) = x % 2 == 0)                   //2. 簡化改寫如下 (由回傳值即可推斷出資料型態，因此省略)
    1.d_Int2Bool({ x -> x % 2 == 0 })                         //3. 使用 Lambda 改寫
    1.d_Int2Bool { x -> x % 2 == 0 }                          //4.Lambda 是最後一個參數，可以把它放在括號後面，並省略括號
    //5. 因為此 Lambda 只有一個參數，可以直接用隱含宣告的 it
    //熟練之後，程式碼將會都是這種超簡潔的樣式
    1.d_Int2Bool { it % 2 == 0 }

    // 測試結果，判斷是否為偶數
    /*println(1001.d_Int2Bool { it % 2 == 0 })   // false
    println(2.d_Int2Bool { it % 2 == 0 })        // true
    println(73.d_Int2Bool { it % 2 == 0 })       // false
    */
    println("----------------------------------")
    //使用高階函式的好處，我們可以隨時換掉程式邏輯
    val cc:Any ?= 1.d_Int2Bool { it % 2 != 0 }   //判斷是否為奇數
    1.d_Int2Bool { it > 0 }                      //判斷是否大於 0
    1.d_Int2Bool { it in 0..100 }                //判斷是否介於 0 到 100
    println("cc: $cc" )

/** 7.3.3 匿名函式和 Lambda 表達式的差異 **/
//匿名函式的參數必須用括號 () 包圍，Lambda 表達式則不需要。
//Lambda表達式無法明確指定回傳值的資料型別，只能透過運算結果推斷。
//如果非要指定回傳值的資料型別，就只能使用匿名函式。

//對於 return 關鍵字的使用，在匿名函式中可以順利離開該函式。
//但在 Lambda 表達式中並不能這麼做，
//唯一能做的就是使用 return@函式名稱 明確指定。
}