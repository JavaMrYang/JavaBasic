package com.person.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIoDemo01 {
public static void main(String[] args) throws IOException {
	File file=new File("E:\\c.txt");
	FileInputStream is=new FileInputStream(file);
	byte[] b=new byte[(int) file.length()];
	is.read(b);
	System.out.println(new String(b));
	is.close();
}
}
