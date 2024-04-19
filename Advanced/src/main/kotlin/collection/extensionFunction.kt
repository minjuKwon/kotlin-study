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

    /*검색*/
    println("=====검색=====")
    //주어진 인덱스 요소 반환. 인덱스 범위 외 값을 주면 오류 발생
    println("list2.elementAt(2): ${list2.elementAt(2)}")
    println("set2.elementAt(3): ${set2.elementAt(3)}")
    //주어진 인덱스 요소 반환. 인덱스 범위 외 값을 주면 람다식에 따른 값 반환
    println("list2.elementAtOrElse(5){it*5}: ${list2.elementAtOrElse(5){it*5}}")
    println("set2.elementAtOrElse(4){it*4}: ${set2.elementAtOrElse(4){it*4}}")
    //주어진 인덱스 요소 반환. 인덱스 범위 외 값을 주면 null 반환
    println("list2.elementAtOrNull(6): ${list2.elementAtOrNull(6)}")
    println("set2.elementAtOrNull(6): ${set2.elementAtOrNull(6)}")
    println()

    //해당 요소에 일치하는 첫 인덱스 반환
    println("list2.indexOf(3): ${list2.indexOf(3)}")
    println("set2.indexOf(7): ${set2.indexOf(7)}")
    //해당 요소에 일치하는 마지막 인덱스 반환
    println("list2.lastIndexOf(3): ${list2.lastIndexOf(3)}")
    println("set2.lastIndexOf(7): ${set2.lastIndexOf(7)}")
    //해당 람다에 일치하는 요소의 첫 인덱스 반환
    println("list2.indexOfFirst { it%2==0 }: ${list2.indexOfFirst { it%2==0 }}")
    println("set2.indexOfFirst { it%2==0 }: ${set2.indexOfFirst { it%2==0 }}")
    //해당 람다에 일치하는 요소의 마지막 인덱스 반환
    println("list2.indexOfLast { it%2==0 }: ${list2.indexOfLast { it%2==0 }}")
    println("set2.indexOfLast { it%2==0 }: ${set2.indexOfLast { it%2==0 }}")
    println()

    //이진 탐색 후 해당 요소 인덱스 반환. 단, 중복된 요소가 있을 때는 원하지 않는 인덱스 반환할 수 있음
    println("list2.binarySearch(2): ${list2.binarySearch(2)}")
    println()

    //람다 조건에 따른 첫번째 요소 반환. 조건에 따른 요소가 없으면 null 반환
    println("list2.find { it>3 }: ${list2.find { it>3 }}")
    println("set2.find { it<7 }: ${set2.find { it<7 }}")
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

    //람다에 일치하는 요소 하나 반환. 일치하는 요소가 여러개면 예외 발생. map 사용 X
    //람다에 일치하는 요소 하나 반환. 일치하는 요소가 여러개나 없으면 null 반환. map 사용 X
    println("list2.single { it==2 }: ${list2.single { it==2 }}")
    println("set2.single { it==7 }: ${set2.single { it==7 }}")
    println("list2.singleOrNull { it==2 }: ${list2.singleOrNull { it==2 }}")
    println("set2.singleOrNull { it==2 }: ${set2.singleOrNull { it==2 }}")
    println()

    //람다에 일치하는 첫번째 요소
    println("list2.first { it%2==0 }: ${list2.first { it%2==0 }}")
    println("set2.first { it%2==0 }: ${set2.first { it%2==0 }}")
    //람다에 일치하는 마지막 요소
    println("list2.last { it%2==0 }: ${list2.last { it%2==0 }}")
    println("set2.last { it%2==0 }: ${set2.last { it%2==0 }}")
    //람다에 일치하는 첫번째 요소. 람다에 일치하는 요소가 없으면 null 반환
    println("list2.firstOrNull { it%7==0 }: ${list2.firstOrNull { it%7==0 }}")
    println("set2.firstOrNull { it%3==0 }: ${set2.firstOrNull { it%3==0 }}")
    //람다에 일치하는 마지막 요소. 람다에 일치하는 요소가 없으면 null 반환
    println("list2.lastOrNull { it%7==0 }: ${list2.lastOrNull { it%7==0 }}")
    println("set2.lastOrNull { it%3==0 }: ${set2.lastOrNull { it%3==0 }}")
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
    println()

    val listRepeated= listOf(1,1,2,3,3,3)
    //중복 요소를 없애 유일한 값들만 가진 채 List로 반환. 합집합 원리
    println("listRepeated.distinct(): ${listRepeated.distinct()}")
    //중복 요소를 없애고 두 컬렉션 병합. Set으로 변환.
    println("list3.union(listOf(4,5,6,7)): ${list3.union(listOf(4,5,6,7))}")
    println("set3.union(setOf(4,5,6)): ${set3.union(setOf(4,5,6))}")

    //겹치는 요소만 가진 채 List로 반환. 교집합 원리
    println("list3.intersect(listRepeated): ${list3.intersect(listRepeated)}")
    println("set3.intersect(setOf(1,2,6,7)): ${set3.intersect(setOf(1,2,6,7))}")
    println()

    //각 요소에 람다식을 적용하여 컬렉션으로 반환. forEach()와 비슷하지만
    //새로운 컬렉션으로 반환하기에 원본 컬렉션이 안전함.
    println("list3.map { it*2 }: ${list3.map { it*2 }}")
    println("set3.map { it*2 }: ${set3.map { it*2 }}")
    println("map3.map { it.value*2}: ${map3.map { it.value*2 }}")

    //각 인덱스와 값에 람다식에 따라 처리하여 컬렉션으로 반환.
    println("list3.mapIndexed{index, i -> index*i }: ${list3.mapIndexed{index, i -> index*i }}")
    println("set3.mapIndexed{index, i -> index*i }: ${set3.mapIndexed{index, i -> index*i }}")

    //각 요소에 람다식을 적용하여 생긴 여러 컬렉션들을 다시 하나의 컬렉션으로 합침.
    //람다에는 listOf()나 toList()같이 Iterator를 가진 객체를 넘겨야 함.
    //반환된 컬렉션의 크기와 구조는 원본과 다를 수 있음.
    println("list3.flatMap {listOf(it,\"*\")}: ${list3.flatMap {listOf(it,"*")}}")
    println("set3.flatMap { \"\$it!\".toSet()}: ${set3.flatMap { "$it!".toSet()}}}")
    println("map3.flatMap { listOf(it.value,\"@\") }: ${map3.flatMap { listOf(it.value,"@") }}")

    //각 요소에 람다를 처리한 내용을 다른 컬렉션에 복사. 복사한 컬렉션은 MutableCollection이어야 함.
    println("list3.mapTo(mutableListOf()) { i -> i*2 }: ${list3.mapTo(mutableListOf()) { i -> i*2 }}")
    println("set3.mapTo(mutableSetOf()) { i -> i*2 }: ${set3.mapTo(mutableSetOf()) { i -> i*2 }}")
    println("map3.mapTo(mutableListOf()) { i -> i.value*2 }: ${map3.mapTo(mutableListOf()) { i -> i.value*2 }}")

    //null를 제외하고 각 요소에 람다식을 적용하여 컬렉션으로 반환.
    //null를 포함할 수 있기에 ?. 포함한 메서드 사용 필요.
    println("listWithNull.mapNotNull { it?.times(2) }: ${listWithNull.mapNotNull { it?.times(2) }}")
    println("setWithNull.mapNotNull { it?.times(2) }: ${setWithNull.mapNotNull { it?.times(2) }}")
    println()

    //람다에 따라 요소를 그룹화하고 이것을 Map으로 반환. Iterable<T>.groupBy 형태이기에 map 사용 불가능
    println("list3.groupBy { if(it%2==0)\"짝\" else \"홀\" }: ${list3.groupBy { if(it%2==0)"짝" else "홀" }}")
    println("set3.groupBy { if(it%2==0)\"짝\" else \"홀\" }: ${set3.groupBy { if(it%2==0)"짝" else "홀" }}")

    //람다 조건식의 boolean 결과에 따라 Pair의 List타입으로 분리. 첫 번째 위치기 true, 두 번째 위치가 false. map 사용 X
    println("list3.partition { it%2==0 }: ${list3.partition { it%2==0 }}")
    println("set3.partition { it%2==0 }: ${set3.partition { it%2==0 }}")
    println()

    //두 개의 컬렉션에서 동일한 인덱스끼리 Pair으로 반환. 두 컬렉션 크기가 다를 경우, 요소가 작은 컬렉션 인덱스에 맞춰서 구성. map 사용X
    println("list3.zip(listOf(1,2)): ${list3.zip(listOf(1,2))}")
    println("set3.zip(setOf(1,2,3,4)): ${set3.zip(setOf(1,2,3,4))}")
    println()

    //요소 순서를 거꾸로 해서 반환. 정렬 X
    println("list3.reversed(): ${list3.reversed()}")
    println("set3.reversed(): ${set3.reversed()}")
    //오름차순 정렬
    println("list3.sorted(): ${list3.sorted()}")
    println("set3.sorted(): ${set3.sorted()}")
    //내림차순 정렬
    println("list3.sortedDescending(): ${list3.sortedDescending()}")
    println("set3.sortedDescending(): ${set3.sortedDescending()}")
    //람다 조건에 따른 요소를 오름차순 정렬
    println("list3.sortedBy { it%3 }: ${list3.sortedBy { it%3 }}")
    println("set3.sortedBy { it%3 }: ${set3.sortedBy { it%3 }}")
    //람다 조건에 따른 요소를 내림차순 정렬
    println("list3.sortedByDescending { it%3 }: ${list3.sortedByDescending { it%3 }}")
    println("set3.sortedByDescending { it%3 }: ${set3.sortedByDescending { it%3 }}")

}