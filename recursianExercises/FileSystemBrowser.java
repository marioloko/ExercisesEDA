package recursianExercises;

import java.io.File;


public class FileSystemBrowser{
	
	private int numberOfFiles;
	private int numberOfDirectories;
	
	/**
	 * Print the number of files and directories
	 */
	public void printNumberOfFiles(){
		System.out.println("The number of files is: "+numberOfFiles);
		System.out.println("The number of directories is: "+numberOfDirectories);
	}
	
	/**Initialize the process of browse files starting from zero the number of files and directories
	 * 
	 * @param parentPath: The root path from where start to search for all the sub files.
	 */
	public void browseFiles(String parentPath){
		numberOfFiles = 0;
		numberOfDirectories = 0;
		browseFilesProcess(parentPath);
	}
	
	/**Search inside the current directory and in the subdirectories of them. the number of files and directories.
	 * Print each directory and file with a label that indicates if it is a file or a directory.
	 * 
	 * @param parentPath: The root path from where start to search for all the sub files
	 */
	private void browseFilesProcess(String parentPath){
		  
		if((parentPath!=null)&&(parentPath.length()!=0)){ //Check if a valid String has been introduced
			File startingDirectory = new File(parentPath); //Start from the directory indicated in the parent path

			if(startingDirectory!=null){ //Check if the file exist
				
				if(startingDirectory.canRead()){ 
					File[] filesInTheCurrentDirectory = startingDirectory.listFiles(); //If the user has reading permission store each File in a File[] array

					for(int pos=0;pos<filesInTheCurrentDirectory.length;pos++){

						File followingDirectoryOrFile = new File(filesInTheCurrentDirectory[pos].getAbsolutePath()); //Create a new File for each subdirectory or file

						System.out.print(followingDirectoryOrFile.getAbsolutePath());
						System.out.print(" --> ");

						if(followingDirectoryOrFile.isDirectory()){
							System.out.println("Directory");
							numberOfDirectories++;
							browseFilesProcess(followingDirectoryOrFile.getAbsolutePath()); //If the file is a directory call the recursive function with the path of the subdirectory,
																					  		//and add the number of files in that directory to the number of files in the current directory
						}else{
							System.out.println("File");
							numberOfFiles++;
						}
					}
				}
			}
		}
	}
	
}