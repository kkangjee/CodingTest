import java.util.regex.Pattern
import kotlin.math.log10

fun main() {

    var arr1 = intArrayOf(-13,1900)
    println(task1(arr1))
    println(task2("aabbb"))
    println(task3("010-111-2222"))
    println(task4("Sat",23))

}

fun task1(A: IntArray): Int {
    var sum = 0
    for (i in A) {
        var temp = i
        if (i < 0) temp = -i
        //println("temp: $temp")
        val length = (log10(temp.toDouble()) + 1).toInt()
        //println(length)
        if (length == 2) {
            sum += i
        }
    }

    return sum
}

fun task2(S: String): Boolean {
    var i = 0
    while (i < S.length && S[i] == 'a') {
        i++
    }
    while (i < S.length) {
        if (S[i] == 'a') return false
        i++
    }
    return true
}

fun task3(S: String): Boolean {
    val pattern = "^[0-9]{3}-[0-9]{3}-[0-9]{3}$"
    return Pattern.matches(pattern, S)
}

fun task4(S: String, K: Int): String {
    val week = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    var i = 0
    var start = 0
    val cnt = K % 7

    for (w in week) {
        if (S == w) {
            start = i
            break
        }
        i++
    }
    i = if (start + cnt > 6)
        start + cnt - 7
    else
        start + cnt
    return week[i]
}

fun test1(A: IntArray): Int {
    // write your code in Kotlin

    var arrayList = ArrayList<Int>()
    var max = 0
    for (i in A) {
        arrayList.add(i)
        if (i > max)
            max = i
    }

    return if (!arrayList.contains(max - 1))
        max - 1
    else
        max + 1

}