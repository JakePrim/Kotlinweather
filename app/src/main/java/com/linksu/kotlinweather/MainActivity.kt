package com.linksu.kotlinweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textV.text = "Kotlin基础知识"
    }

    // 定义函数
    private fun sum(a: Int = 1, b: Int = 1): Int = a + b

    //函数返回毫无意义的值
    private fun printSun(a: Int, b: Int): Unit {
        println("printSun sum of $a and $b is : ${a + b}")
    }

    private fun main2() {
        print(printSun(-1, 8))
    }

    private fun main(arg: Array<Int>) {
        for (i in arg) {
            println("sum of 1 and ${i} is : ")
            println(sum(1, i))
            println("sum of 23 and 25 is ${sum(23, 25)}")
        }
    }

    //定义局部变量 一次赋值(只读)的局部变量
    private fun main3() {
        val a: Int = 1 //立即赋值
        val b = 2 //自动推断出类型
        val c: Int // 如果没有初始值类型不能省略
        c = 3 //明确赋值
        println("a = $a , b= $b , c= $c")
    }

    //定义可变变量
    private fun main4() {
        var a = 5 //自动推断出 Int 类型
        a += 1
        println("main4 --> a = $a ")
    }

    //字符串模板
    private fun main5() {
        var a = 1
        val s1 = "a is $a"

        a = 2

        val s2 = "${s1.replace("is", "was")} ,but now is $a"

        println(s2)
    }

    //使用条件表达式
    private fun maxOf(a: Int, b: Int): Int = if (a > b) a else b

    private fun main6() {
        textV.text = "max of 1 and 40 is ${maxOf(1, 40)}"
//        println("max of 1 and 40 is ${maxOf(1, 40)}")
    }

    //使用可空值及null检测
    /**
     * 当某个变量的值可以为null的时候，必须在声明处的类型后添加? 来标识该引用可为空
     */
    //可返回空值的函数
    fun parseInt(str: String): Int? {
        return str.toIntOrNull()
    }

    fun printParse(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        if (x != null && y != null) {
            println("is a number x * y is ${x * y}")
        } else {
            println("either '$arg1' or '$arg2' is not number")
        }
    }

    fun printParse2(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        if (x == null) {
            println("Wrong number format in arg1 : '$arg1' ")
            return
        }
        if (y == null) {
            println("Wrong number format in arg2 : '$arg2' ")
            return
        }

        println("is a number x * y is ${x * y}")
    }

    fun main7() {
        printParse2("1", "2")
        printParse2("a", "6")
        printParse2("3", "b")
        printParse2("a", "b")
    }

    // 类型检测与类型转换
    /**
     * is 运算符检测一个表达式是否某类型的一个实例
     */
    // 第一种写法
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            //'obj' 在该条件下检测自动转换成String类型
            return obj.length
        }
        // 跳出检测分支后，仍为Any 类型
        return null
    }

    // 第二种写法
    fun getStringLengthOrOne(obj: Any): Int? {
        if (obj !is String) return null
        //'obj' 在该条件下检测自动转换成String类型
        return obj.length
    }

    // 第三种写法
    fun getStringLengthOrTwo(obj: Any): Int? {
        // 'obj' 在 ’&&‘ 后面自动转换成String
        if (obj is String && obj.length > 0) return obj.length
        return null
    }

    fun printStringLength(obj: Any) {
        println("'$obj' string length is ${getStringLengthOrTwo(obj) ?: "...error not a String"}")
    }

    fun main8() {
        printStringLength("InstrnajklCommmenst")
        printStringLength(88888)
        printStringLength("")
    }

    //使用 for循环
    fun main9() {
        val items = listOf("apple", "tiger", "somall")
        for (item in items) {// 循环的是list里的值
            println("item --> '$item' ")
        }
        // or
        for (index in items.indices) {// 循环的是list的下标
            println("item at '$index' --> ${items[index]}")
        }
    }

    //使用while 循环
    fun main10() {
        val items = listOf("apple", "tiger", "somall")
        var index = 0
        while (index < items.size) {
            println("item at '$index' --> ${items[index]}")
            index++
        }
    }

    //使用when表达式
    fun describe(obj: Any): String =
            when (obj) {
                1 -> "one"
                "Hello" -> "Hi"
                is Int -> "This is Int"
                is Long -> "This is Long"
                !is String -> "Not a String"
                else -> "Unkown"
            }


    fun main11() {
        println(describe(1))
        println(describe("Hello"))
        println(describe(2000L))
        println(describe(2))
        println(describe("other"))
    }

    //使用区间(range)
    /**
     * 使用 in 运算符来检测某个数字是否在指定的区间内
     */
    fun main12One() {
        val a = 9
        val b = 10
        if (a in 1..b) { // a 是否在 1 - 10 之间
            println(" a :'$a' in 1 - '$b' fits")
        }
    }

    // 检测某个数字是否在指定的区间外
    fun main12Two() {
        val x = -1
        val y = 10
        if (x !in 0..y) {
            println("x:$x is out of range 0..$y")
        }
    }

    //区间迭代 用for循环
    fun main12Thr() {
        for (x in 1..5) {
            println("迭代 x : $x 1..5")
        }
    }

    //数列迭代
    fun main12For() {
        main12Two()
        main12Thr()
        for (x in 0..10 step 2) {// 从 0 - 10 迭代，且中间隔2个数
            println("数列迭代 x : $x 0..10")
        }

        for (x in 9 downTo 0 step 3) { // 从9 - 0 迭代，且中间隔3个数
            println("数列迭代2 x : $x 9..0")
        }
    }

    //使用集合


    fun main13One() {
        val items = listOf("aaa", "bab", "ccc", "apple", "aiki")
        //对集合进行迭代
        for (item in items) {
            println(item)
        }

        //使用in运算符来判断集合内是否包含某实例 判断多个时
        when {
            "ddd" in items -> println("NONONON")
            "aaa" in items -> println("aaa is fine too")
        }
        //or 判断一个时
        if ("aaa" in items) {
            println("or aaa is fine too")
        }

        //使用lambda 表达式来过滤(filter) 和映射(map)集合
        items.filter { it.startsWith("a") } //过滤开头不是a的
                .sortedBy { it }
                .map { it.toUpperCase() } //准换成大写，可对过滤后的list
                .forEach { println(it) }

    }
}
