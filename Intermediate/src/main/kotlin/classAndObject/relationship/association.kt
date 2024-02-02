package classAndObject.relationship

fun main() {

    /*연관관계 : 서로 분리된 클래스의 연결 관계. 단방향, 양방향 모두 해당 가능.
    서로 독립적인 생명주기를 가짐. 서로 클래스 참조 유지. 약한 관계. 단순히 다른 객체를 이용*/

    //서로 양방향으로 참조. 각자의 생명주기를 가짐
    val student=Student("student1")
    val teacher=Teacher("teacher1")
    student.classTeacher(teacher)
    teacher.studentInCharge(student)

}

class Student(val name:String){
    fun classTeacher(t:Teacher){
        println("Student : $name, Teacher : ${t.name}")
    }
}

class Teacher(val name:String){
    fun studentInCharge(s:Student){
        println("Teacher : $name, Student : ${s.name}")
    }
}