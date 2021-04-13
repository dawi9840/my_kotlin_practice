package part2

abstract class Titan(name:String) {
    init {
        println("Name: $name.")
    }
    fun threatLevel(threat: Int) {
        println("Threat: Lv.$threat")
    }
    abstract fun quotes()
    abstract fun describeJob(description: String)
}
interface GiantPower {
    val height: Int
    fun action() {
        println("Default: can eat people.")
    }
}
class AttackTitan(name: String): Titan(name), GiantPower{
    override fun quotes() {
        println("Quite: Keep going for freedom!")
    }
    override fun describeJob(description: String) {
        println(description)
    }
    override val height: Int = 15
    override fun action() {
        println("Ability: Can receive memories from the future as well as the past.")
    }
}
class NormalBrainlessTitan(name: String): Titan(name), GiantPower {
    override fun quotes() {
        println("Quite: WTF! Zeke Yeager!")
    }
    override fun describeJob(description: String) {
        println(description)
    }
    override val height: Int = 3
    override fun action() {
        println("Ability: Have no thinking and eat people.")
    }
}
fun main(){
    println("----------------------------------------")
    val eren = AttackTitan(name="Eren Yeager")
    eren.threatLevel(threat=999)
    println("Height: ${eren.height} meters.")
    eren.describeJob(description="Describe: Attack Titan, is a one of the Nine Wisdom Titan.")
    eren.action()
    eren.quotes()
    println("----------------------------------------")
    val springer = NormalBrainlessTitan(name="Ms. Springer")
    springer.threatLevel(threat=30)
    println("Height: ${springer.height} meters.")
    springer.describeJob(description="Describe: She was transformed into a Brainless Titan by Zeke.")
    springer.action()
    springer.quotes()
    println("----------------------------------------")
}