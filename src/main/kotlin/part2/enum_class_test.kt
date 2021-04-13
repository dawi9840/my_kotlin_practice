fun main() {
    /** for (day in DayOfTheWeek.values()) {
        //println("${day.ordinal}: ${day.name}")
        //println("Day ${day.ordinal}: ${day.name}")
    }
    for(point in BodyPart.values()){
        println("${point.name}, ${point.ordinal}")
    }*/
    /** val scores = intArrayOf(68, 90, 76, 88, 92)
    println("size: ${scores.size}")
    println("elements: ${scores.toList()}")*/
    /*val x:Any? = 1_000_000
    val y:Any? = 1000000
    println("x: $x")
    println("y: $y")*/

    /*val outputMap= HashMap<Int, Any>()
    val heatmaps = outputMap[0] as Array<Array<Array<FloatArray>>>
    val offsets = outputMap[1] as Array<Array<Array<FloatArray>>>

    val height = heatmaps[0].size
    val width = heatmaps[0][0].size
    val numKeypoints = heatmaps[0][0][0].size
    println(numKeypoints)*/

    /*val eatPointList = Array() { KeyPoint() }
    enumValues<BodyPart>().forEachIndexed { idx, it ->
        eatPointList[idx].bodyPart = it
    }*/
}
class persion(){

}
class KeyPoint {
    var bodyPart: BodyPart = BodyPart.NOSE
    var dayOfWeek: DayOfTheWeek = DayOfTheWeek.Sunday
    var yummy: Float = 0.0f
}
enum class DayOfTheWeek {
    Sunday,
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday
}
enum class BodyPart {
    NOSE,
    LEFT_EYE,
    RIGHT_EYE,
    LEFT_EAR,
    RIGHT_EAR,
    LEFT_SHOULDER,
    RIGHT_SHOULDER,
    LEFT_ELBOW,
    RIGHT_ELBOW,
    LEFT_WRIST,
    RIGHT_WRIST,
    LEFT_HIP,
    RIGHT_HIP,
    LEFT_KNEE,
    RIGHT_KNEE,
    LEFT_ANKLE,
    RIGHT_ANKLE
}