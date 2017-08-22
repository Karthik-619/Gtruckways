package com.cogzy.gtruckways.businessObjects;

import java.util.List;

public class Post {

	private int invoiceId;
	
	private String bookingId;
	
	private User user;
	
	private String fromCity;
	
	private String toCity;
	
	private String material;
	
	private String pickUpArea;
	
	private String dropArea;
	
	private String postDate;
	
	private String travelDate;
	
	private int helper;
	
	private int differentRecepient;
	
	private String recepientName;
	
	private String recepientMobile;
	
	private float approximateKm;
	
	private int approximateMins;
	
	private float approximateAmount;
	
	private float totalAmount;
	
	private String  status;
	
	private String loadingDateTime;
	
	private String unloadingDateTime;
	
	private String srcReachedDateTime;
	
	private String destReachedDateTime;
	
	private int valueOfGoods;
	
	private int approximateWeight;
	
	private double sLat;
	
	private double sLong;
	
	private double dLat;
	
	private double dLong;
	
	private String promocode;
	
	private float discountAmount;
	
	private int statusCode;
	
	private String statusMessage;
	
	private float totalKm;
	
	private float totalMins;
	
	private float otherAmount;
	
	private float extraKm;
	
	private float extraMins;
	
	private float extraKmAmount;
	
	private float extraMinsAmount;
	
	private float driverAmount;
	
	private float gtruckwaysAmount;
	
	private float helperAmount;
	
	private float basePrice;
	
	private float freeKm;
	
	private float freeMins;
	
	private float gstAmount;
	
	private float nightCharges;
	
	private  String gstNumber;
	
	private TruckInfo infoTruck;
	
	private String bookedThrough;
	
	private List<Post> post;
	
	private String truckId;
	
	private String truckType;
	
	private String mobileNo;
	
	
	
	
	
	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public int getApproximateMins() {
		return approximateMins;
	}

	public void setApproximateMins(int approximateMins) {
		this.approximateMins = approximateMins;
	}

