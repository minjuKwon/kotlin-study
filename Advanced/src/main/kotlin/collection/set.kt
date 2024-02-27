package collection

import java.util.*
import kotlin.collections.HashSet

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

    /*Set : 순서 없는 요소들의 집합를 나타내는 컬렉션. 집합이므로 중복된 값 불가*/

    /*불변형 Set. setOf() 헬퍼 함수로 불변형 Set 생성.*/
    val setMixed= setOf("1",2,3,"4")
    val set:Set<Int> = setOf(1,2,3,3,4,5,5)
    println(set)//중복 요소 제거
    println(set.javaClass.canonicalName)

    //Collection 멤버
    println("set size: ${set.size}")//set 크기
    println("set.isEmpty(): ${set.isEmpty()}")//set 비어있으면 true
    println("set.contains(2): ${set.contains(2)}")//특정 요소 있으면 true
    //특정 컬렉션이 있으면 true
    println("set.containsAll(setOf(1,2,3,3)): " +
            "${set.containsAll(setOf(1,2,3))}")
    println()

    /*가변형 Set. mutableSetOf() 헬퍼 함수로 가변형 Set 생성.
    MutableSet 반환하지만 내부적으로 자바의 LinkedHashSet 생성*/
    val setMutable: MutableSet<Int> = mutableSetOf(1,2,3,4,5)
    println(setMutable.javaClass.canonicalName)

    //Collection 멤버
    println("setMutable size: ${setMutable.size}")//set 크기
    println("setMutable.isEmpty(): ${setMutable.isEmpty()}")//set 비어있으면 true
    println("setMutable.contains(2): ${setMutable.contains(2)}")//특정 요소 있으면 true
    //특정 컬렉션이 있으면 true
    println("setMutable.containsAll(setOf(1,2,3,3)): " +
            "${setMutable.containsAll(setOf(1,2,3))}")

    //MutableCollection 멤버 메서드
    println("setMutable.add(7): ${setMutable.add(7)}")//특정 요소 추가 후 true 반환, 중복 값이면 false
    println("setMutable.add(5): ${setMutable.add(5)}")//특정 요소 추가 후 true 반환, 중복 값이면 false
    println("setMutable.remove(1): ${setMutable.remove(1)}")//특정 요소 삭제 후 true 반환, 없는 값이면 false
    println("setMutable.remove(8): ${setMutable.remove(8)}")
    //전달 컬렉션 추가 후 true 반환, 실패면 false
    println("setMutable.addAll(setOf(6,8,9)): " +
            "${setMutable.addAll(setOf(6,8,9))}")
    println(setMutable)
    //전달 컬렉션 요소 모두 삭제 후 true 반환, 실패면 false
    println("setMutable.removeAll(setOf(3,5)): " +
            "${setMutable.removeAll(setOf(3,5))}")
    println(setMutable)
    //전달 컬렉션만 소유 후 true 반환, 실패면 false
    println("setMutable.retainAll(setOf(2,4,6)): " +
            "${setMutable.retainAll(setOf(2,4,6))}")
    println(setMutable)
    println("setMutable.clear(): ${setMutable.clear()}")//모든 요소 삭제
    println(setMutable)
    println()

    /*hashSetOf(): 자바의 HashSet 컬렉션으로 해시 테이블을 통해 set 생성.
    해시 테이블을 내부적으로 키와 인덱스로 검색과 변경등을 빠르게 처리해주는 자료구조.
    HashSet 반환. 별도의 불변성 없음. 입력 순서와 중복 요소 무시. 별개의 정렬 기능 없음.
    다만 해시 값으로 요소를 찾아 검색 속도는 O(1)*/
    val hashSet : HashSet<Int> = hashSetOf(3,2,1,4,5)
    println(hashSet)
    println(hashSet.javaClass.canonicalName)
    hashSet.add(6)//변경 가능
    hashSet.remove(1)
    println(hashSet)
    println()

    /*sortedSetOf(): 자바의 TreeSet 컬렉션으로 정렬된 상태의 가변성 Set 생성.
    TreeSet는 개선된 이진 탐색 트리인 레드 블랙 트리 알고리즘을 사용한 자료구조.
    레드 블랙 트리는 부모 노드보다 작은 값은 왼쪽, 큰 값은 오른쪽으로 배치하여
    데이터 추가, 삭제 시 트리가 한쪽으로 치우쳐지지 않도록 균형을 맞춰주는 구조.
    HashSet보다 성능이 떨어지고 추가, 삭제시 시간이 걸리지만 검색과 정렬에 뛰어남.
    */
    val treeSet: TreeSet<Int> = sortedSetOf(7,1,2,4)
    println(treeSet)
    println(treeSet.javaClass.canonicalName)
    treeSet.add(6)//변경 가능
    treeSet.remove(1)
    println(treeSet)
    println()

    /*linkedSetOf():링크드 리스트로 구현한 해시 테이블로 생성하여 지정된 순서에 값이 정렬된 Set.
    링크드 리스트는 각 노드가 데이터 포인터를 가지고 한 줄로 연결된 상태로 데이터를 저장한 구조.
    단순 검색 시 순차적으로 탐색하여 O(n) 시간이 걸려 성능이 느리지만 메모리 저장 공간을 효율적으로 사용 가능.
    자바의 LinkedHashSet 반환. 가변성 Set.
    */
    val linkedSet: LinkedHashSet<Int> = linkedSetOf(8,5,2,4)
    println(linkedSet)
    println(linkedSet.javaClass.canonicalName)
    linkedSet.add(6)//변경 가능
    linkedSet.remove(4)
    println(linkedSet)

}