
package ch문제; // 현재 클래스가 포함된 패키지를 선언 (한글 패키지명은 오류를 유발할 수 있으므로 영어 사용 권장)

import java.util.Scanner; // java.util 패키지에서 Scanner 클래스를 불러옴(사용자 입력을 받을 수 있도록 함)

public class C01 { // C01 클래스 선언 (자바에서 실행되는 모든 프로그램은 클래스 내부에서 작성됨)
 // public → 이 클래스는 어디서든 접근 가능 (공개 클래스)
 // class C01 → 클래스 이름이 C01 (파일명과 동일해야 함)

 public static void main(String[] args) { 
     // public → 프로그램 어디에서든 접근 가능
     // static → 프로그램이 실행될 때 JVM이 자동으로 실행할 수 있도록 설정
     // void → 이 메서드는 리턴값을 반환하지 않음
     // main(String[] args) → 프로그램 실행 시 명령행 인자를 받을 수 있는 기본 메서드

     Scanner sc = new Scanner(System.in); 
     // Scanner sc → Scanner 타입의 객체 sc 생성
     // new Scanner(System.in) → System.in(키보드 입력)과 연결된 Scanner 객체를 생성하여 사용자 입력을 받을 수 있도록 함

     System.out.print("높이를 입력하세요 : "); 
     // System.out.print(...) → 화면에 "높이를 입력하세요 : "를 출력 (줄 바꿈 X)
     // print는 줄 바꿈 없이 출력
     // println을 사용하면 자동 줄 바꿈

     int height = sc.nextInt(); 
     // sc.nextInt() → 사용자가 입력한 정수 값을 읽음
     // int height → 입력받은 값을 height 변수에 저장
     // 사용자가 문자가 아닌 숫자가 아닌 값을 입력하면 오류 발생 가능 (예외 처리 필요)

     for (int i = 0; i < height; i++) { 
         // for → 반복문 사용
         // int i = 0 → 변수 i를 0부터 시작
         // i < height → i가 height보다 작을 동안 실행 (즉, 사용자가 입력한 높이만큼 반복)
         // i++ → 한 번 실행될 때마다 i 값을 1 증가

         for (int j = height; j > i + 1; j--) { 
             // int j = height → j를 height로 초기화 (최대 개수부터 시작)
             // j > i + 1 → j가 i + 1보다 클 동안 반복
             // j-- → j를 1씩 감소
             // 이 반복문은 왼쪽 공백을 출력하여 피라미드를 가운데 정렬하는 역할

             System.out.print(" "); 
             // " " → 공백 하나를 출력
             // 줄 바꿈(println)이 없으므로 같은 줄에 계속 공백이 출력됨
         }

         for (int j = 0; j < 1 + (i * 2); j++) { 
             // j = 0 → j를 0으로 초기화 (처음부터 별 출력)
             // j < 1 + (i * 2) → j가 (1 + i * 2)보다 작을 동안 반복
             // 1, 3, 5, 7, 9, ... 개의 별을 출력하도록 설계됨
             // 예) i = 0이면 1개, i = 1이면 3개, i = 2이면 5개 별을 출력

             System.out.print("*"); 
             // "*" → 별을 한 개 출력
             // print를 사용하여 줄 바꿈 없이 별을 나란히 출력
         }

         System.out.println(); 
         // println()을 사용하여 한 줄을 완성한 후 다음 줄로 이동
         // 즉, 공백과 별을 출력한 후 개행(줄 바꿈)
     }
 }
}

