package part2

fun main(){
    val numKeypoints = 9
    val keypointPositions = Array(numKeypoints) { Pair(0, 0) }
    keypointPositions[5] = Pair(10, 11)
    println(keypointPositions[5] )
}