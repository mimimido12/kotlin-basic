package dev.study.코틀린
/**
1. val(value) -> 값을 변경을 할 수가 없다.(immutable) 불변
2. var(variable) -> 일기 / 쓰기 모두가능한 변수 (mutable)

자바에서 val 값을 변경을 할 수가 없게하려면 final 불변 변수

타입 추론(Type inference)
타입을 명시하지 않더라도 타입을 컴파일러가 자동으로 춘론하다.
java는 명시적으로 타입선언이 필요합니다만, 자바 10번 이후에 var 키워드가생기면서 간소화 가능해졌다.
Null Safety. Nullable 타입이 존재합니다.

 */
fun test(){

}

fun main(){
    //명시적 타입선언
    val name:String = "Kotlin"
    var age = 20

    println("Name: $name, Age: $age")
    val message = "Hello, Kotlin"
    val number = 78

    println("Message: $message, Number: $number")
    // age 변경
    age = 26

}