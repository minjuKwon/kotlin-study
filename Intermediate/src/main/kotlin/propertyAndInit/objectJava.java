package propertyAndInit;

public class objectJava {
    public static void main(String[]args){
        //코틀린의 object으로 생성된 인스턴스 접근하기 위해 INSTANCE 사용
        System.out.println(Worker.INSTANCE.getName());
        System.out.println(Worker.INSTANCE.getAddress());
        System.out.println(Worker.INSTANCE.getAddress().getAddress());
        Worker.INSTANCE.greeting();
    }
}
