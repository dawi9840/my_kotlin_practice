class Person {
    var name: String = "defaultValue"
}
class Person2 {
    var name: String = "defaultValue"

        // getter
        get() = field

        // setter
        set(value) {
            field = value
        }
}
fun main(){
    val pp1 = Person()
    val pp2 = Person2()

    pp1.name = "jack"
    pp2.name = "Jackk"

    println("pp1's name: ${pp1.name}")
    println("pp2's name: ${pp2.name}")
}