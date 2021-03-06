
package com.mall.admin.main.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @설명			: 관리자 메인
 * @작성일		: 2017. 1. 10. 오전 10:26:31
 * @작성자		: Seo Myeongseok(sirosms@gmail.com)
 * @version 	: 12st.V1.0
 */

@Controller
public class MainController {
private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = "/admin/main/main")
	public String main(Locale locale, Model model) {
	    logger.info("Welcome home! The client locale is {}.", locale);
	        
	    return "/admin/main/main.tiles";
	}
}
