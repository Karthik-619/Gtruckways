package com.cogzy.gtruckways.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import com.cogzy.gtruckways.businessObjects.AmountDetails;
import com.cogzy.gtruckways.businessObjects.Deductions;
import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.Incentives;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.LocalTransporter;
import com.cogzy.gtruckways.businessObjects.Post;

import com.cogzy.gtruckways.businessObjects.Transporter;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.dao.EnterpriseCustomerDao;

import com.cogzy.gtruckways.daoImpl.TransporterDaoImpl;
import com.cogzy.gtruckways.service.TransporterService;
import com.cogzy.gtruckways.valueObjects.TeleAddTrucksInfo;

import com.cogzy.gtruckways.valueObjects.TransporterRequestPojo;

public class TransporterServiceImpl implements TransporterService {
	TransporterDaoImpl TransporterDao;
	EnterpriseCustomerDao ecdao;
	
	
	public EnterpriseCustomerDao getEcdao() {
		return ecdao;
	}


	public void setEcdao(EnterpriseCustomerDao ecdao) {
		this.ecdao = ecdao;
	}

	
	public TransporterDaoImpl getTransporterDao() {
		return TransporterDao;
	}

	public void setTransporterDao(TransporterDaoImpl transporterDao) {
		TransporterDao = transporterDao;
	}

public List<LocalTransporter> getTransporterDetails() {
		
		List<LocalTransporter> trans=TransporterDao.getTransporterDetails();
		return trans;
	}
	
	public LocalTransporter getTransMobDetails(String Mobile) {
		
		LocalTransporter tran=TransporterDao.getTransMobDetails(Mobile);
		return tran;
	}
	
	public List<Vehicle> getVehicleDetailsByMob(String Mobile) {
		
		List<Vehicle> veh=TransporterDao.getVehicleDetailsByMob(Mobile);
		return veh;
	}
	
	public LocalTransporter getTransportDetails(int transId) {
		
		LocalTransporter tran=TransporterDao.getTransportDetails(transId);
		return tran;
	}
	
	public List<Vehicle> getVehicleDetails(int transId) {
		
		List<Vehicle> veh=TransporterDao.getVehicleDetails(transId);
		return veh;
	}
	
	public int	SaveTransConfirm(int driverId, Post pos){
		
		int status=TransporterDao.SaveTransConfirm(driverId,pos);
		return status;
	}
	
	
	
	
	public boolean checkDuplicateVehicle(TeleAddTrucksInfo addTruck) {
		Vehicle veh=new Vehicle();
		
		veh.setVehicleRegistrationNo(addTruck.getVehicleNum());
		 
		boolean vehicle=TransporterDao.checkDuplicateVehicle(veh);
		return vehicle;
		
	}

	public boolean checkDuplicateDriver(TeleAddTrucksInfo addTruck) {
		LocalDriver LocDriver=new LocalDriver();
		
		LocDriver.setDlNo(addTruck.getDLNum());
		LocDriver.setMobile(addTruck.getDriverMobile());
		
		boolean driver=TransporterDao.checkDuplicateDriver(LocDriver);
		return driver;
		
	}

	

	
	@Override
	public List<EnterpriseCustomer> getEnterpriseDetails() {
	
		List<EnterpriseCustomer> ec=ecdao.getEnterpriseDetails();
		
		return ec;
	}

	@Override
	public String AddNewTrucks(TeleAddTrucksInfo addTruck) {
		
	try{	
		
		LocalDriver LocDriver=new LocalDriver();
		Vehicle veh=new Vehicle();
		LocalTransporter locTrans=new LocalTransporter();
		
		
		locTrans.setTransporterId(addTruck.getTransportID());
		
		LocDriver.setAddress(addTruck.getDriverAddress());
		LocDriver.setDlIssueDate(addTruck.getDLissueDate());
		LocDriver.setDlNo(addTruck.getDLNum());
		LocDriver.setDlValidity(addTruck.getDLValidTillDate());
		LocDriver.setDriverName(addTruck.getDriverName());
		LocDriver.setEmailId(addTruck.getDriverEmail());
		LocDriver.setMobile(addTruck.getDriverMobile());
		
		veh.setBhp(addTruck.getBHP());
		veh.setBrand(addTruck.getMakerName());
		veh.setCubicCapacity(addTruck.getCubicCapacity());
		veh.setDimension(addTruck.getDimension());
		
		veh.setEngineNo(addTruck.getEngineNum());
		veh.setFcNo(addTruck.getFCNum());
		veh.setFcValidity(addTruck.getFCValidTillDate());
		veh.setInsuranceOwner(addTruck.getPolicyOwnName());
		veh.setPayLoadCapacity(addTruck.getPayLoadCap());
		veh.setActType(addTruck.getUserType());
		
		if(addTruck.getTypeOfPermit().equals("National Permit"))
		{
			veh.setPermitType(addTruck.getTypeOfPermit());
			veh.setPermitStates("All States");
		}
		else
		{
			veh.setPermitType(addTruck.getTypeOfPermit());
			veh.setPermitStates(addTruck.getStateName());
		}
		veh.setPermitValidity(addTruck.getPermitValidTillDate());
		veh.setPollutionCertNo(addTruck.getPUCCNum());
		veh.setPollutionCertValidity(addTruck.getPUCCExpDate());
		veh.setRegistrationDate(addTruck.getVehRegDate());
		veh.setRegValidity(addTruck.getRegValidTillDate());
		
		veh.setVehicleChasisNo(addTruck.getChassisNum());
		veh.setVehicleInsuranceExpiryDate(addTruck.getPolicyExpDate());
		veh.setVehicleInsuranceNo(addTruck.getPolicyNum());
		veh.setVehicleName(addTruck.getVehicleName());
		
		System.out.println("Vehicle Name "+addTruck.getVehicleName());
		veh.setVehicleRegistrationNo(addTruck.getVehicleNum());
		veh.setVehicleType(addTruck.getVehicleName());
		veh.setTransporter(locTrans);
		veh.setDriverId(LocDriver);
		LocalDateTime dt=LocalDateTime.now().withNano(0);
		User use=new User();
		String password=use.getUserpassword();
		LocDriver.setPassword(password);
		LocDriver.setDriverStatus("33");
		int truckId=TransporterDao.getTrcukId(addTruck.getVehicleName()); 
		TransporterDao.AddToDriverVehicle(LocDriver,veh,locTrans.getTransporterId(),truckId,dt);
		return password;
	
	} catch(Exception e){
		
		return "ABB";
	}
		
	}
	

