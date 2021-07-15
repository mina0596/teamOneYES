package ksmart39.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart39.springboot.dao.ProductionMapper;
import ksmart39.springboot.dao.WorkOrderMapper;
import ksmart39.springboot.domain.RequestedProduct;


@Service
public class ProductionService {
	
	private final ProductionMapper productionMapper;
	private final WorkOrderMapper workOrderMapper;
	
	@Autowired
	public ProductionService(ProductionMapper productionMapper, WorkOrderMapper workOrderMapper) {
		this.productionMapper = productionMapper;
		this.workOrderMapper = workOrderMapper;
	}
	
	//[민아]완제품 품목 등록
	public int addCompletedProduct(Map<String,String> comProductInfo) {
		return productionMapper.addCompletedProduct(comProductInfo);
	}
	
	//[민아]생산 대기중인 품목 목록
		public List<Map<String,Object>> getProductReadyToStart(){
			List<Map<String,Object>> workOrderList = workOrderMapper.getWorkOrderList();
			
			return workOrderList;
		}
		
	//[민아]생산 시작하기 - 생산현황에 첫공정 insert
	public int startProduction(String sentPCode) {
		return productionMapper.startProduction(sentPCode);
	}
	
	//[민아]거래처명 검색 모달 결과
	public List<Map<String,Object>> searchClientName(Map<String,Object> infoMap){
		return productionMapper.searchClientName(infoMap);
	}
}
