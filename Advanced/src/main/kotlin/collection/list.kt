fun main() {

    /*collection : 데이터를 모아 저장할 수 있는 자료 구조를 모아 높은 프레임 워크.
    종류로는 List, Set, Map 등. 불변형 가변형으로도 나뉨. 불변형은 읽기 전용. 가변형은 추가, 변경 가능

    Iterable는 컬렉션이 연속적 요소 표현하게 해주는 가장 상위 인터페이스. iterator() 연산자 메소드를 가짐.
    이는 hasNext()와 next()를 가지고 요소를 순환. 전자는 읽을 요소 여부 확인, 후자는 읽을 요소있으면 반환.

    Collection는 Iterable에서 확장된 인터페이스. 불변형으로 여기서 확장된 읽기 전용 Set과 List이 있음.
    size, isEmpty(), contains(), containsAll() 멤버 가짐.

    MutableIterable, MutableCollection는 가변형 컬렉션 지원 인터페이스.
    add(), remove(), addAll(), removeAll(), retainAll(), clear() 멤버 가짐.
    */

    /*List: 순서에 따라 정렬된 요소를 가지는 컬렉션. 특정함수를 통해 생성. 이런 함수를 헬퍼 함수라함.
    가변인자인 vararg으로 선언되었기에 원하는 만큼의 요소 선언 가능. 여러 자료형 혼합하여 사용 가능..*/

    /*불변형 List. listOf() 헬퍼 함수로 불변형 List 생성.
     get(), indexOf(), lastIndexOf(), listIterator(), subList() 멤버 가짐*/

    val listNum:List<Int> = listOf(1,2,3)//listOf로 불변형 List 생성
    //listNum.add(4)//불변형이기에 추가 불가능s
    for(num in listNum)print("$num ")
    println()
    println(listNum.javaClass.canonicalName)
    val listMixed = listOf(1,"Hi",2)//Any 타입
    for(value in listMixed)print("$value ")
    println()
    println()

    //짝수 인덱스만 출력
    for(index in listMixed.indices){
        if(index%2==0){
            println("list[$index]: ${listMixed[index]} ")
        }
    }
    println()

    //while문으로 출력
    var index=0
    while(index<listMixed.size){
        println("list[$index]: ${listMixed[index]}")
        index++
    }
    println()

    //emptyList()으로 비어있는 List 생성.
    //타입 추론이 불가능하여 제네릭으로 타입 지정 필수
    val listEmpty:List<Int> = emptyList()

    //listOfNotNull()으로 null 제외한 요소만 반환하여 List 생성
    val listNonNull= listOfNotNull(1,2,null,4,5,null)
    println(listNonNull)
    println()

    val colors= listOf("red","green","blue","pink","red","yellow","purple")

    //Collection 멤버
    println("colors size: ${colors.size}")//list 크기
    println("colors.isEmpty(): ${colors.isEmpty()}")//list가 비어있으면 true
    println("colors.contains(\"pink\"): ${colors.contains("pink")}")//특정 요소 있으면 true
    //특정 컬렉션이 있으면 true
    println("colors.containsAll(listOf(\"red\",\"blue\",\"green\")): " +
            "${colors.containsAll(listOf("red","blue","green"))}")

    //List 주요 멤버 메서드
    println("colors.get(3): ${colors.get(3)}")//특정 인덱스 값 얻기
    println("colors.indexOf(\"red\"): ${colors.indexOf("red")}")//특정 요소가 중복되면 첫번째 요소의 인덱스. 없으면 -1
    println("colors.indexOf(\"orange\"): ${colors.indexOf("orange")}")
    println("colors.lastIndexOf(\"red\"): " +
            "${colors.lastIndexOf("red")}")//특정 요소가 중복되면 마지막 요소의 인덱스. 없으면 -1
    println("colors.lastIndexOf(\"navy\"): ${colors.lastIndexOf("navy")}")
    println("colors.subList(2,5): ${colors.subList(2,5)}")//특정 인덱스 범위 요소 목록
    val colorsIterator=colors.iterator()//list의 iteraotr 반환
    while(colorsIterator.hasNext()){//다음 요소 여부 확인
        print(colorsIterator.next()+" ")//다음 요소 얻기
    }
    println()
    println()

    /*가변형 List. arrayListOf()헬퍼 함수로 가변형 List 생성. 이때 반환 자료형은 자바의 ArrayList.
    mutableListOf() 헬퍼 함수로도 생성 가능. 코틀린의 MutableList 인터페이스 사용. MutableList 반환*/

    //arrayListOf
    val array: ArrayList<Int> = arrayListOf(1,2,3,4,5,2)
    val arrayMixed= arrayListOf("1",2,3,"4")
    println(array.javaClass.canonicalName)

    //Collection 멤버
    println("array size: ${array.size}")//list 크기
    println("array.isEmpty(): ${array.isEmpty()}")//list가 비어있으면 true
    println("array.contains(7): ${array.contains(7)}")//특정 요소 있으면 true
    //특정 컬렉션이 있으면 true
    println("array.containsAll(arrayListOf(1,2,3)): ${array.containsAll(arrayListOf(1,2,3))}")

    //List 주요 멤버 메서드
    println("array.get(3): ${array.get(3)}")//특정 인덱스 값 얻기
    println("array.indexOf(2): ${array.indexOf(2)}")//특정 요소가 중복되면 첫번째 요소의 인덱스. 없으면 -1
    println("array.indexOf(6): ${array.indexOf(6)}")
    println("array.lastIndexOf(2): ${array.lastIndexOf(2)}")//특정 요소가 중복되면 마지막 요소의 인덱스. 없으면 -1
    println("array.lastIndexOf(6): ${array.lastIndexOf(6)}")
    println("array.subList(0,4): ${array.subList(0,4)}")//특정 인덱스 범위 요소 목록
    val arrayIterator=array.iterator()//list의 iteraotr 반환
    while(arrayIterator.hasNext()){//다음 요소 여부 확인
        print("${arrayIterator.next()} ")//다음 요소 얻기
    }
    println()

    //MutableCollection 멤버 메서드
    println("array.add(7): ${array.add(7)}")//특정 요소 추가 후 true 반환, 중복 값이면 false
    println("array.remove(1): ${array.remove(1)}")//특정 요소 삭제 후 true 반환, 없는 값이면 false
    println("array.remove(9): ${array.remove(9)}")
    //전달 컬렉션 추가 후 true 반환, 실패면 false
    println("array.addAll(arrayListOf(3,1,4)): ${array.addAll(arrayListOf(3,1,4))}")
    println(array)
    //전달 컬렉션 요소 모두 삭제 후 true 반환, 실패면 false
    println("array.removeAll(arrayListOf(1,2,3)): ${array.removeAll(arrayListOf(1,2,3))}")
    println(array)
    //전달 컬렉션만 소유 후 true 반환, 실패면 false
    println("array.retainAll(arrayListOf(4,5,6)): ${array.retainAll(arrayListOf(4,5,6))}")
    println(array)
    println("array.clear(): ${array.clear()}")//모든 요소 삭제
    println(array)
    println()

    //mutableListOf
    val mutable:MutableList<String> = mutableListOf("가", "나", "다", "라", "마", "바", "사","나")
    val mutableMixed = mutableListOf("가", 1, "다", 3, "마", 5, "사")
    println(mutable.javaClass.canonicalName)

    //Collection 멤버
    println("mutable size: ${mutable.size}")//list 크기
    println("mutable.isEmpty(): ${mutable.isEmpty()}")//list가 비어있으면 true
    println("mutable.contains(\"나\"): ${mutable.contains("나")}")//특정 요소 있으면 true
    //특정 컬렉션이 있으면 true
    println("mutable.containsAll(mutableListOf(\"가\", \"나\", \"다\")): " +
            "${mutable.containsAll(mutableListOf("가", "나", "다"))}")

    //List 주요 멤버 메서드
    println("mutable.get(3): ${mutable.get(3)}")//특정 인덱스 값 얻기
    println("mutable.indexOf(\"나\"): ${mutable.indexOf("나")}")//특정 요소가 중복되면 첫번째 요소의 인덱스. 없으면 -1
    println("mutable.indexOf(\"아\"): ${mutable.indexOf("아")}")
    println("mutable.lastIndexOf(\"나\"): " +
            "${mutable.lastIndexOf("나")}")//특정 요소가 중복되면 마지막 요소의 인덱스. 없으면 -1
    println("mutable.lastIndexOf(\"아\"): ${mutable.lastIndexOf("아")}")
    println("mutable.subList(0,4): ${mutable.subList(0,4)}")//특정 인덱스 범위 요소 목록
    val mutableIterator=mutable.iterator()//list의 iteraotr 반환
    while(mutableIterator.hasNext()){//다음 요소 여부 확인
        print("${mutableIterator.next()} ")//다음 요소 얻기
    }
    println()

    //MutableCollection 멤버 메서드
    println("mutable.add(\"아\"): ${mutable.add("아")}")//특정 요소 추가 후 true 반환, 중복 값이면 false
    println("mutable.remove(\"나\"): ${mutable.remove("나")}")//특정 요소 삭제 후 true 반환, 없는 값이면 false
    println("mutable.remove(\"자\"): ${mutable.remove("자")}")
    //전달 컬렉션 추가 후 true 반환, 실패면 false
    println("mutable.addAll(mutableListOf(\"타\", \"파\", \"하\")): " +
            "${mutable.addAll(mutableListOf("타", "파", "하"))}")
    println(mutable)
    //전달 컬렉션 요소 모두 삭제 후 true 반환, 실패면 false
    println("mutable.removeAll(mutableListOf(\"라\", \"마\", \"바\")): " +
            "${mutable.removeAll(mutableListOf("라", "마", "바"))}")
    println(mutable)
    //전달 컬렉션만 소유 후 true 반환, 실패면 false
    println("mutable.retainAll(mutableListOf(\"다\", \"나\", \"가\")): " +
            "${mutable.retainAll(mutableListOf("다", "나", "가"))}")
    println(mutable)
    println("mutable.clear(): ${mutable.clear()}")//모든 요소 삭제
    println(mutable)
    println()

    //불변형에서 가변형으로 변경. 이때 새로운 공간에서 가변형이 생성
    val list=listOf(1,2,3)
    //list[2]=2 //불변형이기에 변경 불가
    val listMutable=list.toMutableList()
    listMutable[2]=2//가변형으로 변경되어 값 변경 가능

    /*배열과 List 차이
    배열 - 클래스에 의해 생성. 메모리가 고정적. 제네릭에서 상하위관계가 성립하지 않는 무변성. 즉 Array<Int>와 Array<Number>는 무관
    List - 인터페이스를 특정 자료 구조로 구현. 해당 자료구조에 따라 성능이 상이. 자료구조에 따라 메모리 가변적.
    MutableList는 무변성이지만 List는 공병성.*/

}