abstract class TTT(name:String) {
    init {
        println("My name is $name.")
    }
    fun displayThreat(threat: Int) {
        println("Threat level: $threat")
    }
    // 抽象屬性
    abstract val a: Int
    // 抽象方法
    abstract fun quotes()
    abstract fun displayJob(description: String)
    // 一般屬性
    val c: String = "C"
    // 一般方法
    fun d() {
        println("D")
    }
}
class Wisdom(name: String): TTT(name){
    override val a: Int = 1      // 覆寫抽象屬性
    override fun quotes() {
        println("I don't have time to worried if it's right or wrong, you can't hope for a horror story with a happy ending.")
    }
    override fun displayJob(description: String) {
        println(description)
    }
}
class Brainless(name: String): TTT(name){
    override val a: Int = 1      // 覆寫抽象屬性
    override fun quotes() {
        println("WTF! Zeke Yeager!")
    }
    override fun displayJob(description: String) {
        println(description)
    }
}
// 因為沒有覆寫全部的抽象成員，必須也宣告為抽象類別
abstract class Teest(name: String) : TTT(name) {
    override val a: Int = 1321        // 覆寫抽象屬性
}
class T1(name: String):Teest(name){
    override val a: Int = 9487941
    override fun quotes(){
        println("pppp")
    }
    override fun displayJob(description: String) {
        println(description)
    }
}
fun main(){
    val eren = Wisdom("Eren Yeager")
    eren.displayJob("Attack Titan, is a one of the Nine Wisdom Titan. ")
    eren.quotes()
    eren.displayThreat(999)
    val springer = Brainless("Connie Springer")
    springer.displayJob("I was transformed into a Brainless Titan by Zeke.")
    springer.quotes()
    springer.displayThreat(30)
    val myTestLa = T1("Test der la")
    println("phone number: ${myTestLa.a}")
}



/*
Founding, 始祖の巨人
Attack, 進撃の巨人
Colossus, 超大型巨人
Armored, 鎧の巨人
Female, 女型の巨人
Beast, 獣の巨人
Jaw, 顎の巨人
Cart, 車力の巨人
WarHammer, 戦槌の巨人
*/