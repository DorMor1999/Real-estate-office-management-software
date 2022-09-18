package View;



public abstract class NewWindow {
	
	protected String windowTitle;
	protected String windowText;
	
	public NewWindow(String windowTitle, String windowText) {
		super();
		this.windowTitle = windowTitle;
		this.windowText = windowText;
	}
	
	public abstract void display();

}
