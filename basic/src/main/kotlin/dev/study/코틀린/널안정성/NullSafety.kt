package dev.study.코틀린.널안정성
/*
    Null Safety

    기본적으로 null을 허용 하지않습니다. <-
    ?를 사용해서 Nullable 타입을 명시 가능합니다.

    Java 모든 참조 타입 변수에 null을 할당 가능하죠
    NPE(Null Point Exption)에 취약

    ?. (안전 호출 연산자)
    ?: (엘비스 연산자)
    !!.

    코틀린은 삼항연산자가 없습니다.

 */
class User(val name: String){
    fun cheer(){
        println("우리팀 화이팅!")
    }
}
var user: User? = null

fun main(){
//    val nonNullable: String = "Kotlin" // Non-null 타입
//    val nullable: String? = null    // nullable 타입
//
//    val number = if(nonNullable.startsWith("K")) 1 else 2
//
//    println(nullable?.length ?: -1)
    user?.cheer()
    println(user?.name)
    user = User("Leana")
    user?.cheer()
    println(user?.name)


}