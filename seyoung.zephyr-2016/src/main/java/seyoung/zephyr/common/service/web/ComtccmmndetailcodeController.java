package seyoung.zephyr.common.service.web;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;

import seyoung.zephyr.common.service.ComtccmmndetailcodeService;
import seyoung.zephyr.common.service.ComtccmmndetailcodeDefaultVO;
import seyoung.zephyr.common.service.ComtccmmndetailcodeVO;

/**
 * @Class Name : ComtccmmndetailcodeController.java
 * @Description : Comtccmmndetailcode Controller class
 * @Modification Information
 *
 * @author testCRUD
 * @since 2016.11.25
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=ComtccmmndetailcodeVO.class)
public class ComtccmmndetailcodeController {

    @Resource(name = "comtccmmndetailcodeService")
    private ComtccmmndetailcodeService comtccmmndetailcodeService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * COMTCCMMNDETAILCODE 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 ComtccmmndetailcodeDefaultVO
	 * @return "/comtccmmndetailcode/ComtccmmndetailcodeList"
	 * @exception Exception
	 */
    @RequestMapping(value="/comtccmmndetailcode/ComtccmmndetailcodeList.do")
    public String selectComtccmmndetailcodeList(@ModelAttribute("searchVO") ComtccmmndetailcodeDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
        comtccmmndetailcodeService.selectComtccmmndetailcodeList(searchVO, model);
       
        return "seyoung/zephyr/common/comtccmmndetailcode/ComtccmmndetailcodeList";
    } 
    
    @RequestMapping("/comtccmmndetailcode/addComtccmmndetailcodeView.do")
    public String addComtccmmndetailcodeView(
            @ModelAttribute("searchVO") ComtccmmndetailcodeDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("comtccmmndetailcodeVO", new ComtccmmndetailcodeVO());
        return "/comtccmmndetailcode/ComtccmmndetailcodeRegister";
    }
    
    @RequestMapping("/comtccmmndetailcode/addComtccmmndetailcode.do")
    public String addComtccmmndetailcode(
            ComtccmmndetailcodeVO comtccmmndetailcodeVO,
            @ModelAttribute("searchVO") ComtccmmndetailcodeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        comtccmmndetailcodeService.insertComtccmmndetailcode(comtccmmndetailcodeVO);
        status.setComplete();
        return "forward:/comtccmmndetailcode/ComtccmmndetailcodeList.do";
    }
    
    @RequestMapping("/comtccmmndetailcode/updateComtccmmndetailcodeView.do")
    public String updateComtccmmndetailcodeView(
            @RequestParam("codeId") java.lang.String codeId ,
            @RequestParam("code") java.lang.String code ,
            @ModelAttribute("searchVO") ComtccmmndetailcodeDefaultVO searchVO, Model model)
            throws Exception {
        ComtccmmndetailcodeVO comtccmmndetailcodeVO = new ComtccmmndetailcodeVO();
        comtccmmndetailcodeVO.setCodeId(codeId);
        comtccmmndetailcodeVO.setCode(code);
        // 변수명은 CoC 에 따라 comtccmmndetailcodeVO
        model.addAttribute(selectComtccmmndetailcode(comtccmmndetailcodeVO, searchVO));
        return "/comtccmmndetailcode/ComtccmmndetailcodeRegister";
    }

    @RequestMapping("/comtccmmndetailcode/selectComtccmmndetailcode.do")
    public @ModelAttribute("comtccmmndetailcodeVO")
    ComtccmmndetailcodeVO selectComtccmmndetailcode(
            ComtccmmndetailcodeVO comtccmmndetailcodeVO,
            @ModelAttribute("searchVO") ComtccmmndetailcodeDefaultVO searchVO) throws Exception {
        return comtccmmndetailcodeService.selectComtccmmndetailcode(comtccmmndetailcodeVO);
    }

    @RequestMapping("/comtccmmndetailcode/updateComtccmmndetailcode.do")
    public String updateComtccmmndetailcode(
            ComtccmmndetailcodeVO comtccmmndetailcodeVO,
            @ModelAttribute("searchVO") ComtccmmndetailcodeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        comtccmmndetailcodeService.updateComtccmmndetailcode(comtccmmndetailcodeVO);
        status.setComplete();
        return "forward:/comtccmmndetailcode/ComtccmmndetailcodeList.do";
    }
    
    @RequestMapping("/comtccmmndetailcode/deleteComtccmmndetailcode.do")
    public String deleteComtccmmndetailcode(
            ComtccmmndetailcodeVO comtccmmndetailcodeVO,
            @ModelAttribute("searchVO") ComtccmmndetailcodeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        comtccmmndetailcodeService.deleteComtccmmndetailcode(comtccmmndetailcodeVO);
        status.setComplete();
        return "forward:/comtccmmndetailcode/ComtccmmndetailcodeList.do";
    }

}
