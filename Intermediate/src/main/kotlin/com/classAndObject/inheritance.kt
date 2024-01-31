package com.classAndObject

fun main() {

    /*상속 : 자식 클래스가 부모 클래스의 속성과 기능을 물려받음.
    부모 클래스 외의 프로퍼티와 메서드 추가 가능
    코틀린의 모든 클래스는 상위 클래스를 별도로 표시하지 않으면 Any 클래스를 상속.*/
    val shape=Shape(2,4,"red")
    val rectangle=Rectangle(10,10,"green")
    val circle=Circle(20,20,"blue",5)

    println("shape : ${shape.x}, ${shape.y}, ${shape.color}")
    shape.figure()
    shape.position()
    println("rectangle : ${rectangle.x}, ${rectangle.y}, ${rectangle.color}")
    println("rectangle : ${rectangle.toString()}")
    rectangle.figure()
    println("rectangle area is ${rectangle.area()}")
    println("rectangle area is ${rectangle.area(2,5)}")
    println("circle : ${circle.x}, ${circle.y}, ${circle.r}, ${circle.color}")
    circle.figure()
    circle.radius()

    /*다향성 : 하나로 다양한 작업 처리. 상속 관계에서의 인스턴스 호환성 활용 가능*/

    //Up Casting: 하위 클래스 인스턴스를 상위 클래스 타입으로 선언. 상위클래스로 변환
    //상위 클래스 Shape 타입의 하위 클래스 Circle 생성
    val c:Shape=Circle(28,28,"pink",2)
    //상위 클래스 타입이라도 하위 클래스 인스턴스를 참조하기에
    //오버라이딩 된 하위 클래스 Circle figure() 호출
    c.figure()
    //c.radius()//상위 클래스 타입으로 선언하였기에 하위 클래스 메소드 호출 불가능

    //Down Casting:하위 클래스로 변환
    //변수가 제시한 자료형으로 호환되는지 체크하고 변환해줌
    //단, if문 안에서만 변환 적용. 정확히는 변환이 아니라 if문 내에서 해당 자료형으로 반환해줌.
    if(c is Circle){
        c.radius()
    }
    //c.radius() //if 문 밖에서는 다시 radius() 사용 불가능
    c as Circle //변수 자체를 바로 Circle 타입으로 변환
    c.radius()

}