package dev.study

fun sum(a: Int, b: Int): Int {
    var sum = 0
    for (i in a..b) {
        sum += i
    }
    return sum
}

fun product(a: Int, b: Int): Int {
    var product = 0
    for (i in a..b) {
        product += i
    }
    return product
}
fun sum2(a: Int, b: Int) = fold(a,b, 0, {acc, i->acc +i})


fun fold(
    a: Int,
    b: Int,
    initial: Int,
    operation: (Int, Int) -> Int
): Int {
    var acc = initial
    for (i in a..b) {
        acc = operation(acc, i)
    }
    return acc
}
// 조금 더 업그레이드
fun sum3(a: Int, b: Int) =
    (a .. b).fold(0, {acc, i->acc +i})

// 함수 참조 방식으로 변경
fun sum4(a: Int, b: Int) = sum3(a,b)