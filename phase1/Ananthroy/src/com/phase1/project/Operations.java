package com.phase1.project;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operations {

	public void listAllFiles(String path) {
		//checking various conditions
		if (path == null || path.isEmpty() || path.isBlank())
			throw new NullPointerException("Path cannot be Empty or null");
		File dir = new File(path);
     	if(!dir.exists())
			throw new IllegalArgumentException("Path does not exist");
		if(dir.isFile())
			throw new IllegalArgumentException("The given path is a file. A directory is expected.");

try {
	
	 File f = new File(path);
     File[] files = f.listFiles();
     System.out.println("Files are:");
     for (int i = 0; i < files.length; i++) {
         System.out.println(files[i].getName());	
     }
     System.out.println("\nTotal Number of files: "+ files.length);	
 }
 catch (Exception e) {
     System.err.println(e.getMessage());
 }
	}

	
	
	public void createNewFile(String path , String fileName) throws IOException {
		
		if (path == null || path.isEmpty() || path.isBlank())
			throw new NullPointerException("Path cannot be Empty or null");
	
		
		if (fileName == null || fileName.isEmpty() || fileName.isBlank())
			throw new NullPointerException("File Name cannot be Empty or null");
		
		File newFile = new File(path + File.separator + fileName);
		
		boolean createFile = newFile.createNewFile();
		
		if (createFile) {
			
			System.out.println("\nFile Successfully Created: " + newFile.getAbsolutePath());
			
		}else if(!createFile) {
			
			System.out.println("\nFile Already Exist.. Please try again." );
			
		}
			
	}
	
	
	
public void deleteFile(String path , String fileName) throws IOException {
		
		if (path == null || path.isEmpty() || path.isBlank())
			throw new NullPointerException("Path cannot be Empty or null");
		
		
		if (fileName == null || fileName.isEmpty() || fileName.isBlank())
			throw new NullPointerException("File Name cannot be Empty or null");
		
		File newFile = new File(path + File.separator + fileName);
		
		boolean deleteFile = newFile.delete();
		
		if (deleteFile) {
			
			System.out.println("\nFile deleted Successfully");
			
		}else {
			
			System.out.println("\nFile Not Found.. Please try again." );
			
		}
			
	}
	


public void searchFile(String path , String fileName){	
		if (path == null || path.isEmpty() || path.isBlank())
			throw new NullPointerException("Path cannot be Empty or null");
		if (fileName == null || fileName.isEmpty() || fileName.isBlank())
			throw new NullPointerException("File Name cannot be Empty or null");
		File dir = new File(path);
		if(!dir.exists())
			throw new IllegalArgumentException("Path does not exist");
		if(dir.isFile())
			throw new IllegalArgumentException("The given path is a file. A directory is expected.");
		String[] flist = dir.list();
        boolean flag = false;
        if (flist == null) {
            System.out.println("Empty directory.");
        }
        else {
  
            // Linear search in the array to find the files
            for (int i = 0; i < flist.length; i++) {
                String filename = flist[i];
                if (filename.equalsIgnoreCase(fileName)) {
                    System.out.println(filename + " found");
                    System.out.println("File Found at location: " + dir.getAbsolutePath());
                    flag = true;
                }
            }
        }
		
		if(flag == false)
			System.out.println("File Not Found.. Please try again.");	
	}
	
}
