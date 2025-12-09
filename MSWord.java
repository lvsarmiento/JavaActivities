package M2_Activity5;

public class MSWord extends Program {
/*	
	public MSWord(String name) {
		this.setName(name);
	}
*/	
	public MSWord(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		System.out.println("Opening MS Word...");
		this.setIsRunning(true);
	}
	
	@Override
	public void stop() {
		System.out.println("Stopping MS Word...");
		this.setIsRunning(false);
	}

/*
	@Override
	public void checkProgramStatus() {
		System.out.println("Program MS Word is running...");
	}
	
	public boolean getIsRunning() {
		return false;
	}
	
*/
}
