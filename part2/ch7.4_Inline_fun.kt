/** 7.4 行內函式 **/
//7.4.1 何時使用行內函式
//高階函式雖然能讓程式架構變得靈活，
//但是有個小缺點，由於每一個高階函式都是一個物件，
//而且會因為和外部變數產生關聯而形成閉包，因此在執行時會有額外的效能損耗。
//對於函式物件和類別的記憶體分配及虛擬呼叫，也會增加額外的執行時間。

//為了解決這個問題，提供了行內函式 (Inline Functions)，它會將 Lambda 表達式「行內化」
//也就是將 Lambda 表達式替換成函式的內容，而不是透過呼叫的方式
//簡單的說，就是編譯器會幫我們把行內函式的程式碼複製貼上到原本的 Lambda 表達式的地方

public inline fun println(message: Int) { /** 這是 Kotlin 原始碼其中的一段程式 **/
    System.out.println(message)
}
fun main(){
    println(1)         //這麼使用它
    println(2)
    /** 編譯後會變這樣
    System.out.println(1)
    System.out.println(2) **/
    //要將函式「行內化」只要在函式前面加上 inline 修飾字即可。
    //inline 修飾字會影響高階函式本身和傳給它的 Lambda 表達式，所有的內容都將複製一份到呼叫它的地方。
    //如果過度使用行內函式會導致程式碼增加，尤其是在迴圈中，程式碼的行數將隨著迴圈數增加。

}
/** 7.4.2 禁止使用行內函式 **/
//如果只想要部分參數使用行內函式，其他要禁止使用，可以使用 noinline 修飾字標記要禁止的函式
// 參數 g 禁止使用行內函式
inline fun ppp(f: () -> Unit, noinline g: () -> Unit) {
    // ...
}


