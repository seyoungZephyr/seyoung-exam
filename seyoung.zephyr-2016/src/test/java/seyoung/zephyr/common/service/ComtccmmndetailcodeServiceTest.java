package seyoung.zephyr.common.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import egovframework.rte.fdl.property.EgovPropertyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:egovframework/spring/com/**/context-*.xml" })
public class ComtccmmndetailcodeServiceTest {

	@Autowired
	private ComtccmmndetailcodeService comtccmmndetailcodeService; 
	
	@Autowired
	private EgovPropertyService propertiesService;
	
	@Test
	public void test() throws Exception {
		
		ComtccmmndetailcodeDefaultVO searchVO = new ComtccmmndetailcodeDefaultVO();
		ModelMap modelMap= new ModelMap();
		 comtccmmndetailcodeService.selectComtccmmndetailcodeList(searchVO, modelMap);
//		System.out.println("items :"+ items);
		
	}

}
