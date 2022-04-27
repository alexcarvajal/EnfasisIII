

import java.io.*;
import java.net.Socket;
 
public class Client_reader {
 
    public static void main(String[] args) {
        Socket s=null;
        BufferedReader br=null;
        PrintWriter pw=null;
 
        try {
            s=new Socket("localhost",9090);
            OutputStream os = s.getOutputStream();
            pw=new PrintWriter(os,true);
            for (int i = 0; i < 3; i++) {
                pw.println("Hola!");
                //pw.flush();
            }
 
            s.shutdownOutput();
 
            InputStream is = s.getInputStream();
            br=new BufferedReader(new InputStreamReader(is));
 
            String str=null;
            while((str=br.readLine())!=null){
                System.out.println(str);
            }
 
            //System.out.println(123);     ???
 
 
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