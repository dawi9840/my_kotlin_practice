class New_User(val name: String = "deafult people name", private var age: Int = 0) {
    //private，就能限制這個屬性被外界「看到或存取」，省略時預設為 public 表示外界的其他物件能夠看到這個屬性
    init {
        if (age < 0) {
            age = 0
        }
    }
    fun showName(){
        println("Name: $name")
    }
    fun showAge(){
        println("Name: $age")
    }
    fun showInfo() {
        println("Name: $name, Age: $age")
    }
}
class User2(private val name: String) {
    //只能在主要建構式中使用 val 或 var 將參數宣告為屬性，在次要建構式中無法這麼做。
    init {
        println("Init: $name")
    }
    // 委派主要建構式
    constructor(name: String, age: Int) : this(name) {
        println("$name, $age")
    }
    // 委派另一個次要建構式
    constructor(name: String, age: Int, email: String) : this(name, age) {
        println("$name, $age, $email")
    }
}

/** Java 的類別預設是可以被任何類別繼承，除非宣告為 final；
    Kotlin 則相反，預設不能被繼承，除非指定為 open **/
/***** 6.2繼承 example1 *****/
open class Fruit
class Apple : Fruit()                //子類別：預設建構式
class Banana(price: Int) : Fruit()   //子類別：一個參數的建構式
/***** 繼承 example2 *****/
open class Usr(name: String)            // 父類別：一個參數的建構式
class Guest(name: String) : Usr(name)   // 子類別：一個參數的建構式
//class Admin : User(name) <== 錯誤     // 子類別：無法使用預設(空參數)建構式
/***** 繼承 example3 *****/
open class Employee() {                 // 父類別：無參數的主要建構式、兩個次要建構式
    constructor(level: Int) : this() {}
    constructor(level: Int, salary: Int) : this(level) {}
}
class Boss(): Employee()                                           // 子類別：使用無參數的建構式
class Operator(level: Int) : Employee(level)                       // 子類別：使用一個參數的建構式
class Manager(level: Int, salary: Int) : Employee(level, salary)   // 子類別：使用兩個參數的建構式
/***** 繼承example4 *****/
open class Original_user {     // 父類別
    init {
        println("Init Original_user")
    }
}
class A_guest() : Original_user() {   // 子類別
    init {
        println("Init A_guest")
    }
}
/** my test **/
open class Animal(name: String){
    val name:String = name
}
class Tiger(name: String) : Animal(name)

/** 6.2.1 覆寫方法1 **/
open class Shape {
    open fun draw() { /*……*/ }       //kotlin預設是final所以用open才能被覆寫
    fun fill() { /*……*/ }
}
class CircleA(i: Int) : Shape() {
    override fun draw() { /*……*/ }
}
/** 複寫2 **/
open class A {
    open fun a() {}             // 可以被子類別覆寫
}
open class B : A() {
    final override fun a() {}   // 禁止子類別覆寫
}
class C : B() {
    // override fun a() {}      <== 無法覆寫
}
/** 6.2.2 覆寫屬性1 **/
//覆寫屬性的規則和覆寫方法相同，但是必須注意以同一種資料型態來覆寫
//以 val 宣告的屬性可以被 var 覆寫，但反過來就不行
open class User123 {
    open val name: String = "" // 以 val 宣告
    open var age: Int = 5      // 以 var 宣告
}
class Guest123 : User123() {
    override var name: String = ""  // 可以 var 覆寫
    //override val age: Int = 5     // 無法以 val 覆寫
    override var age: Int = 5       // 只能以 var 覆寫
}
/** 6.2.2 覆寫屬性2 **/
//主要建構式中宣告的屬性也可以被覆寫
open class User321(open val name: String) {
    // ...
}
class Guest321(override val name: String) : User321(name) {
    // ...
}
/** my test **/
open class Animal2(open val name: String){
    var age: Int = 0
    constructor(name: String, age: Int) : this(name) {
        this.age = age
    }
    open fun eat(){
        println("eat something")
    }
}
class Tiger2(override val name: String) : Animal2(name)
class Tiger3: Animal2 {
    constructor(name: String) : super(name)
    constructor(name: String, age: Int) : super(name, age)
    override fun eat(){      //如果有final, 其他想覆寫吃素的老虎類別無法覆寫
        println("EEat meat")
    }
}
/** 初始化順序 **/
open class Base(val name: String) {
    init {
        println("Initializing Base")
    }
    open val size: Int = name.length.also { println("Initializing size in Base: $it") }
}
class Derived(name: String, val lastName: String) : Base(name.capitalize().also { println("Argument for Base: $it") }) {
    init {
        println("Initializing Derived")
    }
    override val size: Int = (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

fun main(){
    /*New_User("Dawi", 20).showInfo()
    New_User("Dawi", -2).showInfo()
    New_User().showInfo()*/
    //User2("dawi")
    //User2("dawi", 20)
    //User2("dawi", 20, "dawi@gmail.com")
    /*val user_user = New_User("dawi", 20)    //6.1.3 建立類別實體
    val user_user2 = New_User("PPAP", 18)   //6.1.3 建立類別實體
    user_user.showName()
    user_user2.showAge()*/
    //A_guest() //繼承可以看成是子類別呼叫父類別的建構式然後才實體化自己，因此父類別中如果有初始化區塊，將會優先被執行
    val tiger_one = Tiger("PPAP pig")
    println(tiger_one.name)

    val tiger_two = Tiger2("pig")
    val tiger_three = Animal2("dog", 20)
    println(tiger_two.name)
    println(tiger_three.age)

    val tiger_test1 = Tiger3("PPAP dog")
    val tiger_test = Tiger3("dog", 20)
    println("Name: ${tiger_test1.name}")
    println("animal name: ${tiger_test.name}, Age: ${tiger_test.age}")
    tiger_test.eat()
    println("*****************")
    val d = Derived("ddawi", "Lu")

}



