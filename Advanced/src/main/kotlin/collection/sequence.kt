package collection

fun main() {

    /*시퀀스 : 요소의 크기를 나중에 결정할 수 있는 순차적인 컬렉션.
    중간 처리 없이 마지막 메소드 때 모든 연산 계산 처리. */

    //시드 값 = 초기 값. 람다식으로 다음 요소들 정의.
    //즉, 1로 시작하고 2배씩 커지는 시퀀스 정의.
    val numbers:Sequence<Int> = generateSequence(1){it*2}
    println(numbers.take(5).toList())
    println()

    /* map 같이 새로운 컬렉션을 반환하는 메소드들을 연속적으로 연결하여 사용하면 각 메소드가 끝날 때 마다
    새로운 컬렉션을 만들어 냄. 즉 한 메소드가 반환한 컬렉션을 다음 메소드로 전달하는 형태.
    이런 형태는 메모리나 속도 낭비를 야기하기에 이를 해결해주는 병렬 처리 asSequence() 사용.

    다만 크기가 작은 컬렉션에서의 사용은 부적절함. filter()같은 함수는 인라인으로 실행되기에 큰 부담이 되지 않음.
    하지만 시퀀스를 사용하면 한 번 계산된 연산은 람다식을 저장하는 객체로 표현되며 중간 결과가 메모리에 저장됨.
    이는 인라인 함수에 최적화 되지 않으며 불필요한 메모리 사용 증가. 또한 시퀀스를 인자로 넘기면 람다 저장하는 객체가 추가로 필요해짐.*/

    //기본 메서드 체이닝
    //map 연산을 끝내고 이를 filter로 전달하여 처리
    val list= listOf(1,2,3,4,5)
    val result1=list
        .map { println("map($it)");it*3 }
        .filter { println("filter($it)"); it%2==1 }
    println(result1)
    println()

    //시퀀스 메서드 체이닝
    //toList() 때 모든 연산이 수행되어 새로운 리스트 반환.
    //즉, map()과 filter()가 연속적으로 수행
    val result2=list.asSequence()
        .map { println("map($it)");it*3 }
        .filter { println("filter($it)"); it%2==1 }
        .toList()
    println(result2)
    println()

    val fibonacci = generateSequence(1 to 1){it.second to it.first+it.second}.map { it.first }
    println(fibonacci.take(10).toList())

}