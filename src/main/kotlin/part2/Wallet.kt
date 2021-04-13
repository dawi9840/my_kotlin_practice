import java.math.BigDecimal
import java.time.LocalDateTime

class Wallet(_id: Long, _balance: BigDecimal, _createTime: LocalDateTime) {
    val id = _id
    val balance = _balance
    val createTime = _createTime
}
fun main() {
    val wallet = Wallet(9992233L, BigDecimal(200), LocalDateTime.now())

    println(wallet.balance)
    println(wallet.id)
}