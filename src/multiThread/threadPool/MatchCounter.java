package multiThread.threadPool;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MatchCounter implements Callable<Integer> {
	
	private File directory;
	private String keyword;
	private ExecutorService pool;
	private int count;
	
	
	public MatchCounter(File directory, String keyword, ExecutorService pool) {
		super();
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
	}
	

	@Override
	public Integer call() throws Exception {
		count = 0;
		try {
			File[] files = directory.listFiles();
			ArrayList<Future<Integer>> results = new ArrayList<>();
			
			for (File file : files) 
			{
				if(file.isDirectory())
				{
					MatchCounter counter = new MatchCounter(file,keyword,pool);
					Future<Integer> result = pool.submit(counter);
					results.add(result);
				}
				else
				{
					if(search(file))
						count++;
				}
			}
			for (Future<Integer> result : results) 
			{
				try 
				{
					count += result.get();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		} 
		catch (Exception e) 
		{
			
		}
		return count;
	}
	
	public boolean search(File file){
		try 
		{	//不能直接把file放入Scanner，先将file放入文件输入流FileInputStream
			FileInputStream inputStream = new FileInputStream(file);
			try (Scanner in = new Scanner(inputStream))
			{
				boolean found = false;
				while(!found && in.hasNextLine())
				{	
					String line = in.nextLine();
					if(line.contains(keyword))
						found = true;
				}
				return found;
			} 

		} 
		catch (Exception e) 
		{
			return false;
		}
	}

}
