package Server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

	
	public final static int port = 10000;
	
	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		try(ServerSocket server = new ServerSocket(port)){
			while(true) {
				try(Socket conn = server.accept()){
					Writer out =new OutputStreamWriter(conn.getOutputStream());
					Reader read = new InputStreamReader(conn.getInputStream());
					int n;
					
					Date now = new Date();
					
					while(( n = read.read())!=-1) {
						
					}
					
					out.write("안녕하세요 지금 시간은 "+now.toString()+"\r\n");
					out.flush();
					conn.close();
				}catch(IOException ex) {
					System.out.println(ex);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
