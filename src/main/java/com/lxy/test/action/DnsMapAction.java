package com.lxy.test.action;

import java.util.HashMap;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/api/dnsmap")
public class DnsMapAction {
	@RequestMapping(method=RequestMethod.POST)
    public String greeting(
    		@RequestParam(value="map_name", required=true) String mapName, 
    		@RequestParam(value="service_type", required=false, defaultValue="web") String serviceType, 
    		@RequestParam(value="status", required=false, defaultValue="disabled") String status,
    		@RequestParam(value="estimated_bw", required=false, defaultValue="0") int estimatedBw,
    		@RequestParam(value="exclude_region", required=false, defaultValue="") String excludeRegion,
    		@RequestParam(value="priority", required=false, defaultValue="5") int priority,
    		Model model) {
		model.addAttribute("result", "ok");
		model.addAttribute("msg", "");
        return "/dnsmap/dnsmapMain";
    }
	
	@RequestMapping(path="/json1")
	public void all() {
		System.out.println("all");
	}
	
	@RequestMapping(path="/json", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
    public String greeting(Model model) {
        return "{a:123}";
    }
	
	@RequestMapping(path="{day}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getForDay(@PathVariable String day) {
		System.out.println(day);
		Map<String, String> map = new HashMap<String, String>();
		map.put("day", "2015-01-01");
		return map;
	}
}
