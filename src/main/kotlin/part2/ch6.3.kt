/** 6.3 抽象類別 **/
//抽象類別中的屬性必須給初始值，否則就必須宣告為抽象屬性。
//方法必須有實作內容，否則就必須宣告為抽象方法。
//一個類別中，只要有一個抽象成員存在，該類別就必須宣告為抽象類別。
//抽象類別無法實體化，只能被其他類別繼承，繼承抽象類別的子類別必須覆寫所有抽象成員，否則就必須把自己也宣告為抽象類別。
/** 類別繼承介面 **/
//定義介面
interface MyInterface {
    fun functionA()
}
interface MyInterface2 {
    fun functionA2()
}
//由類別繼承介面
class MyClass: MyInterface, MyInterface2{
    override fun functionA() {
    }
    override fun functionA2() {
    }
}
/** 6.4 介面 **/
interface GGG {
    val height: Int            //抽象屬性
    /** val a: Int = 1       <== 不能初始化 **/
    val b: String             //可以實作 getter
        get() = ""
    fun c()                  //抽象方法：無實作內容
    fun d() {                //可以有實作內容
        println("D")
    }

    //my try
    fun getTitanName()
    fun getAbility()
}
/** 6.4.1 實作介面 **/
class NormalBrainless : GGG {
    override val height: Int = 3     // 必須實作
    override val b: String = "B"     // 依需求覆寫
    override fun c() {    // 必須實作
        println("eat people")
    }
    override fun d() {    // 依需求覆寫
        println("DD")
    }
    override fun getTitanName() {
        println("Eren Yeager")
    }
    override fun getAbility() {
        println("穿越過去，間接影響未來")
    }
}

//my test
interface ISurfaceArea{
    //定義Interface及計算面積的方法area()
    fun area() :Double
}
class Circle(private val radius:Double) : ISurfaceArea{
    //圓形類別繼承ISurfaceArea介面，實作area計算面積的方法
    //實作計算面積
    override fun area() :Double {
        return radius * radius * 3.14
    }
}
class Rectangle(private val width:Double, private val height:Double) : ISurfaceArea{
    //矩形類別繼承ISurfaceArea介面，實作area計算面積的方法
    //實作計算面積
    override fun area() :Double{
        return width * height
    }
}
fun main(){
    val apple = Circle(5.2)
    println("Apple's area: ${apple.area()} square meters.")

    val s1 = NormalBrainless()
    println("s1's height: ${s1.height} meters")
}




