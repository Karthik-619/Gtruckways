package com.cogzy.gtruckways.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cogzy.gtruckways.businessObjects.Price;
import com.cogzy.gtruckways.businessObjects.PromoCode;
import com.cogzy.gtruckways.businessObjects.Route;
import com.cogzy.gtruckways.businessObjects.TruckInfo;



public interface GetPriceService {

	public Route getGoogleDistanceAndTime(String fromCity,String toCity);
	public TruckInfo getTruckInformationDetails(String truckId);
	public Price getTotalAmount(Route route,TruckInfo info);
	public float ajaxGetPrice(String trkType);
	public int getTrcukId(String trkType);
	public List<TruckInfo> getAllVehicleTypes();
	public List<String> getAllMaterials();
	public PromoCode CheckPromoCodeExistsOrNot(String promoCode,float totalAmount,Price price,String travelDate);
	
	
}
