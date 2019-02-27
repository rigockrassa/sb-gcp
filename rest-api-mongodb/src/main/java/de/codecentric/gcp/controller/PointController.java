package de.codecentric.gcp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.codecentric.gcp.dto.PointDto;
import de.codecentric.gcp.dto.RequestPointDto;
import de.codecentric.gcp.services.IPointServices;

@RestController
@RequestMapping("/")
public class PointController {

	@Autowired
	@Qualifier("pointServices")
	private IPointServices pointService;

	@PostMapping(value = "/addPoint")
	public ResponseEntity<?> addPoint(@RequestBody PointDto pointDto) {
		pointService.savePoint(pointDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/getPoints")
	public ResponseEntity<List<PointDto>> getPoints(@RequestBody RequestPointDto request) {
		if (request == null || request.getKey() == null || request.getLstId() == null || request.getLstId().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);			
		}
		List<PointDto> lstPoint = pointService.getPoint(request.getLstId(), request.getKey());
		if (lstPoint == null || lstPoint.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {			
			return new ResponseEntity<>(lstPoint, HttpStatus.OK);
		}
	}
}
