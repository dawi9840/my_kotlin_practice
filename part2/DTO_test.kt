data class DataTransferObject(val id: Int, var name: String, var age: Int, var phone: String)

data class DTO(var id: Int, var name: String, var age: Int){
    var phone: Int = 0
    constructor(id: Int, name: String, age: Int, phone: Int) : this(id, name, age) {
        this.phone = phone
    }
}
data class Human(val name: String) {
    var age: Int = 0
}
data class AA(val a: Int) {
    // 在資料類別內宣告的屬性，不會被用來產生相對應的程式碼
    var b: Int = 0
}

fun main(){
    /*val user1 = DataTransferObject(id=1, name="Tony", age=3, phone="aaappp123456")
    val user2 = DataTransferObject(1, "dawi", 20, "12d21213")
    println(user2.name)
    println(user1.phone)
    println(user1.age.toString())
    println("----------------------------------")
    val person1 = Human(name="John")
    val person2 = Human(name="BBB")
    person1.age = 10
    person2.age = 20
    println("person1 age: ${person1.age}")
    println("----------------------------------")
    val user3 = DTO(id=2, name="WoW", age=30, phone=97888)
    println(user3.name)
    println(user3.phone)
    println(user3.toString())
    val olderDog = user3.copy(name="Old_Wow", age=6)
    olderDog.phone = 666
    println(olderDog.name)
    println(olderDog.phone)
    println(olderDog.toString())
    println("----------------------------------")*/
    val a1 = AA(1)
    val a2 = AA(1)
    a1.b = 1
    a2.b = 2

    print("a1: ${a1.b}\n")
    print("a2: ${a2.b}\n")

    println(a1.toString())
    println(a2.toString())

    println(a1 == a2)
    println(a1.b == a2.b)
}
