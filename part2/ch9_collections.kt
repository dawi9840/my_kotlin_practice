package part2

fun main(){
/** 9.1.1 集合的類型 **/
    /*val a1 = listOf(1, 2, 3)        // 唯讀的 List
    val a2 = mutableListOf(1, 2, 3) // 可變的 List
    a2.add(4)               // 增加
    a2.remove(1)    // 刪除
    a2[0] = 9               // 改變值
    println(a1)
    println(a2)
    println("----------------")
    //當我們用 a1a.toMutableList() 轉換時，會得到一個新集合物件，
    //接著的 add(4) 是對這個新集合做動作，原本的 a1a 並沒有更動。
    val a1a = listOf(1, 2, 3)
    a1a.toMutableList().add(4)
    println(a1)

    //優先使用 val 宣告，如果我們只是單純想換掉集合中的內容，不應該使用變數 b 的方式，而應該使用可變動的集合
    val c = mutableListOf(1, 2, 3)
    c.clear()
    c.addAll(listOf(4, 5, 6))
    println(c)
    println("---------------")*/
/** 9.1.2 List **/
//Array (陣列) 和 List 在各方面都很像，但是有一個重大的差別在於，
//Array 在宣告時就決定了項目的數量，之後就無法變動；
//可變動的 List 則沒有這個限制，它可以動態改變項目的數量。
//Kotlin 對 List 的實作預設為 ArrayList ，可以將其視為可以改變容量的陣列。
    /*val s1: List<String> = listOf<String>("a", "b", "c")   // 唯讀 List
    val s2 = listOf("a", "b", "c")     // 簡寫
    //s1[0] = "d"                      <== 無法更動項目內容
    val s3 = mutableListOf("a", "b", "c")     // 可變動 List
    s3[0] = "d"
    //println("s2: $s2\n, s3: $s3")
    // 或是這樣也可以，arrayListOf 回傳 ArrayList，而 ArrayList 實作 MutableList
    val s4 = arrayListOf("a", "b", "c")
    s4[0] = "d"
    //println("s4: $s4")

    //兩個 List 集合只要項目數量及同一位置的內容是一樣的，等式比較就成立
    val ss1 = listOf("a", "b", "c")
    val ss2 = mutableListOf("a", "b")
    println(ss1 == ss2)
    ss2.add("c")
    println(ss1 == ss2)
    println("---------------")*/
/** 9.1.3 Set **/
//Set 和 List 的差別在於集合中的項目沒有順序的概念，
//因此沒有 getter/setter 讓我們透過索引值來存取項目
    /*val setA = mutableSetOf<String?>("a", "b", "c")
    //它的所有項目都是唯一的，也就是不會有任何項目是重覆的，null 也只會有一個
    setA.add("d")
    setA.add("a")
    setA.add("a")
    setA.add(null)
    setA.add(null)
    setA.add(null)
    println(setA)
    //因為 Set 不在乎順序，所以在比較兩個 Set 集合是否相等時，只會在乎集合的數量及項目的內容是否相等，而忽略項目的順序
    val aA = setOf("a", "b", "c")
    val bB = setOf("c", "a", "b")
    println("aA == bB: ${aA == bB}\n")
    //MutableSet 是在 Set 之上加入可以修改集合的功能
    val mutaA = mutableSetOf("a", "b")
    println(mutaA.first())    // a
    println(mutaA.last())     // b
    println("mutaA: ${mutaA}")
    mutaA.add("c")
    println("add: ${mutaA.last()}")    // c
    println("mutaA: ${mutaA}")
    mutaA.add("d")
    println("add: ${mutaA.last()}")    // d
    println("mutaA: ${mutaA}")
    //另外一個可替代的實作為 HashSet ，它不會保留項目插入時的順序，
    //所以當我們呼叫 first() 或 last() 時得到的結果是不可預期的，它的優點在於使用的記憶體較少
    val HashSetA = mutableSetOf("a", "b", "d").toHashSet()
    val HashSetB = hashSetOf("a", "b", "d")       // 或
    println("HashSetA: ${HashSetA}, HashSetB: ${HashSetB}")
    println("HashSetA first: ${HashSetA.first()}, HashSetB first: ${HashSetB.first()}")
    println("HashSetA last: ${HashSetA.last()}, HashSetB last: ${HashSetB.last()}")
    println("-------------")*/
/** 9.1.4 Map **/
//Map 並沒有實作 Collection 介面，但它仍被歸類為集合。
//Map 儲存的項目為鍵值對 (key-value pairs) ，鍵 (key) 在一個 Map 集合中是唯一的，但是不同的鍵可以有相同的值。
//Kotlin 的 Map 項目建立方式和其他程式語言有點不一樣，它使用符號 to 來結合鍵和值。
    /*val map: Map<String, Int> = mapOf<String, Int>("a" to 1, "b" to 2, "c" to 3) // 完整寫法
    val mapA = mapOf("a" to 1, "b" to 2, "c" to 3)      // 熟悉以後的寫法
    println("key: ${mapA.keys}")                        // [a, b, c]
    println("values: ${mapA.values}")                   // [1, 2, 3]
    // 常用的語法
    if ("a" in map) { println("key a value: ${mapA["a"]}") }
    if (map.containsKey("a")) { println(map.containsKey("a")) }  //containsKey: Returns true if the map contains the specified key.
    if (map.contains("a")) { println(map.contains("a")) } //contains: Returns true if the map contains the specified key.
    if (1 in map.values) { println("show keys: ${mapA.keys}") }
    if (map.containsValue(1)) { println("${map.containsValue(1)}") }
    //Map 的等式比較只要鍵值對一樣就會相等，不在乎順序
    val map1 = mapOf("a" to 1, "b" to 2, "c" to 3)
    val map2 = mapOf("b" to 2, "c" to 3, "a" to 1)
    println(map1 == map2)
    val map = mutableMapOf("a" to 1, "b" to 2, "c" to 3) //MutableMap 是在 Map 之上加入可以修改項目的功能
    map.put("a", 5)
    map["b"] = 7
    println("map: $map")
    println("-------------")*/

/** 9.2 疊代器 **/
//疊代器是一種軟體設計模式，它會在容器 (集合) 中遍訪每一個項目。
//「遍訪」是指一個接一個，而不一定依順序，像是 Set 集合就沒有順序，但它依然可以一個接一個。
//傳統 for 迴圈是以索引值來依序取得每一個項目，疊代器則是透過 next() 方法來取得下一個項目，而且是單向的。
//Kotlin 中的 for-in 迴圈就是使用疊代器。
//List 和 Set 實作 Collection 介面，而 Collection 實作 Iterable 介面，因此可以呼叫 iterator() 方法來取得疊代器。

//取得疊代器時，會有一個指針指向集合中的第一個項目，
//當我們呼叫 next() 時，它會回傳這個項目並且將指針 (cursor) 移向下一個項目 (如果還有下一個項目的話)，
//直到最後一個項目被回傳後，就再也不會回傳任何項目，指針並不能重置到之前的位置上。
    /*print("iterator(): ")
    val it = listOf(1, 6, 3, 4, 5).iterator()
    while (it.hasNext()) {
        print("${it.next()}\t")
    }
    println(" ")
    //for-in 迴圈來疊代集合中的項目，它會隱含的取得疊代器
    val ForInA = listOf(1, 2, 3, 4, 5)
    print("for-in: ")
    for(it in ForInA){
        print("${it}\t")
    }
    println(" ")
    //Kotlin 的工具函式 forEach() 也是使用疊代器
    print("forEach(): ")
    listOf(1, 2, 3, 4, 5).forEach { print("${it}\t") }             // 熟練後的寫法
    println(" ")
    println("--------------分解動作如下-----------")
    listOf(1, 2, 3, 4, 5).forEach(fun (item: Int) { print(item) }) // 1.匿名函式
    listOf(1, 2, 3, 4, 5).forEach( { item -> print(item) } )       // 2.Lambda 表達式取代匿名函式
    listOf(1, 2, 3, 4, 5).forEach( { print(it) } )                 // 3.使用預設參數 it
    listOf(1, 2, 3, 4, 5).forEach { print(it) }                    // 4.將 Lambda 移到括號後面並省略括號*/

/** 9.3 範圍 **/
//指由兩個端點定義的一段封閉區間的有順序的數值。
    /*val rA = 1.rangeTo(5)
    println(rA)
    val a1 = 1..5   // 通常會以符號表示
    // for-in 迴圈的應用
    for (i in 1..5) {
        print(i)
    }
    println("")
    print("可以轉成 List 來用: ")
    (1..5).toList().forEach(::print)
    println("")
    // if 條件的應用
    val b = 3
    if (b in 1..5) {println("b = $b, 在 1~5 之間")}
    if (b >= 1 && b <= 5) {println("b = $b, 在 1~5 之間")}  // 相當於
    //使用 downTo() 取得由大到小的範圍值，
    //使用 step 指定累進值，
    //如果範圍值不想包含尾數，可以改用 until ，字元也可以用來指定範圍
    for(i in 1..5){print(i)}            //大到小，累進 1
    println("")
    for(i in 5 downTo 1){print(i)}      //也可以寫成 5.downTo(1)
    println("")
    for (i in 1..10 step 3) {print(i)}  // 小到大，累進 3
    println("")
    for(i in 2 until 11){print("$i\t")} //小到大，不包含尾數，也可以寫成 2.until(11)
    println("")
    for (c in 'a'..'e'){print("$c\t")}  //字元也可以*/

/** 9.4.1 轉換 **/
//映射 (Mapping) 會將集合中既有的項目一次一個轉換成新的項目，
//最常用的映射函式是 map() 它有其他相關的函式，
//例如提供索引值的 mapIndexed()、忽略 null 的 mapNotNull() 及 mapIndexedNotNull() 等等
    /*val listA = listOf(1, 2, 3)
    val listB = listA.map { it * it }  // 轉成平方值
    println("listA: $listA")
    println("listB: $listB")
    // 轉成字串
    val mapIndexedC = listA.mapIndexed { index, value -> "[$index] $value" }
    println("mapIndexedC: $mapIndexedC")
    // 奇數值轉成三次方值
    // 將偶數設為 null 即可忽略它
    val odd2Cubic = listA.mapNotNull {
        if (it % 2 == 0) null else (it * it * it)
    }
    println("odd2Cubic listA: $odd2Cubic")*/
    //mapNotNull() 的原因是，在 Lambda 表達式中是不能使用類似 for 迴圈中的 continue 關鍵字來跳過我們不需要轉換的項目，
    //所以我們可以將這些不需要的項目的轉換值設為 null，mapNotNull() 函式會忽略 null 的項目

/** 9.4.2 過濾 **/
//常用的集合運算，過濾的動作可以挑選想要的或去除不要的項目。
//提供一段敍述來定義過濾的條件，這段敍述被放在一個 Lambda 函式中，
//用來檢驗集合中的每一個項目，如果符合就回傳 true，不符合就回傳 false，這些符合的項目就會被保留下來。
//最基本的過濾函式是 filter()，只要指定過濾條件就能取得符合條件的新集合。
    /* 過濾 List 集合，也可用於 Set 集合 */
    /*val listNameA = listOf("Tony", "Tom", "Tiffany", "ET", "Jean", "Andy", "Dawi")
    val filterNameB = listNameA.filter { it.startsWith("D") } // 選擇字母開頭為 T 的名字
    println("select startsWith D: $filterNameB")

    /* 過濾 Map 集合 */
    val mapNameC = mapOf(1 to "Tony", 2 to "Dawi", 3 to "Tiffany", 4 to "Sunny", 5 to "Tom")
    // 寫法一：使用預設的參數名稱 it
    val filterNameIt = mapNameC.filter { it.key == 4 || it.value.endsWith("i") }
    println("select endsWith y: $filterNameIt")*/

/** 9.4.3 群組 **/
//群組 (Grouping) 可以讓我們將一個集合分類成多個集合，它的回傳值是 Map 資料型別
//key 是分類的標準，value 則是符合此標準的項目集合，最常用的函式為 groupBy()
    val peopleListNameA = listOf("Tony", "Dororo", "Tom", "Tiffany", "Andy", "Bob", "Baby", "Dawi")
    val groupByFirst = peopleListNameA.groupBy { it.first() }  // 以第一個字母為標準來分類
    println("Group: $groupByFirst")

/** 9.4.4 截取集合的一部分 **/
//我們可以從集合中切割 (Slice) 一段想要的部分。
//slice() 會依我們所指定的索引值回傳這些索引所在的項目並建立一個新集合，索引值可以是一段範圍或是數字集合。
    val sliceB = peopleListNameA.slice(4..7)    // 一段範圍
    println("slice 4..7: $sliceB")
    val sliceEven = peopleListNameA.slice(peopleListNameA.indices step 2 )  // 偶數索引項目
    println("slice even numbers name: $sliceEven")
    val setOfName = peopleListNameA.slice(setOf(4, 1, 3))  // 以集合指定
    println("setOf Name order: $setOfName")
    //如果要從集合的後面倒算過來，可以用 takeLast() 或 dropLast()
    val takeTestA = peopleListNameA.take(3)
    println("take 3 names: $takeTestA")
    val takeLastA = peopleListNameA.takeLast(2)
    println("take last 2 names: $takeLastA")
    val dropNameA = peopleListNameA.drop(3)
    println("drop 3 names: $dropNameA")
    val dropLastNameA = peopleListNameA.dropLast(2)
    println("drop last 2 names: $dropLastNameA")
    val f = peopleListNameA.drop(2).take(2)   //前 2 個丟掉，然後拿 2 個
    println("test: $f")
}
