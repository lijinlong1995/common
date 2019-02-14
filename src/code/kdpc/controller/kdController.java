package code.kdpc.controller;

import java.io.IOException;
import java.sql.SQLClientInfoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.eventmodel.ERFListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import code.kdpc.Service.EmployeeServiceImpl;
import code.kdpc.Service.KDBalanceServiceImpl;
import code.kdpc.pojo.Employee;
import code.kdpc.pojo.KDBalance;
import net.sf.json.JSONObject;
import util.E3Result;
import util.PageBean;

@Controller
@RequestMapping(value="/express")
public class kdController {

	
	@Resource(name="EmployeeService")
	private  EmployeeServiceImpl  EmployeeService;
	
	
	@Resource(name="KDBalanceService")
	private  KDBalanceServiceImpl  KDBalanceService;
	
	E3Result  e3Result  = new  E3Result();
	
	/**
	 * 登录
	 * @param employee
	 * @param response
	 */
	@RequestMapping("/login")
	@ResponseBody
    public  void   login(Employee  employee,HttpServletResponse  response){
    	response.addHeader("Access-Control-Allow-Origin", "*");
		 String jsonStr = "";
    	try {
			employee = EmployeeService.login(employee);
			e3Result.setData(employee);
			e3Result.setMsg("登录成功");
			e3Result.setStatus(200);
			 jsonStr = "callback("+JSONObject.fromObject(E3Result.ok(e3Result)).toString()+")";
		} catch (SQLClientInfoException e) {
			 jsonStr = "callback("+JSONObject.fromObject(E3Result.build(400, "网络出错！"))+")";
			e.printStackTrace();
		}
    	try {
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	/**
	 * 查询出审核列表
	 * @param kdBalance
	 * @param response
	 */
	@RequestMapping("/queryToBeAudited")
	@ResponseBody
	public  void  queryToBeAudited(KDBalance  kdBalance,HttpServletResponse  response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		 String jsonStr = "";
		 kdBalance.setBegin(kdBalance.getCurrentPage());
		 kdBalance.setEnd("20");
		 PageBean<KDBalance>   pageBean = null;
		 try {
			pageBean = KDBalanceService.queryToBeAudited(kdBalance);
			for(int  i = 0;i<pageBean.getQueryNumberList().size();i++){
				String  a = pageBean.getQueryNumberList().get(i).getFStoreId();
				String  WDName = KDBalanceService.queryStorebyFId(a);
				pageBean.getQueryNumberList().get(i).setFStoreId(WDName);
			}
			e3Result.setData(pageBean);
			e3Result.setMsg("查询出审核列表");
			e3Result.setStatus(200);
			jsonStr = "callback("+JSONObject.fromObject(E3Result.ok(e3Result)).toString()+")";
		} catch (SQLClientInfoException e) {
			 jsonStr = "callback("+JSONObject.fromObject(E3Result.build(400, "网络出错！"))+")";
			e.printStackTrace();
		}
		 try {
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改审核状态
	 * @param kdBalance
	 * @param response
	 * @throws ParseException 
	 */
	@RequestMapping("/updateKDStatus")
	@ResponseBody
	public  void updateKDStatus(KDBalance  kdBalance,HttpServletResponse  response) throws ParseException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		 String jsonStr = "";
		 KDBalance   kdBalance2 = new  KDBalance();
		 try {
			kdBalance2 = KDBalanceService.queryAllKDBalance(kdBalance.getFStoreId());
			if(kdBalance2 == null){
				int  a = (int)kdBalance.getFRecharge();
				int  b = a/50;
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date  currdate = df.parse(df.format(new  Date()));
				System.out.println("现在的日期是：" + currdate);
				Calendar ca = Calendar.getInstance();
				ca.add(Calendar.DATE, b);// num为增加的天数，可以改变的
				currdate = ca.getTime();
				String enddate = df.format(currdate);
				kdBalance.setFEffectTime(enddate);
				System.out.println("增加天数以后的日期：" + enddate);
			}else {
				int  a = (int)kdBalance.getFRecharge();
				int  b = a/50;
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date  currdate = df.parse(df.format(new  Date()));
				System.out.println("现在的日期是：" + currdate);
				Calendar ca = Calendar.getInstance();
				ca.add(Calendar.DATE, b);// num为增加的天数，可以改变的
				currdate = ca.getTime();
				String enddate = df.format(currdate);
				kdBalance.setFEffectTime(enddate);
				System.out.println("增加天数以后的日期：" + enddate);
			}
			KDBalanceService.updateKDStatus(kdBalance);
			e3Result.setMsg("修改成功");
			e3Result.setStatus(200);
			jsonStr = "callback("+JSONObject.fromObject(E3Result.ok(e3Result)).toString()+")";
		} catch (SQLClientInfoException e) {
			jsonStr = "callback("+JSONObject.fromObject(E3Result.build(400, "网络出错！"))+")";
			e.printStackTrace();
		}
		 try {
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
