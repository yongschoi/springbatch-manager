package yongs.temp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yongs.temp.dto.Distribution;
import yongs.temp.repository.JobQueryRepository;

@Service
public class DistributionService {
	@Autowired
	private JobQueryRepository jobQueryRepo;
	
	public List<Distribution> getNumOfExecutionsByHour() {
		LocalDate today = LocalDate.now();
		// 최근 30일간 시간대별 실행 누적
		List<Distribution> list = jobQueryRepo.getNumOfExecutionsByHourSum(today.minusDays(30), today);		

	    // 00~23시에 실행되지 않는 시간대가 존재하면 0값을 채워준다.
		List<Distribution> filledList = new ArrayList<>();
		for(int i=0; i<10; i++) {
			String key = "0"+i;
			long value = 0;
			boolean keyExist = false;
			
			for (Distribution dist : list) {
				if(dist.getKey().equals(key)) {
					value = dist.getValue();
					keyExist = true;
					break;
				}
			}			
			if(keyExist) filledList.add(new Distribution(key, value));
			else filledList.add(new Distribution(key, 0));			
		}
		
		for(int i=10; i<24; i++) {
			String key = Integer.toString(i);
			long value = 0;
			boolean keyExist = false;
			
			for (Distribution dist : list) {
				if(dist.getKey().equals(key)) {
					value = dist.getValue();
					keyExist = true;
					break;
				}
			}			
			if(keyExist) filledList.add(new Distribution(key, value));
			else filledList.add(new Distribution(key, 0));	
		}
		
		return filledList;
	}
	
	public List<Distribution> getNumOfExecutionsByMinute(String target) {
		LocalDate today = LocalDate.now();
		// 최근 30일간 target분대별 실행 누적
		List<Distribution> list = jobQueryRepo.getNumOfExecutionsByMinuteSum(target, today.minusDays(30), today);
		
	    // 00~59분에 실행되지 않는 시간대가 존재하면 0값을 채워준다.
		List<Distribution> filledList = new ArrayList<>();
		for(int i=0; i<10; i++) {
			String key = "0"+i;
			long value = 0;
			boolean keyExist = false;
			
			for (Distribution dist : list) {
				if(dist.getKey().equals(key)) {
					value = dist.getValue();
					keyExist = true;
					break;
				}
			}			
			if(keyExist) filledList.add(new Distribution(key, value));
			else filledList.add(new Distribution(key, 0));			
		}
		
		for(int i=10; i<60; i++) {
			String key = Integer.toString(i);
			long value = 0;
			boolean keyExist = false;
			
			for (Distribution dist : list) {
				if(dist.getKey().equals(key)) {
					value = dist.getValue();
					keyExist = true;
					break;
				}
			}			
			if(keyExist) filledList.add(new Distribution(key, value));
			else filledList.add(new Distribution(key, 0));	
		}
		
		return filledList;
	}
	
	public List<Distribution> getJobNamesByTarget(String target) {
		LocalDate today = LocalDate.now();
		// 최근 30일간 target분대별 실행된 Job 리스트
		return jobQueryRepo.getJobNamesBySelectedMinute(target, today.minusDays(30), today);
	}
}
