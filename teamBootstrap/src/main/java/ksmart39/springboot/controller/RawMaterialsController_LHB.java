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
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart39.springboot.domain.HumanResources;
import ksmart39.springboot.domain.RawMaterials;
import ksmart39.springboot.domain.RawMaterialsInventory;
import ksmart39.springboot.service.RawMaterialsInventoryStatusService;
import ksmart39.springboot.service.RawMaterialsService;

@Controller
@RequestMapping("/rawMaterials")
public class RawMaterialsController_LHB {
	
	private static final Logger log = LoggerFactory.getLogger(RawMaterialsController_LHB.class);
	
	
	
	/**************************************************************************************************/
	
	private final RawMaterialsInventoryStatusService materialsInventoryStatusService;
	
	@Autowired
	public RawMaterialsController_LHB(RawMaterialsInventoryStatusService materialsInventoryStatusService) {
		this.materialsInventoryStatusService = materialsInventoryStatusService;
	}
	
	
	//===================================================================
	
	//[한빛]출고현황
	@GetMapping("/exWarehousingList")
	public String exWarehousingList() {
		return "rawMaterials/exWarehousingList";
	}
	//[한빛]출고등록
	@GetMapping("/addExWarehousing")
	public String addExWarehousing() {
		return "rawMaterials/addExWarehousing";
	}	
		
	//[한빛]소요별 자재 정보 입력 후 자재 입고 목록으로 리다이렉트 , 파라미터는 임시 값
	@PostMapping("/addMaterialsUse")
	public String addExWarehousing(@RequestParam(value = "raw_material_name", required = false )String raw_material_name) {
		
		return "redirect:/materialsUseList";
	}
	//[한빛]소요별 자재조회/목록
	@GetMapping("/materialsUseList")
	public String materialsUseList() {
		return "rawMaterials/materialsUseList";
	}
	
	//[한빛]소요별 자재등록
	@GetMapping("/addMaterialsUse")
	public String addMaterialsUse() {
		return "rawMaterials/addMaterialsUse";
	}
	

	//===================================================================
	
}
