import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by songz on 2017/6/16.
 */
public class APP {

    public static void main(String[] args) {
        Long l = 10L;
        l = Long.parseLong(l+"0");
        System.out.println(l);
        System.out.println(l==0);
        long ms = System.currentTimeMillis();
        System.out.println(ms);
        System.out.println("143254561110");
        Long time = 143254561110l;
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date(String.valueOf(time).length()==12?Long.parseLong(time+"0"):time)));
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date(ms)));
    }

}
