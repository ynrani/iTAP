package com.itap.model.DTO;



import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tdmBankReservationDTO")
public class TDMBankReservationDTO
{

	
	private String userId;
	private String recCreateDate;
	private String reserveDate;
	private String unreservDate;
	private String testCaseId;
	private String testCaseName;
	private String projectID;
	private String locked;

	private String accNum;
	
	private String accBal;
	private String branchCode;
	private String accStatus;
	private String title;
	private String custName;
	private String custSurName;
	private String custNum;
	private String buildingNum;
	private String addrLn1;
	private String addrLn2;
	private String city;
	private String country;
	private String zipCode;
	private String custType;
	private String creditCardNum;
	private String unreserveYN;
	private List<TDMBankReservationDTO> listTDMBankReservationDTO;
	
	public TDMBankReservationDTO(){}

	@XmlElement
	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	@XmlElement
	public String getRecCreateDate()
	{
		return recCreateDate;
	}

	public void setRecCreateDate(String recCreateDate)
	{
		this.recCreateDate = recCreateDate;
	}
	@XmlElement
	public String getReserveDate()
	{
		return reserveDate;
	}

	public void setReserveDate(String reserveDate)
	{
		this.reserveDate = reserveDate;
	}
	@XmlElement
	public String getUnreservDate()
	{
		return unreservDate;
	}

	public void setUnreservDate(String unreservDate)
	{
		this.unreservDate = unreservDate;
	}
	@XmlElement
	public String getTestCaseId()
	{
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId)
	{
		this.testCaseId = testCaseId;
	}
	@XmlElement
	public String getTestCaseName()
	{
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName)
	{
		this.testCaseName = testCaseName;
	}
	@XmlElement
	public String getProjectID()
	{
		return projectID;
	}

	public void setProjectID(String projectID)
	{
		this.projectID = projectID;
	}
	@XmlElement
	public String getLocked()
	{
		return locked;
	}

	public void setLocked(String locked)
	{
		this.locked = locked;
	}
	@XmlElement
	public String getAccNum()
	{
		return accNum;
	}

	public void setAccNum(String accNum)
	{
		this.accNum = accNum;
	}
	@XmlAttribute(name="accBal")
	public String getAccBal()
	{
		return accBal;
	}

	public void setAccBal(String accBal)
	{
		this.accBal = accBal;
	}
	@XmlElement
	public String getBranchCode()
	{
		return branchCode;
	}

	public void setBranchCode(String branchCode)
	{
		this.branchCode = branchCode;
	}
	@XmlElement
	public String getAccStatus()
	{
		return accStatus;
	}

	public void setAccStatus(String accStatus)
	{
		this.accStatus = accStatus;
	}
	@XmlElement
	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
	@XmlElement
	public String getCustName()
	{
		return custName;
	}

	public void setCustName(String custName)
	{
		this.custName = custName;
	}
	@XmlElement
	public String getCustSurName()
	{
		return custSurName;
	}

	public void setCustSurName(String custSurName)
	{
		this.custSurName = custSurName;
	}
	@XmlElement
	public String getCustNum()
	{
		return custNum;
	}

	public void setCustNum(String custNum)
	{
		this.custNum = custNum;
	}
	@XmlElement
	public String getBuildingNum()
	{
		return buildingNum;
	}

	public void setBuildingNum(String buildingNum)
	{
		this.buildingNum = buildingNum;
	}
	@XmlElement
	public String getAddrLn1()
	{
		return addrLn1;
	}

	public void setAddrLn1(String addrLn1)
	{
		this.addrLn1 = addrLn1;
	}
	@XmlElement
	public String getAddrLn2()
	{
		return addrLn2;
	}

	public void setAddrLn2(String addrLn2)
	{
		this.addrLn2 = addrLn2;
	}
	@XmlElement
	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}
	@XmlElement
	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}
	@XmlElement
	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	@XmlElement
	public String getCustType()
	{
		return custType;
	}

	public void setCustType(String custType)
	{
		this.custType = custType;
	}
	@XmlElement
	public String getCreditCardNum()
	{
		return creditCardNum;
	}

	public void setCreditCardNum(String creditCardNum)
	{
		this.creditCardNum = creditCardNum;
	}
	@XmlElement
	public String getUnreserveYN()
	{
		return unreserveYN;
	}

	public void setUnreserveYN(String unreserveYN)
	{
		this.unreserveYN = unreserveYN;
	}
	@XmlElement
	public List<TDMBankReservationDTO> getListTDMBankReservationDTO(){
		return listTDMBankReservationDTO;
	}

	public void setListTDMBankReservationDTO(List<TDMBankReservationDTO> listTDMBankReservationDTO){
		this.listTDMBankReservationDTO = listTDMBankReservationDTO;
	}
}
