package part1

class TestA {
    val a = 20
    fun bb(){ println("testA") }
}
object TestB {
    const val a = 20
    fun bb() { println("testB") }
}
class TestC {
    companion object{
        const val a = 20
        fun bb() { println("testC") }
    }
}
class TestD(var a:Int){
    init{
        a = 20
    }
    fun bb() { println("testD") }
}
fun main(){
    /*TestD(30).bb()
    println(TestD(10).toString())*/

    TestA().bb()
    println(TestA().a)

    TestB.bb()
    println(TestB.a)

    TestC.bb()
    println(TestC.a)
}