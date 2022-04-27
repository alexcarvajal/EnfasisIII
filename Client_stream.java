import java.io.*;
import java.net.Socket;
 
public class Client_stream {
 
    public static void main(String[] args) {
 
        Socket s=null;
        BufferedOutputStream bos=null;
        BufferedInputStream bis=null;
 
        try {
            s=new Socket("192.168.0.15",9898);
            OutputStream os = s.getOutputStream();
            bos=new BufferedOutputStream(os);
             bis = new BufferedInputStream (new FileInputStream ("C://Users/Alex Carvajal/OneDrive/Escritorio/Enfasis 3/Ejemplos de la red/Trabajo/b.png"));
            byte[] bytes=new byte[1024];
            int len;
            while((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
                bos.flush();
            }
            s.shutdownOutput();     //???
 
            bis=new BufferedInputStream(s.getInputStream());
            byte[] bytess=new byte[1024];
            int lenn;
            while((lenn=bis.read(bytess))!=-1){
                System.out.println(new String(bytess,0,lenn));
            }
 
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