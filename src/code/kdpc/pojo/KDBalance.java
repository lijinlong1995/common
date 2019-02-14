package code.kdpc.pojo;
//充值类
public class KDBalance {
private  String  FId;
private  float  FRecharge;//充值金额
private  String  FStatus;//状态: 0--待审核     1--审核通过   2--审核未通过
private  String FStoreId;//网点id
private  String FVouch;//充值凭证
private  String  FEffectTime;//有效期
private  String FCreateTime;
private String begin;
private String end;
private String currentPage = "1";

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
public String getFVouch() {
	return FVouch;
}
public void setFVouch(String fVouch) {
	FVouch = fVouch;
}
public String getFId() {
	return FId;
}
public void setFId(String fId) {
	FId = fId;
}
public float getFRecharge() {
	return FRecharge;
}
public void setFRecharge(float fRecharge) {
	FRecharge = fRecharge;
}
public String getFStatus() {
	return FStatus;
}
public void setFStatus(String fStatus) {
	FStatus = fStatus;
}
public String getFStoreId() {
	return FStoreId;
}
public void setFStoreId(String fStoreId) {
	FStoreId = fStoreId;
}
public String getFEffectTime() {
	return FEffectTime;
}
public void setFEffectTime(String fEffectTime) {
	FEffectTime = fEffectTime;
}
public String getFCreateTime() {
	return FCreateTime;
}
public void setFCreateTime(String fCreateTime) {
	FCreateTime = fCreateTime;
}

}
