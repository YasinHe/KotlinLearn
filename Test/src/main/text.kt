package main

import model.Model
import model.ModelJava

/**
 * heyingxin 1.0@author
 */
fun main(args: Array<String>) {
    var result = sum(1, 2, 3)
    println("heyingxin:"+result)
    //遍历
    lists("1", "2", "3")
    //不可变遍历
    val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
    println(sumLambda(1,2))  // 输出 3

    val a: Int = 1
    val b = 1       // 系统自动推断变量类型为Int
    val c: Int      // 如果不在声明时初始化则必须提供变量类型
    c = 1           // 明确赋值
    var x = 5        // 系统自动推断变量类型为Int
    x += 1           // 变量可修改

    /**  字符串
     *  $ 表示一个变量名或者变量值
        $varName 表示变量值
        ${varName.fun()} 表示变量的方法返回值:
     */
    val s1 = "a的值is$a"
    val s2 = "${s1.replace("is","was")},原来是$s1"
    println(s2)

    //类型后面加?表示可为空
    var age: String? = "23"
    //抛出空指针异常
    val ages = age!!.toInt()
    //不做处理返回 null
    val ages1 = age?.toInt()
    //age为空返回-1
    val ages2 = age?.toInt() ?: -1

    /**
        十进制：123
        长整型以大写的 L 结尾：123L
        16 进制以 0x 开头：0x0F
        2 进制以 0b 开头：0b00001011
        注意：8进制不支持
        Doubles 默认写法: 123.5, 123.5e10
        Floats 使用 f 或者 F 后缀：123.5f
     */
    val double = 135.5e10
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    //.. 的 rangeTo 函数辅以 in 和 !in 形成,downTo为反方向 .. ,
    // step就是跳几个执行一次，比如8-1 step3  那就是10 跳3 到5 再到2
    print("循环输出：")
    for (i in 1..4) print(i) // 输出“1234”
    println("\n----------------")
    for (i in 4..1) print(i) // 什么都不输出
    print("设置步长：")
    for (i in 1..4 step 2) print(i) // 输出“13”
    println("\n----------------")
    print("使用 downTo：")
    for (i in 4 downTo 1 step 2) print(i) // 输出“42”
    println("\n----------------")
    print("使用 until：")
    // 使用 until 函数排除结束元素
    for (i in 1 until 4) {   // i in [1, 4) 排除了 4
        print(i)
    }
    println("\n----------------")
    //比较值
    compareValue()
    /** 类型转换
     *  toByte(): Byte
        toShort(): Short
        toInt(): Int
        toLong(): Long
        toFloat(): Float
        toDouble(): Double
        toChar(): Char
     */
    /** 位运算
     *  || – 短路逻辑或
        && – 短路逻辑与
        ! - 逻辑非
     *  shl(bits) – 左移位 (Java’s <<)
        shr(bits) – 右移位 (Java’s >>)
        ushr(bits) – 无符号右移位 (Java’s >>>)
        and(bits) – 与
        or(bits) – 或
        xor(bits) – 异或
        inv() – 反向
     */

    //[1,2,3]
    val ass = arrayOf(1, 2, 3)
    //[0,2,4]
    val bs = Array(3, { i -> (i * 2) })
    //读取数组内容
    println(ass[0])    // 输出结果：1
    println(bs[1])    // 输出结果：2
    val xs: IntArray = intArrayOf(1, 2, 3)
    xs[0] = xs[1] + xs[2]

    val text = """
    |多行字符串
    |菜鸟教程
    |多行字符串
    |Runoob
    """
    println(text)
    println("前置空格删除了\n"+text.trimMargin())// 前置空格删除了
    val str = "$text.length is ${text.length}" // 求值结果为 "runoob.length is 6"
    println(str)
    val price = """
    ${'$'}9.99
    """
    println(price)  // 求值结果为 $9.99

    //条件判断
    val max = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }

    //相当于switch- case default
    when (x) {
        0, 1 -> println("x == 0 or x == 1")
        else -> println("otherwise")
    }
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> { // 注意这个块
            println("x 不是 1 ，也不是 2")
        }
    }
    when (x) {
        in 0..10 -> println("x 在该区间范围内")
        else -> println("x 不在该区间范围内")
    }

    //遍历
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    //走while循环
    whileFuncation()
    //java和kotlin的model
    var person:ModelJava = ModelJava()
    person.age = "5"
    person.name = "aboluo"
    println("个人名字是:${person.name}")

    var person2:Model = Model()
    person2.age = "5"
    person2.name = "Ace"
    println("个人名字是:${person2.name}")

}

fun sum(i :Int,j :Int,k :Int) : Int{
    return i+j+k
}

fun lists(vararg lists:String) : Unit{
    for(date in lists){
        //类似于instanceof
        if(date is String)
            println(date)
    }
}

fun compareValue(){
    // 三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小
    val a: Int = 10000
    println(a === a) // true，值相等，对象地址相等
    //经过了装箱，创建了两个不同的对象
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    //虽然经过了装箱，但是值是相等的，都是10000
    println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
    println(boxedA == anotherBoxedA) // true，值相等
}

//Kotlin 中的 Char 不能直接和数字操作，Char 必需是单引号''包含起来的
fun decimalDigitValue(c: Char): Int {
    //in可以表示为在什么什么区间之内
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
    return c.toInt() - '0'.toInt() // 显式转换为数字
}

fun whileFuncation(){
    println("----while 使用-----")
    var x = 5
    while (x > 0) {
        println( x--)
    }
    println("----do...while 使用-----")
    var y = 5
    do {
        println(y--)
    } while(y>0)

    for (i in 1..10) {
        if (i==3) continue  // i 为 3 时跳过当前循环，继续下一次循环
        println(i)
        if (i>5) break   // i 为 6 时 跳出循环
    }

    //遇到标签就结束
    val ints = arrayOf(0,1,2,3)
    ints.forEach lit@ {
        if (it == 0) return@lit
        print(it)
    }
    ints.forEach {
        if (it == 0) return@forEach
        print(it)
    }
    ints.forEach(fun(value: Int) {
        if (value == 0) return
        print(value)
    })
}

