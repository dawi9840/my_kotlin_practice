import java.io.FileNotFoundException
import java.io.IOException

/** 8.1.1 擴充函式 **/
//針對類別來擴充，因此以類別做為接收型別 (receiver type)，
//在類別名稱後面以 . 接上擴充函式的名稱並定義其內容

// 針對 Number 類別建立擴充函式 toDollarString()
fun Number.toDollarString(): String {
    return "$$this"                    // this 指 Number 本身所建立的物件
}

fun main(){
    println(1.23.toDollarString())     // $1.23
    println(12345.toDollarString())    // $100
    println("-----------------------------")
/** 8.1.2 擴充函式依附在型別上 **/
//功能擴充實際上並沒有真的修改它所擴充的類別。
//當我們定義了一個擴充功能時，並沒有新增任何新成員到這個類別中，
//而只是針對這個型別實體化的物件新增了一個可以透過 . 來呼叫的新函式而已。
    var aaa = OuO()
    //aaa.hello()
    sayHello(OAO()) //傳入OAO物件
    sayHello(OuO()) // 傳入 B 物件
    //Hi OuO
    //Hello OAO     <== 注意這個
    /** hi() 方法在編譯時期並不會被建立，而是直到 (執行時期) 使用 OAO 或 OuO 類別產生物件時才建立。
    擴充函式 hello() 則是在編譯時期就建立，因此它是「附加在這個型別」之上，也就是「認型別不認物件」。 **/
    println("-----------------------------")

/** 8.1.3 成員函式優先 **/
//當擴充函式和成員函式 (方法) 名稱一樣時，以成員函式優先，擴充函式會被遮蔽
    OAO().call()   // 建立 OAO 物件並呼叫 call()
    //但是擴充函式可以對成員函式 (方法) 多載 (overloading)
    val pp = OAO()
    pp.call()
    pp.call("Hiiiiii")
    println("------------------------------")

/** 8.1.4 允許接收型別為 null **/
//想讓擴充功能允許接收型別為 null，只要在接收型別後面加上問號 ?
//當然我們必須在函式內額外檢查 null，然後看是要丟出例外或是回傳預設值
// 只要在接收型別後面加上問號，擴充函式就允許 null
    fun Number?.toDollarString(): String {
        return if (this == null) "0" else "$$this"
    }
    // 建立一個允許 null 的變數
    var a : Int? = null
    println(a.toDollarString())
    a = 123555
    println(a.toDollarString())
    println("------------------------------")

/** 8.1.5 擴充功能的使用動機 **/
    val names = arrayListOf("Dawi", "John", "Tom")
    names.swap(i=0, j=2)
    println(names)
    println("------------------------------")

/** 8.2.1 補捉例外 **/
    try {
        // 可能發生例外的程式碼
        // 或明確丟出例外
        throw Exception("Oops！")
    } catch (e: Exception /* 要捕捉的例外類型 */) {
        // 在發生例外時要如何處理
        println(e.message) // Oops！
    } finally {
        // 非必要，無論有無捕捉到例外都會執行
        println("finally")
    }
    //catch 區塊可以指定要補捉 try 區塊中發生的哪些例外，例外的階層越高，就越能補捉到越多的例外
    //catch 區塊可以針對不同例外做處理而有多個，但記得要把階層低的 (子類別) 放前面，高的 (父類別) 放後面
    try {
        // ...
    } catch (e: FileNotFoundException) {
        // ...
    } catch (e: IOException) {
        // ...
    } catch (e: Exception) {
        // ...
    }
    //finally 區塊可以省略，如果有指定，則無論 catch 有無發生它都會被執行，它的用途通常是用來釋放資源，例如關閉檔案
    //catch 區塊也可以省略，但是無論如何，catch 或 finally 區塊至少要有一個存在。
    /** try-catch 區塊並不會終止程式，而是 try 區塊中發生例外那行程式碼之後的程式碼被跳過，
    改而執行 catch 區塊中的內容，而在 try-catch 區塊之後的程式碼依然會正常執行；相反地，
     如果發生例外時沒有 try-catch 區塊去補捉，整個程式就可能在此終止運行*/
    try_catch(a=11)
    try_catch(a=-1)
    println("-----------------")
/** 8.2.2 try 表達式 **/
// Kotlin 中，try-catch 可以是一個表達式，因此我們可以將其寫在 = 的右邊
    //如果將 s 變數轉換成整數發生例外錯誤，就給它 null，因此變數 d 的值不是整數就是 null
    val s = "SSS"
    val d: Int? = try { s.toInt() }
    catch (e: NumberFormatException) { null }
    //如果此例不使用表達式，我們將不得不把 b 變數以 var 來宣告
    val q = "QQQ"
    var b: Int?
    try {
        b = a.toInt()
    } catch (e: NumberFormatException) {
        b = null
    }
    //這樣寫的缺點是，b 變數是可變的，除非之後的程式碼需要更改 b 變數的值，
    //否則將會產生不必要的風險，請記住優先使用 val 宣告的準則。
/** 8.2.3 已檢查的例外 **/
//Kotlin 沒有「已檢查的例外」 (checked exceptions)。
/** 8.3 特殊的 Nothing 型別 **/
//throw 在 Kotlin 中可以是一個表達式，所以我們可以和貓王運算符號 ?: 搭配使用
    val aa1 = "A"
    //val bb1 = aa1.toIntOrNull() ?: throw NumberFormatException("Not a integer")
    //println(bb1)    // 只有在成功轉型成整數時才會執行以下這行
    /**throw 表達式是一個特殊的型別 Nothing，這個型別沒有值，而是用來標記此處的程式碼永遠無法到達。
    可以使用 Nothing 來標記一個函式永遠不會回傳任何東西。 */
    //val cc1 = aa1.toIntOrNull() ?: fail("Not a integer")
    //println(cc1)
    /** 「不會回傳的函式」和「沒有回傳值的函式」是不同的，沒有回傳值的函式實際上還是會回傳 Unit ，
    程式的運行會藉由回傳 Unit 這個動作來離開函式
    標記為 Nothing 回傳型別的函式則永遠也離不開此函式，當程式進入之後就終止了。*/
    demoNothing(1)

}
fun demoNothing(a: Int): String {
    TODO("這個函式還沒實作") //TODO() 函式可以用來做為待寫程式碼的標記，程式依然可以正常編譯，但是執行到 TODO() 函式時就會終止。
    // 雖然沒有 return 但不會出錯
    // 因為 TODO 的 Nothing 型別讓這一行成為黑洞
    println("123456")
}
fun fail(message: String): Nothing {
    throw Exception(message)
}
fun try_catch(a: Int){
    try {
        if (a <= 0) {
            throw Exception("這行之後會轉移到 catch 區塊")
            // println("這行永遠不會被執行")
        }
        println(" a > 0 ")
    } catch(e: Exception) {
        println("例外訊息: ${e.message}")
    }
    println("在區塊之後的程式碼繼續被執行")
}

fun <E> ArrayList<E>.swap(i: Int, j: Int) {  //對ArrayList擴充一個swap函式，<E> 是泛型。
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}
open class OAO {
    open fun hi() {       // 物件的方法
        println("Hi OAO")
    }
    fun call(){
        println("呼叫方法")
    }
}
class OuO : OAO() {       // 繼承OAO類別
    override fun hi() {   // 物件的方法
        println("Hi OuO")
    }
}
fun OAO.hello() {         //OAO類別的擴充函式
    println("Hello OAO")
}
fun OAO.call(){           //OAO型別的擴充函式
    println("呼叫擴充函式")
}
fun OAO.call(msg: String){  //多載：函式名稱相同，但參數不同
    println("$msg 呼叫擴充函式")
}
fun OuO.hello() {           //OuO 類別的擴充函式
    println("Hello OuO")
}
fun sayHello(a: OAO) {   //參數為 OAO 型別的函式 <== 注意它的型別
    a.hi()               //呼叫物件的方法
    a.hello()            //呼叫型別的擴充函式
}


