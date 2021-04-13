fun main(){
    /** 7.1 函式型別 **/
    //使用函式型別 (Int) -> String 宣告一個變數
    //指派給它一個符合該函式型別的匿名函式
    //fun (n: Int): String 必須符合 (Int) -> String 函式型別
    val a: (Int) -> String = fun (n: Int): String {
        return "Number is $n"
    }
    //println(a(9487))
    /** 7.1.1 實體化函式型別 **/
    //要實體化一個函式型別有 3 種方式：
    //1.使用程式碼區塊:
        //使用匿名函式，例：fun(n: Int): String = "Number is $n"
        //使用 Lambda 表達式，例：{ a, b -> a + b }
    //2.使用可呼叫的參考:
        //函式參考，例：::isOdd、String::toInt
        //屬性參考，例：List<Int>::size
        //建構式參考，例：::User
    //3.使用實作函式型別介面的自訂類別的實體 (即物件)
    /** 實體化函式型別 example **/
    println("-----匿名函式--------") // 匿名函式
    val anonymousFunShowString:(Int) -> String = fun (n: Int): String = "Number is $n"
    println("show string: ${anonymousFunShowString(9487)}")

    println("-----Lambda 表達式--------") // Lambda 表達式
    val lambdaAdd: (Int, Int) -> Int = { m, n -> m + n }
    println("1 + 1 = ${lambdaAdd(1, 1)}")

    println("-----函式參考--------") // 函式參考 (toInt 是一個函式)
    val referenceFun: (String) -> Int = String::toInt
    println(referenceFun("9487"))

    println("-----屬性參考--------") // 屬性參考 (size 是一個屬性)
    val referenceAttr : (List<Int>) -> Int = List<Int>::size
    println("List size: ${referenceAttr(listOf(1, 2, 3, 4, 7, 9))}")

    val aaa = TestName(name="ABCD")
    println("-----建構式參考--------")
    // 建構式參考 (TestName 是一個類別)
    val bbb: (String) ->TestName =::TestName
    println("aaa: ${aaa.name}, age: ${aaa.age}")
    println("bbb: ${bbb("ABCD").name}, age: ${bbb("ABCD").age}")

    println("-----實作函式型別介面的物件--------")
    val dog= FruitS()   // 實作函式型別介面的物件 FruitS
    println(dog(10))
    println(dog.invoke(11))
    println(dog.printApple(12))
    println("----------------------------------")
    val pig: (Int) -> String = FruitS()
    println(pig(6))
    println(pig.invoke(7))
    println((pig as FruitS).printApple(8))
}
data class TestName(val name: String = "OAO"){
    var age: Int = 0
}
class FruitS : (Int) -> String {
    override fun invoke(n: Int): String = "$n bananas"
    fun printApple(n: Int):String = "$n apples"
}