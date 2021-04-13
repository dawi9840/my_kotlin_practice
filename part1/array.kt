package part1

fun main(){
    /*var scores = arrayListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17)
    for(nn in scores){
        println(scores[nn])
    }*/
    val array = arrayListOf("1", "2", "3", "4", "6", "77")
    val arrayCopy = array.toArray() // copy array to other array
    println("---> array: ${array?.count().toString()}" )
    println("---> arrayCopy: ${arrayCopy?.count().toString()}")
    println("------------------------------")
    array.removeAt(5) // remove first item in array

    println(array.take(5))
    println("---> array after remove: ${array?.count().toString()}")
    println("---> arrayCopy after remove: ${arrayCopy?.count().toString()}")
}