	public String getPromocode() {
		return promocode;
	}

	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}

	public float getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}

	private int postId;
	private String refPostId;

	
	private int floor;


	private Price price;
	
	
	
	
	
	
	public int getValueOfGoods() {
		return valueOfGoods;
	}

	public void setValueOfGoods(int valueOfGoods) {
		this.valueOfGoods = valueOfGoods;
	}

	public int getApproximateWeight() {
		return approximateWeight;
	}

	public void setApproximateWeight(int approximateWeight) {
		this.approximateWeight = approximateWeight;
	}

	private String acceptedTime;
	
	

	
	
	
	private float additionalAmount;
	private float transporterAmount;


	private Transporter transporter;
	private Vehicle vehi;

	

	
	private int truckTypeId;
	
	
	
	
	private LocalDriver driver;
	private String userType;
	public double getsLat() {
		return sLat;
	}

	public void setsLat(double sLat) {
		this.sLat = sLat;
	}

	public double getsLong() {
		return sLong;
	}

	public void setsLong(double sLong) {
		this.sLong = sLong;
	}

	public double getdLat() {
		return dLat;
	}

	public void setdLat(double dLat) {
		this.dLat = dLat;
	}

	public double getdLong() {
		return dLong;
	}

	public void setdLong(double dLong) {
		this.dLong = dLong;
	}

	public float getApproximateKm() {
		return approximateKm;
	}

	public void setApproximateKm(float approximateKm) {
		this.approximateKm = approximateKm;
	}


	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public Vehicle getVehi() {
		return vehi;
	}

	public void setVehi(Vehicle vehi) {
		this.vehi = vehi;
	}

	public float getApproximateAmount() {
		return approximateAmount;
	}

	public void setApproximateAmount(float approximateAmount) {
		this.approximateAmount = approximateAmount;
	}

	public float getTransporterAmount() {
		return transporterAmount;
	}

	public void setTransporterAmount(float transporterAmount) {
		this.transporterAmount = transporterAmount;
	}

	public float getGtruckwaysAmount() {
		return gtruckwaysAmount;
	}

	public void setGtruckwaysAmount(float gtruckwaysAmount) {
		this.gtruckwaysAmount = gtruckwaysAmount;
	}

	public float getExtraKm() {
		return extraKm;
	}

	public void setExtraKm(float extraKm) {
		this.extraKm = extraKm;
	}

	public float getExtraMins() {
		return extraMins;
	}

	public void setExtraMins(float extraMins) {
		this.extraMins = extraMins;
	}

	public float getAdditionalAmount() {
		return additionalAmount;
	}

	public void setAdditionalAmount(float additionalAmount) {
		this.additionalAmount = additionalAmount;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getLoadingDateTime() {
		return loadingDateTime;
	}

	public void setLoadingDateTime(String loadingDateTime) {
		this.loadingDateTime = loadingDateTime;
	}

	public String getUnloadingDateTime() {
		return unloadingDateTime;
	}

	public void setUnloadingDateTime(String unloadingDateTime) {
		this.unloadingDateTime = unloadingDateTime;
	}

	public String getSrcReachedDateTime() {
		return srcReachedDateTime;
	}

	public void setSrcReachedDateTime(String srcReachedDateTime) {
		this.srcReachedDateTime = srcReachedDateTime;
	}

	public String getDestReachedDateTime() {
		return destReachedDateTime;
	}

	public void setDestReachedDateTime(String destReachedDateTime) {
		this.destReachedDateTime = destReachedDateTime;
	}

	

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getRefPostId() {
		return refPostId;
	}

	public void setRefPostId(String refPostId) {
		this.refPostId = refPostId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getPickUpArea() {
		return pickUpArea;
	}

	public void setPickUpArea(String pickUpArea) {
		this.pickUpArea = pickUpArea;
	}

	public String getDropArea() {
		return dropArea;
	}

	public void setDropArea(String dropArea) {
		this.dropArea = dropArea;
	}

	public int getHelper() {
		return helper;
	}

	public void setHelper(int helper) {
		this.helper = helper;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	

	public String getRecepientName() {
		return recepientName;
	}

	public void setRecepientName(String recepientName) {
		this.recepientName = recepientName;
	}

	public String getRecepientMobile() {
		return recepientMobile;
	}

	public void setRecepientMobile(String recepientMobile) {
		this.recepientMobile = recepientMobile;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAcceptedTime() {
		return acceptedTime;
	}

	public void setAcceptedTime(String acceptedTime) {
		this.acceptedTime = acceptedTime;
	}

	public LocalDriver getDriver() {
		return driver;
	}

	public void setDriver(LocalDriver driver) {
		this.driver = driver;
	}

	public int getTruckTypeId() {
		return truckTypeId;
	}

	public void setTruckTypeId(int truckTypeId) {
		this.truckTypeId = truckTypeId;
	}

	

	public float getTotalKm() {
		return totalKm;
	}

	public void setTotalKm(float totalKm) {
		this.totalKm = totalKm;
	}

	public float getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(float otherAmount) {
		this.otherAmount = otherAmount;
	}

	public float getTotalMins() {
		return totalMins;
	}

	public void setTotalMins(float totalMins) {
		this.totalMins = totalMins;
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

	public float getDriverAmount() {
		return driverAmount;
	}

	public void setDriverAmount(float driverAmount) {
		this.driverAmount = driverAmount;
	}

	public TruckInfo getInfoTruck() {
		return infoTruck;
	}

	public void setInfoTruck(TruckInfo infoTruck) {
		this.infoTruck = infoTruck;
	}

	public float getHelperAmount() {
		return helperAmount;
	}

	public void setHelperAmount(float helperAmount) {
		this.helperAmount = helperAmount;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public float getFreeKm() {
		return freeKm;
	}

	public void setFreeKm(float freeKm) {
		this.freeKm = freeKm;
	}

	public float getFreeMins() {
		return freeMins;
	}

	public void setFreeMins(float freeMins) {
		this.freeMins = freeMins;
	}

	public float getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(float gstAmount) {
		this.gstAmount = gstAmount;
	}

	public float getNightCharges() {
		return nightCharges;
	}

	public void setNightCharges(float nightCharges) {
		this.nightCharges = nightCharges;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public String getBookedThrough() {
		return bookedThrough;
	}

	public void setBookedThrough(String bookedThrough) {
		this.bookedThrough = bookedThrough;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	

	public String getTruckId() {
		return truckId;
	}

	public void setTruckId(String truckId) {
		this.truckId = truckId;
	}

	public int getDifferentRecepient() {
		return differentRecepient;
	}

	public void setDifferentRecepient(int differentRecepient) {
		this.differentRecepient = differentRecepient;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	
	
}
