package com.paul.spring.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {
	
	private static final SimpleDateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(cron = "0 33 16 ? * *")
	public void cronService(){
		System.out.println("固定时间执行：" + dateFormate.format(new Date()));
	}
	
	@Scheduled(initialDelay = 5000,fixedRate = 5000)
	public void fixRateService(){
		System.out.println("没隔5秒执行一次：" + dateFormate.format(new Date()));
	}
	
	@Scheduled(fixedDelay = 8000)
	public void fixDelayService(){
		System.out.println("延迟执行？？？：" + dateFormate.format(new Date()));
	}
}
