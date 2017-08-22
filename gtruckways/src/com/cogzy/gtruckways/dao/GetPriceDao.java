package com.cogzy.gtruckways.dao;



import java.util.List;

import com.cogzy.gtruckways.businessObjects.PromoCode;
import com.cogzy.gtruckways.businessObjects.TruckInfo;


public interface GetPriceDao {

	
	public TruckInfo getTruckInformation(int truckId);
	public float ajaxGetPrice(String trkType);
	public int getTrcukId(String VehicleName);
	public List<TruckInfo> getAllVehicleTypes();
	public List<String> getAllMaterials();
	public PromoCode CheckPromoCodeExistsOrNot(String promoCode);
	
	
}
