package dev.study.dataclass

/*
    java 14 버전 이후에 나온 개념
    -> record 클래스가
    불변 객체 ->
 */

class Test{
    companion object{
        fun add(a: Int, b: Int): Int = a + b
    }
}

data class User(
    val name: String,
    val age: Int,
)

fun main(){
    val user = User("Alice", 30)
    println(user)
    println(Test.add(1, 2))
}