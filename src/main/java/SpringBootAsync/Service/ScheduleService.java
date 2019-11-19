package SpringBootAsync.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

	/*
	 *  second, minute, hour, day of month, month, day of week
	 *  0 * * * * MON-FRI (代表周一到周五，不管哪一月，哪一天，哪个小时，哪一分钟， 0秒执行, 即每分钟运行一次)
	 */ 
	/*
	//@Scheduled(cron="0 * * * * *")   //定时任务注解
	//@Scheduled(cron="0,1,2,3 * * * * *")   //定时任务注解
	//@Scheduled(cron="0-3 * * * * *")   //定时任务注解
	@Scheduled(cron="0/3 * * * * *")   //定时任务注解, 步长，0秒开始每隔3秒运行一次, 不管是否到了0秒
	public void scheduleHello() {
		System.out.println("hello");
	}
	*/
}
