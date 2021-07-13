package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.QualityInsepctionResultMapper;

@Service
public class QualityInsepctionResultService {
	private static final Logger log = LoggerFactory.getLogger(QualityInsepctionResultService.class);
	
	@Autowired
	private QualityInsepctionResultMapper qualityInsepctionResultMapper;
	
	//[다미+보람]검사현황 조회 품목명가지고오기 
		public List<Map<String,Object>> getProductName(String requestNum){
			return qualityInsepctionResultMapper.getProductName(requestNum);
		}

	 //[다미+보람]검사현황 조회 의뢰코드명가지고오기 
		public List<Map<String,Object>>	 getRequestProductCode(String client){
			return qualityInsepctionResultMapper.getRequestProductCode(client);
		}
	
	//[다미+보람]검사현황 조회 거래처명가지고오기
		public List<Map<String, Object>> getClientName(){
			
			List<Map<String, Object>> client = qualityInsepctionResultMapper.getClientName();
			
			
			return client;
		}
		

	//[보람 ]품질검사 최종 리스트 화면
		public  List<Map<String,Object>> getInsepectionFinalResult(){
			
			return qualityInsepctionResultMapper.getInsepectionFinalResult();
		}
}
