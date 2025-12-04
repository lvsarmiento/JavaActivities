package OOP1;

public class activity1oop1 {

	public static void main(String[] args) {

		book myBook = new book();
		
		myBook.title = "Programming 101";
		myBook.defineBook();
		
	//	System.out.println("My new book is " + myBook.title);
		
		house myHouse = new house();
		
		myHouse.address = "Manila, Philippines";
		myHouse.loc();
		
		tree myTree = new tree();
		
		myTree.treeName = "Apple Tree";
		myTree.defineTree();

	}

}
