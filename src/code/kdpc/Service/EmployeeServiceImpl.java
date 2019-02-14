package code.kdpc.Service;

import java.sql.SQLClientInfoException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import code.kdpc.Dao.EmployeeDaoImpl;
import code.kdpc.pojo.Employee;
import util.MD5Util;
import util.PageBean;


@Service("EmployeeService")
public class EmployeeServiceImpl {
@Resource(name="EmployeeDao")
private  EmployeeDaoImpl  EmployeeDao;

/**
 * 登录
 * @param employee
 * @return
 * @throws SQLClientInfoException
 */
public  Employee login(Employee  employee)throws  SQLClientInfoException{
	employee.setFPassword(MD5Util.getMD5String(employee.getFPassword()));
	return EmployeeDao.login(employee);
	}

}