	@Override
	public int saveTransporter(TransporterRequestPojo trans) {
		
	
		
		 Transporter transinfo =new Transporter();
		 transinfo.setTransportName(trans.getTransportName());
		 transinfo.setContactName(trans.getContactName());
		 transinfo.setTransportMobileNo(trans.getTransportMobileNo());
		 transinfo.setTransportEmail(trans.getTransportEmail());
		 transinfo.setTransportAddress(trans.getTransportAddress());
		 transinfo.setTransportPan(trans.getTransportPan());
		 transinfo.setTransportIdProof("1");
		 transinfo.setIdProofNumber(trans.getTransportAdhar());
		 LocalDateTime date=LocalDateTime.now().minusSeconds(0).minusNanos(0); 
		 
		 
		 if(trans.getTransporterActive()==1){
		 
		 transinfo.setAccHolderName(trans.getAccHolderName());
		 transinfo.setAccNumber(trans.getAccNumber());
		 transinfo.setBankName(trans.getBankName());
		 transinfo.setBankBranch(trans.getBankBranch());
		 transinfo.setIfscCode(trans.getIfscCode());
		 transinfo.setTransportCheque(trans.getTransportCheque());
		 
		 }  else{
			 
			 transinfo.setAccHolderName("");
			 transinfo.setAccNumber("");
			 transinfo.setBankName("");
			 transinfo.setBankBranch("");
			 transinfo.setIfscCode("");
			 transinfo.setTransportCheque("0");
			 
			 
			 
			 
		 }
		 
		 
		 
		int sucess=TransporterDao.saveTransporter(transinfo,date,trans.getTransporterActive());
		
		return 1;
	}


	@Override
	public boolean checkDuplicateTransporter(TransporterRequestPojo trans) {
	
		Transporter transinfo=new Transporter();
		
		transinfo.setTransportMobileNo(trans.getTransportMobileNo());
		transinfo.setTransportPan(trans.getTransportPan());
		
		boolean transporter=TransporterDao.checkDuplicateTransporter(transinfo);
		return transporter;
		
	}



	@Override
	public List<Post> getTransporterPayemntInformation(String fromDate,String toDate,String transporterId) {

		
		if(transporterId!=null)
		{
			List<Post> pos=TransporterDao.getTransporterPaymentInformation(fromDate,toDate,transporterId);
						
			return pos;
		}
		{
			List<Post> pos=TransporterDao.getAllTransporterPaymentInformation(fromDate,toDate);
			return pos;
		}
		
	}


	@Override
	public AmountDetails getTotalAmount(String fromDate, String toDate, String transporterId) {
		
		int transId=Integer.parseInt(transporterId);
		System.out.println("sdkjhyftgujyeafrtg8ia74wytgfihty4yw3t89ow34y"+transId);
		AmountDetails amt=TransporterDao.getAllTotalAmount(fromDate, toDate, transId);
		
		return amt;
	}


	@Override
	public Vehicle getVehicleInformation(String vehRegNum) {

		Vehicle veh=TransporterDao.getVehicleInformation(vehRegNum);
		return veh;
	}


	@Override
	public boolean checkValidTransId(int TransId) {
		
		boolean transId=TransporterDao.checkValidTransId(TransId);
		return transId;

	}

	@Override
	public Deductions getTransporterDeduction(Post p) {
		Deductions ded=TransporterDao.getTransporterDeduction(p);;
		return ded;
	}


	@Override
	public Incentives getTransporterIncentive(Post p) {
		Incentives inc=TransporterDao.getTransporterIncentive(p);
		return inc;
	}
	
}
