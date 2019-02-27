package de.codecentric.gcp.services;

import java.util.List;

import de.codecentric.gcp.dto.PointDto;

public interface IPointServices {
	public void savePoint(PointDto pointDto);
	List<PointDto> getPoint(List<String> lstid, String key);
}
