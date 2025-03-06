package ch12;

class TV{
	int size;
	TV(int size){
		this.size = size;
	}
}

class ColorTV extends TV{
	int color;
	ColorTV(int size, int color){
		super(size);
		this.color = color;
	}
	
	void printProperty() {
		System.out.printf("%d인치 %d컬러\n",this.size,this.color);
	}
}


public class C04문제 {

	public static void main(String[] args) {
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty(); // 32인치 1024컬러 가 나오면 해결!

	}

}
