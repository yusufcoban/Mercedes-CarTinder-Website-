package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Start_Stati {
	/**
	 * StatistikModel
	 */
	@RequestMapping("/statistik")
	public String stati() {
		return "statistik";
	}
}
