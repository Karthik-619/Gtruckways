package com.cogzy.gtruckways.businessObjects;

public class Price {

	//private int priceId;
	
	private Route route;
	
	private TruckInfo info;

	private float totalAmount;
	
	private float approximateAmount;
	
	private float extraDistance;
	
	private int landPageStatus;
	
	private float extraKm;
	private float extraMins;
	
	private float totalDistanceKm;
	
	private String nextDate;
	
	
	private String currentDate;
	
	private float totalMins;

	private int statusCode;
	
	
	private float extraKmAmount;
	
	
	private float extraMinsAmount;
	
	private float otherAmount;
	
	private float gstAmount;
	
	private String serverDate;
	
	private String serverTime;
	
	public float getExtraDistance() {
		return extraDistance;
	}

	public void setExtraDistance(float extraDistance) {
		this.extraDistance = extraDistance;
	}

	public float getExtraMins() {
		return extraMins;
	}

	public void setExtraMins(float extraMins) {
		this.extraMins = extraMins;
	}

	/*public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}
*/
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public TruckInfo getInfo() {
		return info;
	}

	public void setInfo(TruckInfo info) {
		this.info = info;
	}
	
	
	
	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Price getTotalAmount(Route route,TruckInfo info){
	
	int time_in_mins=0;
	float distance=route.getDistance();
	float dist=route.getDistance();
	time_in_mins=route.getTime();
    System.out.println(distance);
    System.out.println(time_in_mins);
	 int truckId=info.getTruckId();
      
		
		
		/*String[] part = distance.split(" ");
		System.out.println("hello"+part[0]+"jhasgdjka"+part[1]);
		System.out.println("heldfhdskjfhsd");
		
		totalDistanceKm=Float.parseFloat(part[0]);
		
		 dist=Float.parseFloat(part[0]);
	*/
		
		
		if(dist>2 && time_in_mins>60){
			if(truckId==1 || truckId==3 )
		    {
		     time_in_mins=time_in_mins-60;
		    }
		    else{
		     time_in_mins=time_in_mins-120;
		    }
			extraMins=(time_in_mins*100)/100;
			
			dist=dist-2;
			extraDistance=(dist*100)/100;
			System.out.println("distance"+extraDistance);
		totalAmount=Math.round((info.getBasePrice()+(extraDistance)*info.getAdditionalPrice()+(extraMins)*info.getAdditionalmins())*100)/100;
				}
		else if(dist>2){
			dist=dist-2;
			extraDistance=(dist*100)/100;
			totalAmount=Math.round((info.getBasePrice()+(extraDistance)*info.getAdditionalPrice())*100)/100;
			System.out.println("distance"+extraDistance);
		} else
		
		{
			extraMins=0;
			extraDistance=0;
	
			totalAmount=Math.round((info.getBasePrice())*100)/100;
					}
		
		System.out.println("distance"+extraMins+"time"+extraDistance);
		System.out.println("distance"+totalAmount+"time"+info.getBasePrice());
		
		double amt=Math.ceil(totalAmount);
		   System.out.println("totalAmount========>"+amt);
		   
		   float amt1=(float)amt;
		   System.out.println("totalAmount========>"+amt1);
		
		Price pir=new Price(); 
		pir.setExtraDistance(extraDistance);
		pir.setExtraMins(extraMins);
		pir.setTotalAmount(amt1);
		return pir;
	}

	public float getTotalDistanceKm() {
		return totalDistanceKm;
	}

	public void setTotalDistanceKm(float totalDistanceKm) {
		this.totalDistanceKm = totalDistanceKm;
	}

	public float getTotalMins() {
		return totalMins;
	}

	public void setTotalMins(float totalMins) {
		this.totalMins = totalMins;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public float getExtraKmAmount() {
		return extraKmAmount;
	}

	public void setExtraKmAmount(float extraKmAmount) {
		this.extraKmAmount = extraKmAmount;
	}

	public float getExtraMinsAmount() {
		return extraMinsAmount;
	}

	public void setExtraMinsAmount(float extraMinsAmount) {
		this.extraMinsAmount = extraMinsAmount;
	}

	public float getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(float otherAmount) {
		this.otherAmount = otherAmount;
	}

	public float getExtraKm() {
		return extraKm;
	}

	public void setExtraKm(float extraKm) {
		this.extraKm = extraKm;
	}

	public float getApproximateAmount() {
		return approximateAmount;
	}

	public void setApproximateAmount(float approximateAmount) {
		this.approximateAmount = approximateAmount;
	}

	public float getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(float gstAmount) {
		this.gstAmount = gstAmount;
	}

	public String getServerDate() {
		return serverDate;
	}

	public void setServerDate(String serverDate) {
		this.serverDate = serverDate;
	}

	public String getServerTime() {
		return serverTime;
	}

	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}

	public String getNextDate() {
		return nextDate;
	}

	public void setNextDate(String nextDate) {
		this.nextDate = nextDate;
	}

	public int getLandPageStatus() {
		return landPageStatus;
	}

	public void setLandPageStatus(int landPageStatus) {
		this.landPageStatus = landPageStatus;
	}

	
	
	
}
