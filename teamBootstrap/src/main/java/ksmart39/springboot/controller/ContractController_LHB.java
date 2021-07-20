package ksmart39.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.MapUtils;

import ksmart39.springboot.domain.SupplierRequest;
import ksmart39.springboot.service.RequestedProductService;
import ksmart39.springboot.service.SupplierService;


@Controller
@RequestMapping("/contract")
public class ContractController_LHB {
	@Autowired
	private final SupplierService supplierService;
	private final RequestedProductService requestedProductService;
	
	
	 @Autowired public ContractController_LHB(SupplierService supplierService, RequestedProductService requestedProductService) {
	 this.supplierService = supplierService;
	 this.requestedProductService = requestedProductService;
	 }
	 

	
	private static final Logger log = LoggerFactory.getLogger(SystemController.class);
	
	//----------------------------------------수주주문서-----------------------------------------------------
	
	
	//[한빛]수주계약 등록 -> 조회
	@PostMapping("/addBuyerOrder")
	public String addBuyerOrder() {
		return "redirect:/buyerOrderList";
	}
	
	//[한빛]수주 주문서 승인완료 목록
	@GetMapping("/buyerOrderApproval")
	public String buyerOrderApproval(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderApproval";
	}	
	
	//[한빛]수주 주문서 상세로!
	@GetMapping("/buyerOrderInfo")
	public String buyerOrderInfo(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderInfo";
	}	
	
	//[한빛]수주 주문서 수정
	@GetMapping("/modifyBuyerOrder")
	public String modifyBuyerOrder(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerOrderList";
	}	
	
	//[한빛]수주 주문서 조회
	@GetMapping("/buyerOrderList")
	public String buyerOrderList(Model model) {
		List<Map<String,Object>> resultMap = requestedProductService.getRequestedProduct();
		model.addAttribute("title", "수주관리");
		model.addAttribute("",resultMap);
		return "contract/buyerOrderList";
	}		
	
	//[한빛]수주 주문서 등록
	@GetMapping("/addBuyerOrder")
	public String addBuyerOrder(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/addBuyerOrder";
	}	
	//---------------------------------------수주계약---------------------------------------------------------
	//[한빛] 수주계약 수정
	@GetMapping("/modifyBuyerContract")
	public String modifyBuyerContract() {
		return"contract/modifyBuyerContract";
	}
	//[한빛]수주계약 등록 -> 조회
	@PostMapping("/addBuyerContract")
	public String addBuyerContract() {
		return "redirect:/buyerContractList";
	}
	
	//[한빛]수주계약 조회
	@GetMapping("/buyerContractList")
	public String buyerContractList(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerContractList";
	}
	
	
	//[한빛]수주계약 등록
	@GetMapping("/addBuyerContract")
	public String addBuyerContract(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/addBuyerContract";
	}
	//------------------------------------------수주의뢰---------------------------------------------------------
	//[한빛] 수주의뢰 수정
	@GetMapping("/modifyBuyerRequest")
	public String modifyBuyerRequest() {
		return"contract/modifyBuyerRequest";
	}
	//[한빛]수주의뢰 조회
	@GetMapping("/buyerRequestList")
	public String buyerRequestList(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/buyerRequestList";
	}
	//[한빛]수주주문등록 ->목록으로 이동
	@PostMapping("/addBuyerRequest")
	public String addBuyerRequest() {
		return "redirect:/buyerRequestList";
	}
		
	//[한빛]수주의뢰 등록
	@GetMapping("/addBuyerRequest")
	public String addBuyerRequest(Model model) {
		model.addAttribute("title", "수주관리");
		return "contract/addBuyerRequest";
	}
	
	
	

	



}