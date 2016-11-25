package seyoung.zephyr.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import seyoung.zephyr.common.service.ComtccmmndetailcodeService;
import seyoung.zephyr.common.service.ComtccmmndetailcodeDefaultVO;
import seyoung.zephyr.common.service.ComtccmmndetailcodeVO;
import seyoung.zephyr.common.service.impl.ComtccmmndetailcodeDAO;

/**
 * @Class Name : ComtccmmndetailcodeServiceImpl.java
 * @Description : Comtccmmndetailcode Business Implement class
 * @Modification Information
 *
 * @author testCRUD
 * @since 2016.11.25
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("comtccmmndetailcodeService")
public class ComtccmmndetailcodeServiceImpl extends EgovAbstractServiceImpl implements
        ComtccmmndetailcodeService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(ComtccmmndetailcodeServiceImpl.class);

    @Resource(name="comtccmmndetailcodeDAO")
    private ComtccmmndetailcodeDAO comtccmmndetailcodeDAO;
    
    @Resource(name = "comtccmmndetailcodeService")
    private ComtccmmndetailcodeService comtccmmndetailcodeService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    /** ID Generation */
    //@Resource(name="{egovComtccmmndetailcodeIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * COMTCCMMNDETAILCODE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ComtccmmndetailcodeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertComtccmmndetailcode(ComtccmmndetailcodeVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	comtccmmndetailcodeDAO.insertComtccmmndetailcode(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * COMTCCMMNDETAILCODE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ComtccmmndetailcodeVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateComtccmmndetailcode(ComtccmmndetailcodeVO vo) throws Exception {
        comtccmmndetailcodeDAO.updateComtccmmndetailcode(vo);
    }

    /**
	 * COMTCCMMNDETAILCODE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ComtccmmndetailcodeVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteComtccmmndetailcode(ComtccmmndetailcodeVO vo) throws Exception {
        comtccmmndetailcodeDAO.deleteComtccmmndetailcode(vo);
    }

    /**
	 * COMTCCMMNDETAILCODE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ComtccmmndetailcodeVO
	 * @return 조회한 COMTCCMMNDETAILCODE
	 * @exception Exception
	 */
    public ComtccmmndetailcodeVO selectComtccmmndetailcode(ComtccmmndetailcodeVO vo) throws Exception {
        ComtccmmndetailcodeVO resultVO = comtccmmndetailcodeDAO.selectComtccmmndetailcode(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * COMTCCMMNDETAILCODE 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return COMTCCMMNDETAILCODE 목록
	 * @exception Exception
	 */
    public List<?> selectComtccmmndetailcodeList(ComtccmmndetailcodeDefaultVO searchVO) throws Exception {
        return comtccmmndetailcodeDAO.selectComtccmmndetailcodeList(searchVO);
    }

    /**
	 * COMTCCMMNDETAILCODE 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return COMTCCMMNDETAILCODE 총 갯수
	 * @exception
	 */
    public int selectComtccmmndetailcodeListTotCnt(ComtccmmndetailcodeDefaultVO searchVO) {
		return comtccmmndetailcodeDAO.selectComtccmmndetailcodeListTotCnt(searchVO);
	}

	@Override
	public void selectComtccmmndetailcodeList(
			ComtccmmndetailcodeDefaultVO searchVO, ModelMap model) throws Exception {
		/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<?> comtccmmndetailcodeList = comtccmmndetailcodeDAO.selectComtccmmndetailcodeList(searchVO);
		
		 model.addAttribute("resultList", comtccmmndetailcodeList);
	        
	        int totCnt = comtccmmndetailcodeService.selectComtccmmndetailcodeListTotCnt(searchVO);
			paginationInfo.setTotalRecordCount(totCnt);
	        model.addAttribute("paginationInfo", paginationInfo);
		
	}
    
}
