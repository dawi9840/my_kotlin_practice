import kotlin.math.log10

fun main(){
    val waistCircumferenceCM: Float = 86F
    val neckCircumferenceCM: Float = 32.9F
    val bodyHeightCM:Float = 171F
    val bodyHeight:Float = bodyHeightCM/100
    val bodyWeightKG: Float = 66F
    val age:Int = 26
    val gender:Int = 1 //1:male, 0:female
    val BMI:Float = bodyMassIndex(bodyWeightKG, bodyHeight)
    val HipsCM:Float = 0F //0:male, otherwise is famale
    println("Dawi's BMI: $BMI")
    println("Dawi's wiki BF: ${bodyFatPercentageWikiFormula(BMI, age, gender)}")
    println("Dawi's BF1: ${bodyFatPercentageFormula1(BMI, age, gender)}")
    println("Dawi's BF2: ${bodyFatPercentageFormula2(BMI, age, gender)}")
    val USBF:Double = bodyFatPercentageNavyMethod(
        BMI,
        age,
        gender,
        HipsCM,
        waistCircumferenceCM,
        neckCircumferenceCM,
        bodyHeightCM)
    println("Dawi's U.S. Navy Method BF: $USBF")
}

fun bodyMassIndex(w: Float, h: Float): Float {
    return w / (h * h)
}
fun bodyFatPercentageWikiFormula(BMI:Float, age: Int, gender:Int): Double{
    return (1.2 * BMI) + (0.23 * age.toFloat() - 5.4) - (10.8 * gender.toFloat())
}
fun bodyFatPercentageFormula1(BMI:Float, age: Int, gender:Int): Double {
    val a:Float = if(gender==1) 16.2F else 5.4F
    return (1.2 * BMI) + (0.23 * age.toFloat()) - a
}
fun bodyFatPercentageFormula2(BMI:Float, age: Int, gender:Int):Double {
    var a:Float = 0F
    when(gender){
        1 -> a = 19.34F
        0 -> a = 9.0F
        else ->{
            print("Gender is neither male nor female.")
        }
    }
    return (1.39 * BMI) + (0.16 * age.toFloat()) - a
}
fun bodyFatPercentageNavyMethod(BMI:Float, age: Int, gender:Int, Hips:Float, waist:Float, neck:Float, hCM:Float):Double{
    //U.S. Navy Method
    //公式、單位有問題待改
    val Hips = if(gender==0) Hips else 0F
    return 495 / (1.29579 - .35004 * log10(waist + Hips - neck) + 0.22100 * log10(hCM)) - 450
}