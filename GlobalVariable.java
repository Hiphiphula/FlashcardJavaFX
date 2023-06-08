package application;

import java.io.File;

public class GlobalVariable {
	static File fileDirectory;
	
	public static File getFileDirectory() {
		return fileDirectory;
	}

	public static void setFileDirectory(File temp) {
		fileDirectory = temp;
	}
	
	public static String filee()
	{
		return fileDirectory.getPath();
	}
	
}
