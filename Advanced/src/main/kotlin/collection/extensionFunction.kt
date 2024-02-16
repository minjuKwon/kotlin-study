package collection

fun main() {

    /*연산자*/
    val list1= listOf("A","B","C")
    val set1= setOf(1,2,3)
    val map1= mapOf(1 to "가", 2 to "나", 3 to "다")

    println(list1+"A")
    println(list1+listOf("X","Y"))
    println(set1+3)
    println(set1+4)
    println(set1+setOf(7,8,9))
    println(map1+mapOf(5 to "마", 6 to "바"))
    println(map1+Pair(4,"라"))

    println(list1-"B")
    println(list1-listOf("A","C"))
    println(set1-2)
    println(set1-setOf(1,3))
    println(map1-2)
    println(map1-mapOf(1 to "가", 3 to "다"))//적용 X
    println(map1-Pair(2,"나"))//적용 X
    println(map1-listOf(1,2))
    println()

    /*순환*/
    //각 요소를 람다로 처리
    list1.forEach{print("$it ")}
    println()
    set1.forEach {print("$it ")}
    println()
    map1.forEach {print("$it ")}
    println()
    println()
    //람다 처리 후 컬렉션 반환
    val getList=list1.onEach { print("$it ") }
    println()
    println(getList)
    val getSet=set1.onEach { print("$it ") }
    println()
    println(getSet)
    val getMap=map1.onEach { print("$it ") }
    println()
    println(getMap)
    println()
    //각 요소의 값과 인덱스를 람다에 따라 처리
    list1.forEachIndexed { index, s -> println("list1[$index]: $s")}
    println()
    set1.forEachIndexed { index, i -> println("set1[$index]: $i")}
    println()
    //map1.forEachIndexed{} //map는 인덱스가 아닌 키로 값을 찾기에 불가능

    /*집계*/
    val list2= listOf(1,2,3,4,5)
    val set2= setOf(6,7,8,9,10)
    val map2 = mapOf(10 to 10, 20 to 20, 30 to 30, 40 to 40, 50 to 50)

    //count() - 요소 개수, count{}->특정 조건 요소 개수
    println("list2.count(): ${list2.count()}")
    println("list2.count{ it%2==1}: ${list2.count{ it%2==1}}")
    println("set2.count(): ${set2.count()}")
    println("set2.count {it%2==0}: ${set2.count {it%2==0}}")
    println("map2.count(): ${map2.count()}")
    println("map2.count{it.key%4==0}: ${map2.count{it.key%4==0}}")
    println("map2.count{it.value%4==0}: ${map2.count{it.value%4==0}}")
    println()

    //max(),min()->단순 값 비교. maxBy{},minBy{}-> map, 객체 값 비교
    println("list2.max(): ${list2.max()}")
    println("list2.min(): ${list2.min()}")
    println("set2.max(): ${set2.max()}")
    println("set2.min(): ${set2.min()}")
    //map은 key와 value이 있기에 단순 max, min 사용 불가능
    println("map2.maxBy { it.key }: ${map2.maxBy { it.key }}")
    println("map2.minBy { it.value }: ${map2.minBy { it.value }}")
    println("map1.minBy { it.value }: ${map1.minBy { it.value }}")
    println()

    //fold: 초기값과 컬렉션 요소들을 람다식에 따라 처리. collection 상속받는 컬렉션만 사용 가능 즉, map 적용X
    //foldRight: fold 연산 순서가 반대. 즉 마지막 요소에서 첫번째 요소 순서로 적용. array,List에만 적용
    //reduce: 컬렉션 요소들을 람다식에 따라 처리. fold와 달리 초기값 없음. collection 상속받는 컬렉션만 사용 가능 즉, map 적용X
    //reduceRight: reduce 연산 순서 반대. 즉 마지막 요소에서 첫번째 요소 순서로 적용. array,List에만 적용
    println("list2.fold(6){total, next-> total-next}: " +
            "${list2.fold(6){total, next-> total-next}}")//6-1-2-3-4-5
    println("list2.foldRight(6){total, next-> total-next}: " +
            "${list2.foldRight(6){total, next-> total-next}}")//5-(4-(3-(2-(1-6))))
    println("list2.reduce{total, next-> total-next}: " +
            "${list2.reduce{total, next-> total-next}}")//1-2-3-4-5
    println("list2.reduceRight{total, next-> total-next}: " +
            "${list2.reduceRight{total, next-> total-next}}")//1-(2-(3-(4-5)))
    println("set2.fold(2){total, next-> total-next}: " +
            "${set2.fold(2){total, next-> total-next}}")//2-6-7-8-9-10
    //set2.foldRight(2){total, next-> total-next}//
    println("set2.reduce{total, next-> total-next}: " +
            "${set2.reduce{total, next-> total-next}}")//6-7-8-9-10
    println()

    /*검사*/

    /*필터*/
    
    /*변환*/

}