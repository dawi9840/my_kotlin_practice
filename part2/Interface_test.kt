interface Exportable {
    var exportLocation: String
    fun getFileName(): String
    fun getExportContent(): String
    fun getExportPath() = "$exportLocation\\${getFileName()}"
    fun printStatus() {
        println("輸出路徑：${getExportPath()}")
    }
}
interface DBEntity {
    fun isFieldValid(): Boolean
    fun printStatus() {
        println("屬性檢查通過：${isFieldValid()}")
    }
}
/** 介面繼承介面 **/
interface DBDocument : DBEntity, Exportable {
    val id: String

    override fun printStatus() {
        super<Exportable>.printStatus()
        super<DBEntity>.printStatus()
    }
}
//實作介面，與繼承類別最明顯的的差異，在於類別可以實作多個介面(Exportable 和 DBEntity)
class Product(val id: String, var name: String, var price: Int, var unit: String) : Exportable, DBEntity {
    override var exportLocation = "\\product"
    override fun getFileName() = "$id $name.txt"
    override fun getExportContent() ="$id\n$name\n單價：$price/$unit"
    override fun isFieldValid() = name.isNotEmpty() && price >= 0 && unit.isNotEmpty()
    override fun printStatus() {      //Exportable的getExportPath介面或父類別定義了相同的方法，那麼類別在同時繼承或實作時便會發生衝突
        println("物件狀態")            //類別中自行完成該方法。這樣主程式在呼叫時，才知道要執行什麼程式。
        super<Exportable>.printStatus() //在完成的過程中，如果有需要，也可以利用「super<>」語法來呼叫指定的方法。
        super<DBEntity>.printStatus()
    }
}
class Product2(override val id: String,
               var name: String,
               var price: Int,
               var unit: String) : DBDocument {
    // ˇˇˇˇˇ其餘省略ˇˇˇˇˇ
    override var exportLocation = "\\product"
    override fun getFileName() = "$id $name.txt"
    override fun getExportContent() ="$id\n$name\n單價：$price/$unit"
    override fun isFieldValid() = name.isNotEmpty() && price >= 0 && unit.isNotEmpty()
    // ^^^^^其餘省略^^^^^
    override fun printStatus() {
        println("物件狀態")
        super.printStatus()
    }
}
class Article(val id: String, var title: String, var content: String, var author: String) : Exportable {
    override var exportLocation = "\\article"
    override fun getFileName() = "$title-$author"
    override fun getExportContent() = "$title\n$content"
}
//宣告一個「exportFile」方法，它會接收一個可匯出檔案的物件參數，模擬輸出檔案的過程。
fun exportFile(item: Exportable) {
    println("${item.getExportPath()} 已經儲存！")
    println(item.getExportContent())
}

fun main() {
    val product = Product("A001", "巨人單行本第1集", 200, "本")
    //val article = Article("A001", "巨人 Kotlin教學系列", "幫助看過巨人的人上手該劇的劇情...", "Dawi")
    exportFile(product)
    //exportFile(article)
}