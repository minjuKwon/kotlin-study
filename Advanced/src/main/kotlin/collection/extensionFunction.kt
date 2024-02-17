package collection

fun main() {

    /*연산자*/
    println("=====연산자=====")
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
    println("=====순환=====")
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
    println("=====집계=====")
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
    println("=====검사=====")
    //모든 요소가 람다식에 일치할 때 true
    println("list2.all {it<3}: ${list2.all {it<3}}")
    println("set2.all {it%2==1}: ${set2.all {it%2==1}}")
    println("map2.all{it.value%5==0}: ${map2.all{it.value%5==0}}")
    println()

    //요소가 하나라도 람다식에 일치할 때 true
    println("list2.any {it<3}: ${list2.any {it<3}}")
    println("set2.any {it%2==1}: ${set2.any {it%2==1}}")
    println("map2.any{it.value%5==0}: ${map2.any{it.value%5==0}}")
    println()

    //요소가 포함되어 있으면 ture
    println("list2.contains(7): ${list2.contains(7)}")
    println("3 in list2: ${3 in list2}")
    println("set2.contains(3): ${set2.contains(3)}")
    println("7 in set2: ${7 in set2}")
    println("map2.contains(20): ${map2.contains(20)}")
    println("20 in map2: ${20 in map2}")

    println("list2.containsAll(listOf(1,2)): ${list2.containsAll(listOf(1,2))}")
    println("set2.containsAll(setOf(5,6,7)): ${set2.containsAll(setOf(5,6,7))}")
    println()

    //none(): 컬렉션 요소가 없으면 true. 이는 null이 할당되어 있거나 메모리에 할당 되지 않은 상태.
    //isEmpty(): 컬렉션이 비어 있으면 true. 이는 컬렉션이 생성되었지만 요소를 넣지 않은 상태.
    //none는 람다로 조건에 따른 요소 확인 가능. 하지만 isEmpty()는 단순히 비어있는 여부만 확인 가능
    //none는 순회하면서 모든 조건을 검사하고 isEmpty()는 컬렉션 크기로 비어있는 여부 확인하기에
    //단순히 비어있는지 확인하고 싶은 경우는 isEmpty() 사용이 효율적.
    val listEmpty=listOf<Int>()//빈리스트
    println("listEmpty.none(): ${listEmpty.none()}")
    println("listEmpty.isEmpty(): ${listEmpty.isEmpty()}")
    val listNull=listOf(null,null)
    println("listNull.none(): ${listNull.none()}")
    println("listNull.none { it==null }: ${listNull.none { it==null }}")
    println("listNull.isEmpty(): ${listNull.isEmpty()}")
    val setEmpty = setOf<Int>()
    println("setEmpty.none(): ${setEmpty.none()}")
    println("setEmpty.isEmpty(): ${setEmpty.isEmpty()}")
    val mapEmpty= mapOf<Int,Int>()
    println("mapEmpty.none(): ${mapEmpty.none()}")
    println("mapEmpty.isEmpty(): ${mapEmpty.isEmpty()}")
    println()

    /*필터*/
    println("=====필터=====")
    //람다식 처리에 따른 추출 후 반환 값 얻음.
    val listFilter = listOf(1,2,3,4,5)
    val setFilter = setOf(6,7,8,9,10)
    val mapFilter = mapOf(1 to 10, 2 to 20, 3 to 30, 4 to 40, 5 to 50)
    val a=listFilter.filter { it%2==0 }
    println("listFilter.filter { it%2==0 }: ${listFilter.filter { it%2==0 }}")
    println("setFilter.filter { it%2==0 }: ${setFilter.filter { it%2==0 }}")
    println("mapFilter.filter { it.value%4==0 }: ${mapFilter.filter { it.value%4==0 }}")
    println()

    //인덱스과 값 추출. map는 index 대신 key를 가지기에 사용 불가능
    println("listFilter.filterIndexed{idx, value -> idx>1 &&value%2==1}: " +
            "${listFilter.filterIndexed{idx, value -> idx>1 &&value%2==1}}")
    println("setFilter.filterIndexed{idx, value -> idx>1 &&value%2==1}: " +
            "${setFilter.filterIndexed{idx, value -> idx>1 &&value%2==1}}")
    println()

    //filterIndexed에서 컬렉션 반환 값을 얻음. 단, mutable으로 받음.
    val getListFilter=listFilter.filterIndexedTo(mutableListOf()){ idx, value -> idx<3 &&value%2==0}
    println("getListFilter: $getListFilter")
    val getSetFilter=setFilter.filterIndexedTo(mutableSetOf()){ idx, value -> idx<3 &&value%2==0}
    println("getSetFilter: $getSetFilter")
    println()

    //map 키와 값 추출
    println("mapFilter.filterKeys { it>2 }: ${mapFilter.filterKeys { it>2 }}")
    println("mapFilter.filterValues { it%4==0 }: ${mapFilter.filterValues { it%4==0 }}")
    println()

    //null 요소 제외. 별도의 람다나 매개변수를 받지 않기에 map에는 사용 불가능
    val listWithNull= listOf(1,null,3,null,5)
    val setWithNull = setOf(null, 2, null, 4, null)
    println("listWithNull.filterNotNull(): ${listWithNull.filterNotNull()}")
    println("setWithNull.filterNotNull(): ${setWithNull.filterNotNull()}")
    println()

    //특정 자료형 추출. 별도의 람다나 매개변수를 받지 않기에 map에는 사용 불가능
    val listMixed = listOf(1,"2",3,"4",5)
    val setMixed = setOf("1", 2, "3", 4, "5")
    println("listMixed.filterIsInstance<Int>(): ${listMixed.filterIsInstance<Int>()}")
    println("setMixed.filterIsInstance<Int>(): ${setMixed.filterIsInstance<Int>()}")
    println()

    /*변환*/
    println("=====변환=====")
    val list3= listOf(1,2,3,4,5)
    val set3= setOf(6,7,8,9,10)
    val map3 = mapOf(10 to 10, 20 to 20, 30 to 30, 40 to 40, 50 to 50)

    //List의 특정 범위 인덱스 추출 후 반환
    println("list3.slice(listOf(1,2,4)): ${list3.slice(listOf(1,2,4))}")
    println("list3.slice(1..3): ${list3.slice(1..3)}")
    println()

    //n개의 요소 가진 List 반환. map 사용 X
    println("list3.take(2): ${list3.take(2)}")
    println("set3.take(2): ${set3.take(2)}")
    //마지막 요소부터 n개의 요소 반환. set는 순서가 없기에 사용 불가능
    println("list3.takeLast(2): ${list3.takeLast(2)}")
    //람다 조건에 따른 요소 반환. filter와 달리 조건에 참이 아닌 값이 나오면 바로 멈춤.
    println("list3.takeWhile { it%2==1 }: ${list3.takeWhile { it%2==1 }}")
    println("set3.takeWhile { it%2==0 }: ${set3.takeWhile { it%2==0 }}")
    println()

    //n개 요소 제외하여 List 반환. take 반대
    println("list3.drop(2): ${list3.drop(2)}")
    println("set3.drop(2): ${set3.drop(2)}")
    //마지막 요소부터 n개 제외하여 요소 반환. set는 순서가 없기에 사용 불가능
    println("list3.dropLast(2): ${list3.dropLast(2)}")
    //람다 조건에 따른 요소 제외하여 반환. filter와 달리 조건에 참이 아닌 값이 나오면 바로 멈춤.
    println("list3.dropWhile { it%2==1 }: ${list3.dropWhile { it%2==1 }}")
    println("set3.dropWhile { it%2==0 }: ${set3.dropWhile { it%2==0 }}")
    //마지막 요소부터 람다 조건에 따른 요소 제외하여 반환. filter와 달리 조건에 참이 아닌 값이 나오면 바로 멈춤.
    //set는 순서가 없기에 사용 불가능
    println("list3.dropLastWhile { it%2==1 }: ${list3.dropLastWhile { it%2==1 }}")
    println()

    //1부터 시작하는 요소의 순서 번호. 요소가 5개이면 component1~component5가 있다
    //set에는 순서가 없기에 사용 불가. map는 key와 value가 있기에 사용 불가
    println("list3.component1(): ${list3.component1()}")

}