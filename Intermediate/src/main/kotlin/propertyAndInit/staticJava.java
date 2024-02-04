package propertyAndInit;

public class staticJava {
    static final String NAME="KIM";
    static void greeting(){
        System.out.println("Hello");
    }
   public static void main(String[]args){
        System.out.println(Student.id);
        Student.study();
        Student.Companion.goSchool();//애노테이션 없이 메소드 접근 방법
        System.out.println(Student.grade);
        Job job=Student.job;
        System.out.println(job.getJob());//프로퍼티를 접근하였기에 getter,setter도 사용 가능
        job.setJob("worker");
       System.out.println(Student.job.getJob());
   }
}