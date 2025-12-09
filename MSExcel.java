package M2_Activity5;

public class MSExcel extends Program {
	
	public MSExcel(String name) {
		this.setName(name);
	}


	@Override
	public void run() {
		String message = "Opening MS Excel...";
		System.out.println(message);
		this.setIsRunning(true);
	}
	
	@Override
	public void stop() {
		String message = "Stopping MS Excel...";
		System.out.println(message);
		this.setIsRunning(false);
	}

/*
	@Override
	public void checkProgramStatus() {
		String message = "Program MS Excel is running...";
		System.out.println(message);
	}

	@Override
	public boolean getIsRunning() {
		return false;
	}
*/
}
