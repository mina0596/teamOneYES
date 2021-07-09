package ksmart39.springboot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart39.springboot.domain.RawMaterialsInventory;

@Mapper
public interface RawMaterialsInventoryStatusMapper {
	
	
	//[민아]자재 입출고 현황
	public List<RawMaterialsInventory> getMaterialsTransactionList();
	
	//[민아]자재 입고 수정화면
	public RawMaterialsInventory getInventoryInfoByCode(String transactionCode);
	
	//[민아]자재 입고 수정 처리
	public int modifyMaterialIn(Map<String,Object> paramMap);
}
