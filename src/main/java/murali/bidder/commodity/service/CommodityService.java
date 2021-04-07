package murali.bidder.commodity.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;
import murali.bidder.commodity.entity.Commodity;
import murali.bidder.commodity.repository.CommodityRepository;

@Service
@Slf4j
public class CommodityService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CommodityRepository commodityRepository;
	
	@Value("${user.service.endpoint}")
	private String userServiceEndpoint;
	
	public Commodity saveCommodity(Commodity commodity) {
		log.info("Inside saveCommodity");
		Boolean isValidUser = restTemplate.getForObject(userServiceEndpoint + commodity.getEmail(), Boolean.class);
		if (isValidUser) {
			commodity.setCid(UUID.randomUUID().toString());
			return commodityRepository.save(commodity);			
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
	                "No user exist with email : " + commodity.getEmail());
		}
	}
	
}
