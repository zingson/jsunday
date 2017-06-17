package com.ul.core.utils.encrypt;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Unicode
 *
 * 中文字符集
 字符集   	字数	  Unicode 编码
 基本汉字	20902字	  4E00-9FA5
 基本汉字补充	38字  9FA6-9FCB
 扩展A	6582字	3400-4DB5
 扩展B	42711字	20000-2A6D6
 扩展C	4149字	2A700-2B734
 扩展D	222字	2B740-2B81D
 康熙部首	214字	2F00-2FD5
 部首扩展	115字	2E80-2EF3
 兼容汉字	477字	F900-FAD9
 兼容扩展	542字	2F800-2FA1D
 PUA(GBK)部件	81字	E815-E86F
 部件扩展	452字	E400-E5E8
 PUA增补	207字	E600-E6CF
 汉字笔画	36字	31C0-31E3
 汉字结构	12字	2FF0-2FFB
 汉语注音	22字	3105-3120
 注音扩展	22字	31A0-31BA
 〇	1字	3007
 */
public class Unicode {

    /**
     * 把中文转成Unicode码  不全
     * @param
     * @return
     */
    /*public static String chinaToUnicode(String str){
        String result="";
        for (int i = 0; i < str.length(); i++){
            char chr = str.charAt(i);
            int ci = str.charAt(i);
            //if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)
            //if(chr1>=12289&&chr1<=173782){
            if(CharUtil.isChinese(chr)){
                result+="\\u" + Integer.toHexString(chr);
            }else{
                result+=str.charAt(i);
            }
        }
        return result;
    }*/

    /**
     * 非中文字符转成unicode
     * @param src
     * @return
     */
    public static String chinaToUnicode(final String src) {
        //final String src = "Hallo äöü  ℃"; // this has to be read with the right encoding
        final CharsetEncoder asciiEncoder = Charset.forName("US-ASCII").newEncoder();
        final StringBuilder result = new StringBuilder();
        for (final Character character : src.toCharArray()) {
            if (asciiEncoder.canEncode(character)) {
                result.append(character);
            } else {
                result.append("\\u");
                result.append(Integer.toHexString(0x10000 | character).substring(1));
            }
        }
        return result.toString();
    }

    public static String unicodeToChina(String ucode) {
        StringBuffer string = new StringBuffer();
        for (int i = 0;i<ucode.length();i++){
            if("\\".equals(ucode.substring(i,i+1))&&"\\u".equals(ucode.substring(i,i+2))){
                int data = Integer.parseInt(ucode.substring(i+2,i+6),16);
                string.append((char)data);
                i += 6-1;
            }else{
                string.append(ucode.substring(i,i+1));
            }
        }
        /* 存在其他字符时有错误
        String[] u = ucode.split("\\\\u");
        for (int i = 0;i<u.length;i++){
            if(u[i].length()==4){
                string.append((char)Integer.parseInt(u[i],16));
            }else {
                string.append(u[i]);
            }
        }*/
        return string.toString();
    }

    /*public static void main(String[] args) throws UnsupportedEncodingException {
        String s = chinaToUnicode("");
        System.out.println(s);

        String t = "{\"body\":{\"source\":\"65267\",\"shop\":{\"id\":\"182000899000001\",\"name\":\"\\u5b9c\\u829d\\u591a\\u5916\\u5356\\uff08\\u5ef6\\u957f\\u8def\\u5e97Test\\uff09\",\"baidu_shop_id\":\"1701127920\"},\"order\":{\"order_id\":\"14702818738514\",\"send_immediately\":1,\"send_time\":\"1\",\"send_fee\":600,\"package_fee\":0,\"discount_fee\":0,\"total_fee\":3600,\"shop_fee\":3600,\"user_fee\":3600,\"pay_type\":1,\"pay_status\":1,\"need_invoice\":1,\"invoice_title\":\"\\u4e2a\\u4eba\",\"remark\":\"\\u8bf7\\u63d0\\u4f9b\\u9910\\u5177,\\u8fa3\\u4e00\\u70b9,\\u6ca1\\u96f6\\u94b1,\\u7c73\\u996d\\u591a\\u70b9\",\"delivery_party\":2,\"create_time\":\"1470281873\"},\"user\":{\"name\":\"\\u66feS\",\"phone\":\"13611703040\",\"gender\":1,\"address\":\"\\u542f\\u5149\\u827e\\u52a0\\u5927\\u53a6 \\u5ef6\\u957f\\u4e2d\\u8def581\\u53f73\\u697c\",\"coord\":{\"longitude\":121.455939,\"latitude\":31.275355}},\"products\":[{\"product_id\":\"10786859\",\"upc\":\"\",\"product_name\":\"\\u9ebb\\u8fa3\\u9999\\u9505\",\"product_price\":3000,\"product_amount\":1,\"product_fee\":3000,\"package_price\":0,\"package_amount\":\"1\",\"package_fee\":0,\"total_fee\":3000}],\"discount\":[]},\"cmd\":\"order.create\",\"sign\":\"CC30325F9CB5281CF22BC3C061EC9E51\",\"source\":\"65267\",\"ticket\":\"8A91BF38-1B54-10F9-AD19-2B14428B4328\",\"timestamp\":1470281916,\"version\":\"2.0\"}";

        System.out.println(unicodeToChina("\u5b9c\u829d\u591a\u5916\u5356\uff08\u5ef6\u957f\u8def\u5e97\uff09"));

    }*/

}
