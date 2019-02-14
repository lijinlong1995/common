package code.kdpc.pojo;
//员工
public class Employee {
private  String  FType;	
private  String  FId;	
private String FName;
private  String  FWorkNumber;//工号
private  String  FAccount;
private  String  FPhone;
private  String  FPassword;
private  String  FExpressNetworkId;//快递网点Id
private  String  FComment;
private  String  FCreateTime;
private  String  begin;
private String   end;
private String   currentPage = "1";
private  String FDeviceId;

public String getFDeviceId() {
	return FDeviceId;
}
public void setFDeviceId(String fDeviceId) {
	FDeviceId = fDeviceId;
}
public String getFType() {
	return FType;
}
public void setFType(String fType) {
	FType = fType;
}
public String getFId() {
	return FId;
}
public void setFId(String fId) {
	FId = fId;
}
public String getBegin() {
	return begin;
}
public void setBegin(String begin) {
	this.begin = begin;
}
public String getEnd() {
	return end;
}
public void setEnd(String end) {
	this.end = end;
}
public String getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(String currentPage) {
	this.currentPage = currentPage;
}
public String getFName() {
	return FName;
}
public void setFName(String fName) {
	FName = fName;
}
public String getFWorkNumber() {
	return FWorkNumber;
}
public void setFWorkNumber(String fWorkNumber) {
	FWorkNumber = fWorkNumber;
}
public String getFAccount() {
	return FAccount;
}
public void setFAccount(String fAccount) {
	FAccount = fAccount;
}
public String getFPhone() {
	return FPhone;
}
public void setFPhone(String fPhone) {
	FPhone = fPhone;
}
public String getFPassword() {
	return FPassword;
}
public void setFPassword(String fPassword) {
	FPassword = fPassword;
}
public String getFExpressNetworkId() {
	return FExpressNetworkId;
}
public void setFExpressNetworkId(String fExpressNetworkId) {
	FExpressNetworkId = fExpressNetworkId;
}
public String getFComment() {
	return FComment;
}
public void setFComment(String fComment) {
	FComment = fComment;
}
public String getFCreateTime() {
	return FCreateTime;
}
public void setFCreateTime(String fCreateTime) {
	FCreateTime = fCreateTime;
}

}
