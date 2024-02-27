package collection

import java.util.*
import kotlin.collections.HashSet

fun main() {

    /*collection : 데이터를 모아 저장할 수 있는 자료 구조를 모아 높은 프레임 워크.
    종류로는 List, Set, Map 등. 불변형 가변형으로도 나뉨. 불변형은 읽기 전용. 가변형은 추가, 변경 가능*/

    /*Map: 키와 값의 쌍 형태로 이루어진 컬렉션. 키는 중복 불가지만 값은 중복 가능.
    키와 값은 모두 객체. 중복된 키를 저장하면 기존 값은 없어지고 새로운 값으로 대체.
    내부적으로 자바의 Map 이용. Collection 상속 X*/

    /*불변형 Map. mapOf() 헬퍼 함수로 불변형 Set 생성.
    size, keys, values, isEmpty(), containsKey(), containsValue(), get()등을 가짐*/
    val map: Map<String, Int> = mapOf("가" to 1, "나" to 2, "다" to 3, "라" to 4, "마" to 5)
    println(map.javaClass.canonicalName)
    
    println("map.size: ${map.size}")//map 크기
    println("map.isEmpty(): ${map.isEmpty()}")//map 비어있으면 true
    println("map.keys: ${map.keys}")//map 모든 키
    println("map.values: ${map.values}")//map 모든 값
    println("map[\"가\"]: ${map["가"]}")//특정 키의 값
    println("map.get(\"나\"): ${map.get("나")}")//특정 키의 값. 없으면 null
    println("map.contains(\"다\"): ${map.contains("다")}")//특정 키 있으면 true
    println("map.containsKey(\"라\"): ${map.containsKey("라")}")//특정 키 있으면 true
    println("map.containsValue(5): ${map.containsValue(5)}")//특정 값 있으면 true
    for((key, value) in map){//map의 키와 value 출력
        println("key = $key, value = $value")
    }
    println()

    /*가변형 Map. mutableMapOf() 헬퍼 함수로 가변형 Set 생성.
    put(), remove(), putAll(), clear() 등을 가짐*/
    val mutable : MutableMap<Int, String> = mutableMapOf(1 to "가", 2 to "나", 3 to "다", 4 to "라", 5 to "마")
    println(mutable.javaClass.canonicalName)

    println("mutable.size: ${mutable.size}")//map 크기
    println("mutable.isEmpty(): ${mutable.isEmpty()}")//map 비어있으면 true
    println("mutable.keys: ${mutable.keys}")//map 모든 키
    println("mutable.values: ${mutable.values}")//map 모든 값
    println("mutable[2]: ${mutable[1]}")//특정 키의 값
    println("mutable.get(2): ${mutable.get(2)}")//특정 키의 값. 없으면 null
    println("mutable.contains(3): ${mutable.contains(3)}")//특정 키 있으면 true
    println("mutable.containsKey(4): ${mutable.containsKey(4)}")//특정 키 있으면 true
    println("mutable.containsValue(\"마\"): ${mutable.containsValue("마")}")//특정 값 있으면 true
    for((key, value) in mutable){//map의 키와 value 출력
        println("key = $key, value = $value")
    }

    mutable.put(6, "바")//추가
    mutable[7]="사"//추가
    println(mutable)
    mutable.remove(4)//해당 키에 해당하는 요소 제거
    println(mutable)
    mutable.putAll(mutableMapOf(5 to "사", 8 to "아"))//주어진 데이터 갱신 및 추가
    println(mutable)
    mutable.clear()//모든 요소 제거
    println(mutable)
    println()

    /*hashMapOf(): 자바의 HashMap으로 해시 테이블을 통해 map 생성. HashMap 반환. 별도의 불변성 없음.
    해시 테이블을 내부적으로 키와 인덱스로 검색과 변경등을 빠르게 처리해주는 자료구조.
    다만 해시 값으로 요소를 찾아 검색 속도는 O(1)*/
    val hashMap : HashMap<Int, String> = hashMapOf(1 to "A", 2 to "B", 3 to "C")
    println(hashMap)
    println(hashMap.javaClass.canonicalName)
    hashMap.put(4, "D")//변경 가능
    hashMap.remove(1)
    println(hashMap)
    println()

    /*sortedMapOf(): 자바의 SortedMap으로 정렬된 상태의 가변성 Map 생성.
    TreeMap 자료구조 사용. 기본적으로 키에대한 오름차순 정렬.
    HashMap보다 성능이 떨어지고 추가, 삭제시 시간이 걸리지만 검색과 정렬에 뛰어남.
    */
    val treeMap: SortedMap<Int, String> = sortedMapOf(4 to "D", 5 to "E", 6 to "F")
    println(treeMap)
    println(treeMap.javaClass.canonicalName)
    treeMap.put(7, "G")//변경 가능
    treeMap.remove(4)
    println(treeMap)
    println()

    /*linkedMapOf():링크드 리스트로 구현한 해시 테이블로 생성하여 지정된 순서에 값이 정렬된 Map.
    링크드 리스트는 각 노드가 데이터 포인터를 가지고 한 줄로 연결된 상태로 데이터를 저장한 구조.
    단순 검색 시 순차적으로 탐색하여 O(n) 시간이 걸려 성능이 느리지만 메모리 저장 공간을 효율적으로 사용 가능.
    자바의 LinkedHashMap 반환. 가변성 Map.
    */
    val linkedMap: LinkedHashMap<Int, String> = linkedMapOf(7 to "G", 8 to "H", 9 to "I")
    println(linkedMap)
    println(linkedMap.javaClass.canonicalName)
    linkedMap.put(10, "J")//변경 가능
    linkedMap.remove(8)
    println(linkedMap)
    println()

}