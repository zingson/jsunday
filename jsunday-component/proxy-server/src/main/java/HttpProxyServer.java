import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class HttpProxyServer {

    public static void main(String args[])throws Exception{
        ServerSocket server  = new ServerSocket(8888);
        while(true){
            Socket socket = server.accept();
            ActionSocket ap = new ActionSocket(socket);
            ap.start();
        }
    }

}

class ActionSocket extends Thread{
    private Socket socket = null ;
    public ActionSocket(Socket s){
        this.socket = s ;
    }
    public void run(){
        try{
            this.action() ;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void action() throws Exception {
        if (this.socket == null){
            return ;
        }
        InputStream cis = this.socket.getInputStream();

        URL url = new URL("http://zingson.com");
        HttpURLConnection action = (HttpURLConnection) url.openConnection();
        InputStream sis =action.getInputStream();
        OutputStream cos = socket.getOutputStream();
        int length;
        byte bytes[] = new byte[1024];

        while(true){
            try {
                if ((length = sis.read(bytes)) > 0) {
                    cos.write(bytes, 0, length);//将http请求头写到目标主机
                    System.out.println(new String(bytes));
                    cos.flush();
                } else if (length < 0)
                    break;
            } catch (Exception e) {
            }
        }
        socket.close();
        cis.close();
    }
}