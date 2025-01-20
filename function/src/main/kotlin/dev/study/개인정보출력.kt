package dev.study

/*
    첫번째 파라미터는 name 입니다.
    두번째 파라미터는 surname 입니다.
    마지막 파라미터는 age 입니다.
    모든 파라미터는 Nullable한 형태입니다.
    파라미터 값이 존재하지 않는다면 그 값을 제외하고 아래 형식대로 출력 하셔야합니다.
 */


fun formatPersonDisplayAnswer(
    name: String? = null,
    surname: String? = null,
    age: Int? = null,
): String {
    return "${name?:""} ${surname?:""} ${age?:""}"
}


fun main(){
    println(formatPersonDisplayAnswer("John", "Smith", 42))
    // John, Smith, 42
    println(formatPersonDisplayAnswer("Alex", "Simonson"))
    // Alex, Simonson
    println(formatPersonDisplayAnswer("Peter", age= 25))
    // Peter, 25
    println(formatPersonDisplayAnswer(surname="Johnson", age= 18))
    // Johnson, 18
}


