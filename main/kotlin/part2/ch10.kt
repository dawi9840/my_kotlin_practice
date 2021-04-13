fun main(){
/** 10.1 Pair 及 Triple **/
//在某些情況下，需要將兩個或三個資料結合成一組來傳遞，
//這些資料一般來說沒有什麼相關性或只是為了暫時傳遞使用
//Kotlin 標準庫提供兩個資料類別讓我們方便結合資料，兩個一組用 Pair ，三個一組用 Triple。
    /*val myPlusA = myPlus(9, 2)                                // 使用屬性
    println("${myPlusA.first}${myPlusA.second}")
    val (textA, resultA) = myPlus(2, 3)                       // 使用解構式
    println("$textA$resultA")
    val b = myPlus(1, 2, 3)                                // 使用屬性
    println("${b.first}${b.second} (${b.third})")
    val (textB, resultB, isPositiveB) = myPlus(4, 5, 6)    // 使用解構式
    println("$textB$resultB ($isPositiveB)")*/
/** 10.2.1 Data Classes 的解構式宣告 **/
//宣告 data class 時，編譯器會幫我們產生和屬性相對應的 componentN() 函式，
//這些函式可以用來存取屬性，也可以被用在解構式宣告中
    /*val userA = dataClassUser(id=1, name="Dawi", age=30)
    println("${userA.id}, ${userA.name}, ${userA.age}")  //使用屬性時會這麼寫
    //Kotlin 編譯時自動建立了 componentN() 方法，依序對應到屬性(示範用，實務上不要這麼寫)
    println("${userA.component1()}, " + "${userA.component2()}, " + "${userA.component3()}")
    // 使用解構式宣告時會自動呼叫對應的 componentN() 方法
    val (id, name, age) = userA
    println("$id, $name, $age")******/
    /** 上面這行其實編譯器幫我們做了以下的事
     val id = user.component1()
     val name = user.component2()
     val age = user.component3() **/
    /*實務上常在集合中使用，當疊代集合時，可以使用解構式宣告讓存取屬性的動作方便一些*/
    /*val users = listOf(
        dataClassUser(1, "Dawi", 25),
        dataClassUser(2, "John", 39),
        dataClassUser(3, "Tiffany", 18)
    )
    println("一般寫法: ")
    for (a in users) {
        println("${a.id}, ${a.name}, ${a.age}")
    }
    println("使用解構式宣告: ")
    for ((id, name, age) in users) {
        println("$id, $name, $age")
    }
    //任何可以呼叫 componentN() 函式的項目都能使用解構式宣告，例如函式回傳值:
    println("直接把回傳值解構來建立變數: ")
    val (id, name, age) = makeUser()
    println("$id, $name, $age")
    println("----------------")*/
/** 10.2.2 Map 集合的解構式宣告 **/
//Map 集合的項目由一組鍵值對 (key-value) 表示，每個項目可以解構成兩個變數，一個表示 key、一個表示 value
    /*val mapA = mapOf(1 to "Tony", 2 to "Dawi", 3 to "Tiffany")
    // 解構式宣告
    for ((id, name) in mapA) {    // 這裡的 id, name 變數名稱是我們付予它的意義
        println("$id, $name")     // 在原始 Map 集合中並沒有表明 key-value 是什麼
    }
    println("-----------")*/
/** 10.2.3 在 Lambda 表達式中使用解構式 **/
//Lambda 表達式的參數如果是資料類別或 Map 集合，也可以直接使用解構式
    /*val valA = mapOf(1 to "Tommy", 2 to "TomG", 3 to "Tiffany")
    // 在 Lambda 中使用預設參數，參數的意義不明
    valA.forEach { println("${it.key}, ${it.value}") }
    println("::::::::::::::")
    //在 Lambda 中直接解構，必須以括號包圍，否則會視為參數
    valA.forEach { (id, name) -> println("$id, $name") }
    println("::::::::::::::")
    //沒有使用括號會視為參數的名稱
    valA.forEach { usr -> println("${usr.key}, ${usr.value}") }
/** 10.2.4 針對用不到的變數使用底線 **/
//如果我們在使用解構式宣告時，有些屬性用不到想要忽略，可以使用底線 _ 來略過它們
    val (_, name, _) = makeUser()
    println("$name")*/
/** 10.3 範圍函式 **/
//在物件上使用 Lambda 表達式來呼叫[執行區塊 (block) 裡的程式]函式時，
//它能將物件的脈絡資訊 (context) 限制在這個區塊裡，
//形成暫時的範圍 (scope) 而不受外界影響，在這個範圍裡，
//我們可以存取該物件的屬性及方法，這類函式被稱為範圍函式 (Scope Functions)，
//總共有五個：let 、 run 、 with 、 apply 和 also ，
//這五個函式定義在 Any 類別中，屬於擴充函式，
//因為 Any 類別是所有類別的根類別，因此所有類別都能使用範圍函式。
    /*val vehicle = Car(10)  //一般寫法
    println("Gas: $vehicle")
    vehicle.move()
    vehicle.move()
    println("Gas: $vehicle")
    println(":::使用範圍函式:::")
    Car(10).let {
        println("Gas: $it")
        it.move()
        it.move()
        println("Gas: $it")
    }*/
/** 10.3.1 範圍函式的區別 **/
//範圍函式主要有兩個區別：
//1.物件的脈絡資訊 (context) 的引用方式
//2.回傳的結果值
/** 10.3.1.1 物件的脈絡資訊：this 或 it**/
//在範圍函式裡，可以透過物件的脈絡資訊來參考到該物件，
//主要有兩種引用方式，一種是接收者 this ，即物件本身，
//另一種是 Lambda 表達式的預設參數 it ，這兩種引用方式都是指向物件本身，
//只是使用上有些不同，所以要使用哪一個可以依情況做決定。
    /*val helloA = "Hello, aloha!"
    // run 使用 this
    helloA.run {
        val l = this.length
        println("run: $l")
        println("run: $length") // this 可省略
    }
    // let 使用 it
    helloA.let {
        val l = it.length
        println("let: $l")
    }*/
//this: 參考到接收者脈絡資訊的函式有 run、with 和 apply 三個。
//Lambda 表達式中可以省略 this 關鍵字，它指向該物件 (接收者) 本身
//雖然可以讓程式碼更簡潔一些，但是卻不容易和外部物件或函式做出區別，
//因為這個原因，通常我們只會在存取物件的成員時才會用這三個範圍函式。
    /*val aUser = dataClassUser(1, "Dawi", 5)       //1.一般宣告物件時最常用的寫法，但是不清楚參數的意義
    val bUser = dataClassUser(id=1, name="Bob", age=5)          //2.可以加上參數名稱，但變得太長不易閱讀
    val cUser = dataClassUser(                                  // 3.某些情況下會調整成這樣
        id=1,
        name="Tom Cat",
        age=5
    )
    val dUser = dataClassUser(id=1).apply {                      // 4.範圍函式可以解決這個問題
        name = "Jerry Mouse"
        age = 5
    }*/
//it: 以Lambda表達式的預設參數做為物件的脈絡資訊，此類範圍函式有 let 和 also 兩個。
//在 Lambda 表達式中，物件的參考會以預設的參數名稱 it 來表示，它非常適合用在呼叫其他函式時傳遞參數。
    //一般寫法
    /*val randomA = (1..10).random()
    log("random number: $randomA")
    //使用範圍函式
    val randomB = (1..10).random().also { log("random number: $it") }
    //如果不想用預設的 it，也可以自定名稱
    val randomC = (1..10).random().also { number -> log("random number: $number") }*/
/** 10.3.1.2 回傳值 **/
//範圍函式的另一個不同之處在於回傳值：
//1.apply 和 also 回傳脈絡資訊物件
//2.let、run 和 with 回傳 Lambda 表達式的運算結果
    /** 脈絡資訊物件(Context object):
    apply 和 also 回傳的是Context object，也就是接收者即物件本身，
    因此它可以串在函式的呼叫鏈中，讓下個函式來使用**/
    //Context object example
    /*val contextObjA = mutableListOf<Int>()
        .also { log("Creating random number list") }
        .apply { repeat(5) { add((1..10).random()) } }//repeat(5):加入 5 個範圍 1~10 的亂數，省略 this，實際為 this.add()
        .also { log("Sorting the list") }.sorted()
        .apply { println(this) }

    makeRandomInt1() //利用 also 函式回傳物件本身這個特性，
    makeRandomInt2() //做到執行運算並同時記錄到 log 的功能
    */
    /** Lambda 表達式運算的結果 **/
    //let、run 和 with 會回傳 Lambda 表達式運算的結果，所以可以用來指派給變數，或是函式的呼叫鏈
    val mutListA = mutableListOf<Int>()
    val countEven = mutListA.run {
        repeat(5) { add((1..10).random()) }
        // 計算集合中的偶數有幾個，寫在區塊中最後一行表示為回傳值
        count { it % 2 == 0 }
    }
    println(mutListA)
    println(countEven)
    //可以使用範圍函式來建立一個暫時性的變數存在範圍 (即區域變數)，這些變數只會存在這個範圍中，不會影響到外面的程式碼
    val tmpA = listOf("Jerry", "Tom", "Tiffany", "Andy", "Bob")
    with(tmpA) {
        val nameFirst = first { it.startsWith("T") }
        val nameLast = last { it.startsWith("T") }
        println("first is $nameFirst, last is $nameLast")
    }
/** 10.3.2 如何選擇 **/
//範圍函式不是必要使用的函式，不使用範圍函式依然能讓程式碼正常執行，
//但是如果使用的好，能夠讓程式碼更加結構化、更加易讀及維護
//選擇時，朝這些條件來決定使用哪一個，以下列出幾個選擇的條件：
/** 1.在非 null 的物件中執行 Lambda：let
    2.藉由 Lambda 表達式將變數的生存範圍表示為區域變數：let
    3.物件的設定：apply
    4.物件的設定並且計算結果值：run
    5.在需要使用 Lambda 表達式來執行敍述的地方，以非擴充函式的方式：run
    6.加入額外的動作：also
    7.群組化呼叫物件的成員：with **/
/***************範圍函式比較表***************/
/**範圍函式	資訊脈絡物件	回傳值	    是否以擴充函式表示
    let	    it	        運算結果	        是
    with	this	    運算結果	        否：資訊脈絡物件以參數的方式傳入
    run	    this	    運算結果	        是
    run	    -	        運算結果	        否：無資訊脈絡物件
    apply	this	    資訊脈絡物件	    是
    also	it	        資訊脈絡物件	    是    **/
//with 和 run 可以是獨立區塊，而不以擴充函式表示，其他範圍函式以擴充函式表示時，前面會有接收者。
}
// .also完整寫法
fun makeRandomInt1(): Int {
    return (1..10).random().also {
        log("random number: $it")
    }
}
// .also極簡寫法
fun makeRandomInt2() = (1..10).random().also {
    log("random number: $it")
}
fun log(msg: String) {
    println("INFO: $msg")
}
data class Car(private var gas: Int) {
    fun move() {
        gas -= 1
    }
}
data class dataClassUser(
    var id: Int = 0,
    var name: String = "",
    var age: Int = 0
)
fun makeUser(): dataClassUser {
    return dataClassUser(1, "Bob", 5)
}
fun myPlus(a: Int, b: Int): Pair<String, Int> {
    //為了區隔內建的 plus 函式，這裡故意命名為 myPlus
    val result = a + b
    val text = "$a + $b = "
    return Pair(text, result)
}
fun myPlus(a: Int, b: Int, c: Int): Triple<String, Int, Boolean> {
    val result = a + b + c
    val text = "$a + $b + $c = "
    val isPositive = (result >= 0)
    return Triple(text, result, isPositive)
}



