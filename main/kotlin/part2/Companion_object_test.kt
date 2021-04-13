package part2

class Candy{
    companion object MyObjec{
        const val a = 20
        fun chocolate() {
            println("chocolate!")
        }
    }
}
fun main(){
    Candy.chocolate()
    println(Candy.a)
}