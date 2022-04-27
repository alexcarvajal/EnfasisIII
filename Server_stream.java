import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server_stream {
 
    public static void main(String[] args) {
        ServerSocket ss=null;
        Socket s=null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
 
        try {
            ss=new ServerSocket(9898);
            s=ss.accept();
 
            InputStream is = s.getInputStream();
            bis=new BufferedInputStream(is);
            bos=new BufferedOutputStream(new FileOutputStream("C://Users/Alex Carvajal/OneDrive/Escritorio/Enfasis 3/Ejemplos de la red/Trabajo/a.png"));
            byte[] bytes=new byte[1024];
            int len;
            while((len=bis.read(bytes))!=-1){
 
                bos.write(bytes,0,len);
                bos.flush();
            }
            OutputStream os = s.getOutputStream();
            os.write ("Recibido" .getBytes ());
 
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