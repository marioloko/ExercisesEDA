package recursianExercises;

public class FileSystemBrowserTest{
	public static void main(String[] arg){
		FileSystemBrowser browser = new FileSystemBrowser();
		browser.browseFiles("/home/adrian");
		browser.printNumberOfFiles();
		System.out.println();
		
		browser.browseFiles("/home/adrian/pruebasBrowser");
		browser.printNumberOfFiles();
	}
}