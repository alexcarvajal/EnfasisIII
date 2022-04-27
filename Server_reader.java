import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server_reader {
 
    public static void main(String[] args) {
        ServerSocket ss=null;
        Socket s=null;
 
        BufferedReader br=null;
        PrintWriter pw=null;
 
        try {
            ss=new ServerSocket(9090);
            s=ss.accept();
 
            InputStream is = s.getInputStream();
            br=new BufferedReader(new InputStreamReader(is));
 
            String str=null;
            while((str=br.readLine())!=null){
                System.out.println(str);
            }
 
            OutputStream os = s.getOutputStream();
            pw=new PrintWriter(os,true);
 
            for(int i=0;i<3;i++){
                pw.println("Hola!");
                //pw.flush();
            }
 
            //s.shutdownOutput();    ???
 
 
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
 
            try {
                if(s!=null)
                    s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
 
         }
 
 
 
 
    }
}