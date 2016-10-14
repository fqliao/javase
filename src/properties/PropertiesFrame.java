package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @decription:Properties类读写属性文件
 * @version:1.0
 * @date: 2016年10月14日下午5:07:25
 * @author: lfq
 * 
 */
public class PropertiesFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	private File propertiesFile;
	private Properties settings;
	
	public PropertiesFrame() throws IOException
	{

		
		//初始化Properties
		settings = new Properties();
		
		//从配置文件中加载配置，如果配置文件没有，就创建配置文件
		
		
		//获取操作系统的家目录
//		String homeDir = System.getProperty("user.home");
//		System.out.println(homeDir);
		//注意Properties属性配置文件扩展名随意或不用设置，建议写为.properties,已区分文件类别
//		propertiesFile = new File(homeDir,"JavaWindow.properties");//第二个参数文件的名称
		
		//获取工程文件中的路径
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
		String path = userDir + File.separator+"config";
		System.out.println(path);
		
		//指定目录下的JavaWindow.properties文件,不指定路径则默认为src的同级目录下的该文件
		propertiesFile = new File(path,"JavaWindow.properties");
		
		if(propertiesFile.exists())
		{	
			//文件存在就加载配置
			InputStream in = new FileInputStream(propertiesFile);
			settings.load(in);
			in.close();
		}
		else
		{	
			//文件不存在就创建文件，设置默认参数，保存默认配置
			propertiesFile.createNewFile();
			
			settings.setProperty("left", "0");
			settings.setProperty("top", "0");
			settings.setProperty("width", ""+DEFAULT_WIDTH);
			settings.setProperty("height", ""+DEFAULT_HEIGHT);
			settings.setProperty("title", "999");
			
			FileOutputStream out = new FileOutputStream(propertiesFile, true);//true表示追加打开
			settings.store(out, "JavaWindowsSettings");//第二个参数，配置文件的文档说明
			out.close();
		}
		
		//去除默认配置设置窗口属性
		int left = Integer.parseInt(settings.getProperty("left"));
		int top = Integer.parseInt(settings.getProperty("top"));
		int width = Integer.parseInt(settings.getProperty("width"));
		int height = Integer.parseInt(settings.getProperty("height"));
		setBounds(left,top,width,height);
		
		String title = settings.getProperty("title");
		if(title.equals("")) title = JOptionPane.showInputDialog("Please supply a frame title:");
		if(title == null) title = "";
		setTitle(title);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws IOException {
		PropertiesFrame frame = new PropertiesFrame();
	}
}
