package ksmart39.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ksmart39.springboot.domain.DefectiveProduct;
import ksmart39.springboot.service.DefectiveProductService;
import ksmart39.springboot.service.QualityControlService;
import ksmart39.springboot.service.QualityInsMeasurementValueService;
import ksmart39.springboot.service.QualityInsepctionFinalResultService;
import ksmart39.springboot.service.QualityInsepctionStauteService;

@Controller
@RequestMapping("/quality")
public class QualityControlController_HBR {
	private static final Logger log = LoggerFactory.getLogger(QualityControlController_HBR.class);
	@Autowired
	private QualityInsepctionFinalResultService qualityInsepctionFinalResultService;
	@Autowired
	private QualityInsepctionStauteService qualityInsepctionStauteService;
	
	//================================================================
	//[다미&보람] 수주계약별 검색 
	@RequestMapping(value = "searchQualityInspection",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getSearchQualityInspectionState(Model model,@RequestParam(value ="bySupplierValue",required = false)String bySupplierValue,
																	@RequestParam(value = "clientName",required = false)String clientName,
																	@RequestParam(value = "requestProductName", required = false)String requestProductName,
																	@RequestParam(value = "inspectionStartDate", required = false)String inspectionStartDate,
																	@RequestParam(value = "inspectionEndDate", required = false)String inspectionEndDate){
		
		//RequestParam 값을 map에 담기
		//HASHMAP을 객체화하기
		HashMap<String,Object> map = new HashMap<String,Object>();
		//객체화된map에.put 메서드로  RequestParam값 넣기
		map.put("bySupplierValue", bySupplierValue);
		map.put("clientName", clientName);
		map.put("requestProductName", requestProductName);
		map.put("inspectionStartDate", inspectionStartDate);
		map.put("inspectionEndDate", inspectionEndDate);
		List<Map<String, Object>> stateMap = qualityInsepctionStauteService.getSearchQualityInspectionState(map);
		model.addAttribute("stateMap", stateMap);
		return stateMap;
	}
	
	//[다미&보람]수주계약별 검색 품질검사 현황
		@GetMapping("/qualityInspectionStatusContract")
		public String qualityInspectionStatusContract(Model model) {
			List<Map<String, Object>> inspectionStateList = qualityInsepctionStauteService.getStateBuyerContractQualityInspection();
			
			model.addAttribute("inspectionStateList", inspectionStateList);
			return "quality/qualityInspectionStatusContract";
		}
	
	
	//[다미+보람]품질검사 최종등록 검색모달창 
	@RequestMapping(value = "/addfinalresult",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> searchRequesetInspection(){
		 List<Map<String,Object>> requestList = qualityInsepctionFinalResultService.searchRequesetInspection();
		 log.info("=============================================");
		  	log.info("requestList  {}",requestList);
		  	log.info("=============================================");
		return requestList;
	}
	
	
	
	
	//[다미+보람]검사현황 조회 성적서 모달창값전달하기
	@RequestMapping(value = "/finalResult",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getFinalResultReport(@RequestParam(value = "requestProductCode", required = false)String requestProductCode){
		List<Map<String,Object>> finalResultReport = qualityInsepctionFinalResultService.getFinalResultReport(requestProductCode);
		log.info("=============================================");
	  	log.info("finalResultReport  {}",finalResultReport);
	  	log.info("=============================================");
		return finalResultReport;
	}
	
	
	
	
	
	//[다미+보람]검사현황 조회 성적서 결과값보여주기
	@RequestMapping(value = "/searchfinalResult",method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getQualityInspectionReport(@RequestParam(value ="clientCate",required = false)String clientCate,
															@RequestParam(value = "requestCate",required = false)String requestCate,
															@RequestParam(value = "productCate",required = false)String productCate,
															@RequestParam(value = "InspectionStartDate",required = false)String InspectionStartDate,
															@RequestParam(value = "inspectionEndDate",required = false)String inspectionEndDate){
		HashMap<String, Object> map = new HashMap<>();
		map.put("clientCate", clientCate);
		map.put("requestCate", requestCate);
		map.put("productCate", productCate);
		map.put("InspectionStartDate",InspectionStartDate);
		map.put("inspectionEndDate", inspectionEndDate);
		List<Map<String,Object>> searchListMap = qualityInsepctionFinalResultService.getQualityInspectionReport(map);
		log.info("검색 :  {}", searchListMap);
		
		return searchListMap;
	}
	
	
	
	//[다미+보람]검사현황 조회 품목명 가지고오기
	@RequestMapping(value = "/requestName", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getProductName(@RequestParam(value = "requestNum", required = false)String requestNum){
		List<Map<String,Object>> productName = qualityInsepctionFinalResultService.getProductName(requestNum);
		
		return productName;
	}
	
	  //[다미+보람]검사현황 조회 의뢰코드가지고오기
	  
	  @RequestMapping(value = "/requestCode", method = RequestMethod.GET)
	  @ResponseBody 
	  public List<Map<String,Object>> getRequestProductCode(@RequestParam(value = "client",required =	  false)String client ){ 
		 List<Map<String,Object>> reqeustCode =	 qualityInsepctionFinalResultService.getRequestProductCode(client);
	  	
	 return reqeustCode; 
	 }
	
	

	//[다미+보람]검사현황 조회 거래처명가지고오기
	@RequestMapping(value = "/clientName", method =RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getClientName(){
		List<Map<String,Object>> clientList =qualityInsepctionFinalResultService.getClientName();
		log.info("=============================================");
		log.info("거래처명 :  {}", clientList);
		log.info("=============================================");
		return clientList;
	}
	
	//검사현황 성적서조회 및리스트
	@GetMapping("/qualityInspectionReport")
	public String getQualityInspectionReport(Model model) {
		List<Map<String,Object>> finalResultList = qualityInsepctionFinalResultService.getInsepectionFinalResult();
		log.info("=============================================");
		log.info("최종성적리스트 :  {} ", finalResultList);
		log.info("=============================================");
		model.addAttribute("finalResultList", finalResultList);
		return"quality/qualityInspectionReport";
	}
	
	
	//[다미+보람]검사현황최종결과등록
	@GetMapping("/addFinalnspectionMeasurementValue")
	public String addQualityInspectionReport(Model model) {
		
		model.addAttribute("title", "품질관리");
		return"quality/addFinalnspectionMeasurementValue";
	}
	

	
	//[다미&보람]수주계약별 기간별조회
		@GetMapping("/searchByPeriodContractQualityInspection")
		public String searchByPeriodContractQualityInspection() {
			return"quality/searchByPeriodContractQualityInspection";
		}

	
	
	
	
	
	//=========================================================================

	
}
