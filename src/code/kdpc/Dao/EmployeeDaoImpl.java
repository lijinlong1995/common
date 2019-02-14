package code.kdpc.Dao;

import java.sql.SQLClientInfoException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import code.kdpc.pojo.Employee;

@Repository("EmployeeDao")
public class EmployeeDaoImpl   extends   SqlMapClientDaoSupport{

	@Resource(name = "sqlMapClient")
	private SqlMapClientTemplate sqlMapClient;

	@PostConstruct
	public void initsqlMapClient() {
		super.setSqlMapClientTemplate(sqlMapClient);
	}
	
	/**
	 * 登录
	 * @param employee
	 * @return
	 * @throws SQLClientInfoException
	 */
	public  Employee login(Employee  employee)throws  SQLClientInfoException{
		return (Employee)  sqlMapClient.queryForObject("express.login", employee);
	}
	
}
