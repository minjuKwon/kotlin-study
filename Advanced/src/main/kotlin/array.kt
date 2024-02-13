import java.util.*

fun main() {

    /*배열 : 데이터를 연속적으로 나열한 형태. 코틀린에서는 동일한 자료형뿐만 아니라
    여러 자료형으로 구성가능. 배열 이름은 메모리 주소를 의미.*/
    
    val nums1=arrayOf(1,2,3)
    println(nums1)
    for(num in nums1){
        print("$num ")
    }
    println()
    val nums2=Array(3,{i->i+2})//배열크기, 초깃값(표현식).
    for(num in nums2){
        print("$num ")
    }
    println()
    val nums3=Array(3, {0} )//0으로 채움
    for(num in nums3){
        print("$num ")
    }
    println()
    val nums4=arrayOfNulls<Int>(3)//null로 초기화된 int 배열
    for(num in nums4){
        print("$num ")
    }
    println()
    println()

    /*다차원 배열. 2차원 이상의 배열*/
    val arr1=arrayOf(1,2,3)
    val arr2=arrayOf(4,5,6)
    val arr3=arrayOf(7,8,9)
    val arrs1=arrayOf(arr1, arr2, arr3)
    val arrs2=arrayOf(arrayOf(1,2), arrayOf(3,4), arrayOf(5,6))
    for(e1 in arrs1){
        for(e2 in e1){
            print("$e2 ")
        }
        println()
    }
    println()
    val arr3rd= arrayOf(arrs1, arrs2)

    /*평탄화 : 다차원 배열을 일차원 배열로 변환*/
    val arrFlatten=arrs1.flatten()
    println(arrFlatten)
    println()
    
    /*배열 자료형*/
    //혼합 자료형 배열
    val arrMix=arrayOf(1,2,"3","4",true)
    //자료형 제한 배열
    val arrInt1=arrayOf<Int>(5,6)
    //내부적으로 기본형 배열 생성
    val arrInt2=intArrayOf(7,8)//내부적으로 int[] 반환
    val arrChar= charArrayOf('a','b','c')
    //Any형 배열. 자료형이 지정된 배열은 다른 자료형으로 변환 불가.
    //Any형 배열은 다른 자료형 지정 가능
    val arrAny=arrayOf<Any>(2,2,1)
    arrAny[0]="1"
    arrAny[2]=3.14

    /*배열 요소 접근*/
    println(arrInt2[0])//연산자 오버로딩으로 정의되어 대괄호로 접근 가능
    println(arrInt2.get(0))//요소 접근 위한 getter
    println(arrs1[1][2])
    println("arrInt2[0]: ${arrInt2[0]}, arrInt2[1]: ${arrInt2[1]}, arrs1[1][2]: ${arrs1[1][2]}")
    arrInt2[0]=9
    arrInt2.set(1,7)//인덱스 1번 요소 값을 7로 교체
    arrs1[1][2]=8
    println("arrInt2[0]: ${arrInt2[0]}, arrInt2[1]: ${arrInt2[1]}, arrs1[1][2]: ${arrs1[1][2]}")
    println()

    /*배열 출력*/
    for(num in arr1){
        print("$num ")
    }
    println()
    for(i in 0..arr1.size-1){
        print("${arr1[i]} ")
    }
    println()
    for(i in 0 until arr1.size){
        print("${arr1[i]} ")
    }
    println()
    for(i in arr1.indices){
        print("${arr1[i]} ")
    }
    println()
    println(Arrays.toString(arr1))
    println(Arrays.deepToString(arrs1))
    arr1.forEach { i->print("$i ") }
    println()
    arr1.forEachIndexed { index, i -> print("arr[$index]: $i ") }
    println()
    val iterator:Iterator<Int> = arr1.iterator()
    while(iterator.hasNext()){
        print("${iterator.next()} ")
    }
    println()
    println()

    /*배열 요소 처리*/
    //배열은 메모리에 고정되기때문에 새로운 배열을 생성하여 기타 기능 처리
    val arr4=arr1.plus(4)//arr1에 4 추가된 새로운 배열 생성
    println(Arrays.toString(arr4))
    val arr5=arr4.sliceArray(1..3)//arr4의 특정 범위를 잘라낸 배열 생성
    println(Arrays.toString(arr5))

    println(arr5.first())//배열의 첫번째 요소
    println(arr5.last())//배열의 마지막 요소
    println(arr5.indexOf(3))//배열의 특정 요소 인덱스 출력. 값이 3인 요소 인덱스 출력
    println(arr5.average())//배열의 평균값
    println(arr5.count())//배열 요수 개수

    val arrReversal=arr5.reversedArray()//기존 배열의 뒤집은 형태
    println(Arrays.toString(arrReversal))

    arrReversal.fill(1)//배열의 모든 요소를 특정 값으로 대체
    println(Arrays.toString(arrReversal))
    
    println(arrReversal.contains(3))//배열에 특정 값 포함 여부 확인
    println(1 in arrReversal)//배열에 특정 값 포함 여부 확인
    when{
        1 in arrReversal->println("1이 있다")//특정 요소 값에 따른 처리
    }
    println()

    /*정렬*/
    val arr6=arrayOf(4,1,8,5,3,7)
    val sortedArray=arr6.sortedArray()//새로운 배열에 오름차순 정렬된 배열 할당(원본 배열 변화X)
    println("arr6 오름: "+Arrays.toString(arr6))
    println("sortedArray 오름: "+Arrays.toString(sortedArray))
    val sortedArrayDesc=arr6.sortedArrayDescending()//새로운 배열에 내림차순 정렬된 배열 할당(원본 배열 변화X)
    println("arr6 내림: "+Arrays.toString(arr6))
    println("sortedArrayDesc 내림: "+Arrays.toString(sortedArrayDesc))

    arr6.sort(2,5)//특정 인덱스 구간의 오름차순 원본 배열 정렬. 두 번째 인덱스는 포함 X. 실제로 2~3 구간 배열
    println("arr6[2..5] 오름: "+Arrays.toString(arr6))
    arr6.sortDescending()//원본 배열 내림차순 정렬
    println("arr6 내림: "+Arrays.toString(arr6))
    arr6.sort()//원본 배열 오름차순 정렬
    println("arr6 오름: "+Arrays.toString(arr6))
    arr6.sortDescending(1,5)//특정 인덱스 구간의 내림차순 원본 배열 정렬. 두 번째 인덱스는 포함 X. 실제로 1~4 구간 배열
    println("arr6[1..5] 내림: "+Arrays.toString(arr6))

    val sorted:List<Int> = arr6.sorted()//리스트로 반환하며 오름차순 정렬
    println("list: "+sorted)
    val sortedDesc:List<Int> = arr6.sortedDescending()//리스트로 반환하며 내림차순 정렬
    println("sortedDesc: "+sortedDesc)

    val colors= arrayOf("Red","Blue","GREEN","ORANGE")
    colors.sortBy { color->color.length }//특정 기준으로 오름차순 정렬
    println("문자 길이 오름차순: "+Arrays.toString(colors))
    colors.sortByDescending { color->color.length }//특정 기준으로 내림차순 정렬
    println("문자 길이 내림차순: "+Arrays.toString(colors))
    //sortBy 대신 sortedBy, sortByDescending 대신 sortedByDescending을 쓰면 List로 변환
    println()

    var coffees=arrayOf(
        Coffee("Americano", 2000),
        Coffee("Latte",4000),
        Coffee("Cappuccino",3000),
        Coffee("Macchiato",3300),
        Coffee("Espresso",1800)
    )
    coffees.sortBy { it.price }//가격순으로 정렬. 매개변수가 람다로 받아 소괄호 생략 가능
    coffees.forEach { println(it) }//매개변수가 람다로 받아 소괄호 생략 가능
    println()

    coffees=arrayOf(
        Coffee("Americano", 2000),
        Coffee("Latte",4000),
        Coffee("Latte-Vanilla",4300),
        Coffee("Cappuccino",3000),
        Coffee("Macchiato",3300),
        Coffee("Espresso",1800)
    )
    //Comparator으로 정렬
    coffees.sortWith(
        Comparator{c1, c2->
            when{
                c1.price>c2.price->1
                c1.price==c2.price->0
                else->-1
            }
        }
    )
    coffees.forEach { println(it) }
    println()
    //이름순. 이름이 동일한 경우 가격 순. Comparator 대신 compareBy() 사용 가능
    coffees.sortWith(compareBy({it.name},{it.price}))
    coffees.forEach { println(it) }
    println()

    /*배열 필터링*/
    //filter는 List 타입으로 반환. List타입은 메소드를 연속적으로 연결하여 사용 가능.
    //sortedBy도 List타입으로 반환. 이렇게 여러 메소드를 연속해서 호출하는 방식을 메서드 체이닝이라함
    coffees.filter{ e -> e.price <= 3000 }.sortedBy{it.name}.forEach { e->print("$e ")}//커피 가격이 3000이하만 필터링
    println()
    println(coffees.minBy { it.price })//특정 요소의 최저값
    println(coffees.maxBy { it.price })//특정 요소의 최고값

}

data class Coffee(val name:String, val price:Int)