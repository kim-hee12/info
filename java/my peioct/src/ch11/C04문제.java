package ch11;
//다음 2개의 static 가진 ArrayUtils 클래스를 만들어보자. 다음 코드의 실행 결과를 참고하여 concat()와 print()를 작성하여 ArrayUtil 클래스를 완성하라.

class ArrayUtils {
	
	public static int[] concat(int[] a, int[] b) {
		/* 배열 a와 b를 연결한 새로운 배열 리턴 */
		
		if(a == null)
			a = new int[0];
		if(b == null)
			b = new int[0];
		
	int[] result = new int[a.length + b.length];
	
	System.arraycopy(a, 0, result, 0, a.length);
    System.arraycopy(b, 0, result, a.length, b.length);

    return result;
	}
	
    public static void print(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("배열이 비어 있습니다.");
            return;
        }
        
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

	}


}

public class C04문제 {

	public static void main(String[] args) {
		
		int[] array1 = { 1, 5, 7, 9 };
		int[] array2 = { 3, 6, -1, 100, 77 };
		int[] array3 = ArrayUtils.concat(array1, array2);
		ArrayUtils.print(array3);
	}
}