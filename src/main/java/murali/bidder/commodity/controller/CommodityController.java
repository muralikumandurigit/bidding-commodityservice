package murali.bidder.commodity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import murali.bidder.commodity.entity.Commodity;
import murali.bidder.commodity.service.CommodityService;

@RestController
@Slf4j
@RequestMapping("/commodities")
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	
	@PostMapping("/")
	public Commodity saveCommodity(@RequestBody Commodity commodity) {
		log.info("Saving commodity " + commodity.toString());
		return commodityService.saveCommodity(commodity);
	}
}
