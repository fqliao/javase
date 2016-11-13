package network.basic;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @decription:URLEncoder,URLDecoder编解码，URL对非西欧字符的编解码
 * @version:1.0
 * @date: 2016年11月4日下午4:17:14
 * @author: lfq
 * 
 */
public class URLDecoderTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//编码 中文编码 英文不用编码
		String encodeName = URLEncoder.encode("廖飞强", "UTF-8");
		System.out.println(encodeName);
		
		//解码
		String decodeName = URLDecoder.decode(encodeName, "UTF-8");
		System.out.println(decodeName);
	}

}
