package SpringBootAsync.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Async  //以异步多线程方式运行, JavaVM会创建Threading Pool管理线程
	public void hello() {       //线程之间的数据逻辑没有关系才能这样，有的话不能异步运行
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("处理数据中...");		
	}
}
