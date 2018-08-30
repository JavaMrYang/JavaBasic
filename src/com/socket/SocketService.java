package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketService {
public static void main(String[] args) {
	
}
public void oneServer() throws IOException {
	ServerSocket socketServer=null;
	try {
			if(socketServer==null) {
			socketServer=new ServerSocket(80);//b)指定绑定的端口，并监听此端口。
			print("服务器启动成功!");
			}
		} catch (IOException e) {
			print("没有启动监听："+e);
	}
	Socket socket=null;
	try {
		if(socket==null) {
			socket=socketServer.accept();//调用accept()方法开始监听，等待客户端的连接 
		}
	} catch (Exception e) {
		 System.out.println("Error."+e);
	}
	
	String line;
	BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream())); //由Socket对象得到输入流，并构造相应的BufferedReader对象
	PrintWriter writer=new PrintWriter(socket.getOutputStream());  //由Socket对象得到输出流，并构造PrintWriter对象
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//由系统标准输入设备构造BufferedReader对象
	print("Client:"+in.readLine());
	line=br.readLine();//从标准输入读入一字符串
	while(!line.equals("end"));
    writer.println(line);
    writer.flush();
    print("Server:"+line);
    print("Client:"+in.readLine());
    line=br.readLine();
    
    writer.close(); //关闭Socket输出流
    in.close(); //关闭Socket输入流
    socket.close(); //关闭Socket
    socketServer.close(); //关闭ServerSocket
}
public void print(String str) {
	System.out.println(str);
}
}
