import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

fun main() {

    /*
    -표준 출력: print(), println()는 내부적으로 자바의 System.out.print, System.out.println() 호출.
    System.out 라이브러리 사용.

    -표준 입력: readLine()는 내부 readLine() 호출. 내부 readLine() 매개변수로 InputStream, CharsetDecoder 사용.
    InputStream는 바이트 배열에서 데이터를 읽는 입력 스트림. 매개변수 InputStream에 표준 입력 System.in 사용.
    readLine()는 String 형을 리턴하기에 필요 시 형변환해야 됨. Scanner를 이용하여 입력 받을 수도 있음.
    이때는 nextInt(), nextLine() 등 다양한 자료형을 받는 멤버 존재.
    */

    /*io(기본 입출력 패키지) vs nio(io 패키지에 확장된 패키지)
    ▶입출력 - io: 스트림 방식. 강물에 흘러가는 것처럼 데이터가 머물지 않고 전달. 입출력 구분.
            nio: 채널 방식. 여러 수로 사용해 병목 현상 줄임. 양방향으로 입출력 구분 X
    ▶버퍼방식 - io: 넌버퍼. 스트림방식으로 1바이트 쓰고 읽어 속도 느림. 버퍼와 병합해 사용하는
                   BufferedInputStream, BufferedOutputStream 제공.
             nio: 버퍼. 송수신 사이 임시적 공간이 있어 더 유연한 처리 가능. 다수의 데이터 처리 가능.
    ▶비동기지원 - io: 안 함(블록킹). 공간이 비워지거나 채워지기전까지 쓰거나 읽을 수 없어 대기.
               nio: 지원(넌블로킹). 스레드나 비동기로 별개의 흐름으로 작업. 다른 작업 진행 가능.
    */

    /*Files: File 개선한 클래스. 파일과 디렉토리 조작을 위한 static 메서드 제공. java.nio.file에 속함. */
    var path="D:\\Study\\Kotlin\\newFile.txt"//파일 생성할 경로
    var text="I study kotlin IO"//파일에 저장할 내용
    //파일 생성 시 에러 발생 위험이 있기에 예외 처리 필수.
    try {
        Files.write(
            Paths.get(path), //지정된 문자열로 파일 경로 얻음. Uri로 얻을 수도 있음.
            text.toByteArray(), //바이트 배열로 제공해야됨.
            StandardOpenOption.CREATE//파일 생성 옵션. 파일이 없으면 새 파일 생성. READ,WRITE,APPEND 도 있음.
        )
    }catch (e:IOException){}

    /*FileWriter: 문자 스트림. File, Files 달리 바이트가 아닌 문자 단위로 출력.*/
    val fileWriter= FileWriter(
        path,//파일 경로
        true//이어쓰기 여부. 기존 파일이 있으면 내용 끝에 데이터 추가. false 시 덮어씀.
    )
    text="\nFileWriter1"
    try {
        fileWriter.write(text)
    }catch (e:Exception){

    }finally {
        fileWriter.close()
    }
    //use 사용 시 자동으로 close
    text="\nFileWriter2"
    try {
        FileWriter(path,true).use { it.write(text) }
    }catch (e:Exception){ }

    /*출력*/

    //PrintWriter: print(), printf(), println(), write() 등
    //자바에서 문자 기반의 다양한 출력 메소드 제공. null도 출력 가능.
    path="D:\\Study\\Kotlin\\printWriter.txt"
    text="PrintWriter"
    File(path)
        .printWriter()//자바의 PrintWriter 리턴
        .use { it.println(text);}

    //BufferedWriter: 버퍼를 사용해 출력. 메모리 특정 공간에 저장 후 파일로 저장.
    //null 출력 시 NPE 발생.
    path="D:\\Study\\Kotlin\\bufferedWriter.txt"
    text="bufferedWriter"
    File(path)
        .bufferedWriter()//자바의 BufferedWriter 리턴
        .use { it.write(text)}

    //감싼 메서드: 기존 메서드를 기능을 추가하여 감싼 메서드.
    //writeText(), appendText(). 내부적으로 use()사용하여 close() 호출 불필요.
    path="D:\\Study\\Kotlin\\write.txt"
    text="writeText\n"
    val file=File(path)
    file.writeText(text)
    file.appendText("append")

}