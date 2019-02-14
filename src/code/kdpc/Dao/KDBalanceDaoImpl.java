package code.kdpc.Dao;
import java.sql.SQLClientInfoException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import code.kdpc.pojo.KDBalance;


@Repository("KDBalanceDao")
public class KDBalanceDaoImpl extends SqlMapClientDaoSupport{
	@Resource(name="sqlMapClient")
	private  SqlMapClientTemplate sqlMapClient;

	@PostConstruct
	public void initsqlMapClient() {
		super.setSqlMapClientTemplate(sqlMapClient);
	}
	
	/**
	 * 添加设备使用金
	 * @param kdBalance
	 * @throws SQLClientInfoException
	 */
	public  void  AddKDBalance(KDBalance   kdBalance)throws  SQLClientInfoException{
		sqlMapClient.insert("express.AddKDBalance", kdBalance);
	}
	
	
	/**
	 * 查询未审核列表
	 * @return
	 * @throws SQLClientInfoException
	 */
	public  List<KDBalance>  queryToBeAudited(KDBalance kdBalance)throws  SQLClientInfoException{
		return  sqlMapClient.queryForList("express.queryToBeAudited",kdBalance);
	}
	
	/**
	 * 查询未审核列表数量
	 * @param kdBalance
	 * @return
	 * @throws SQLClientInfoException
	 */
	public  Integer  queryToBeAuditedCount(KDBalance  kdBalance)throws  SQLClientInfoException{
		return (Integer)  sqlMapClient.queryForObject("express.queryToBeAuditedCount", kdBalance);
	}
	
	/**
	 * 修改充值状态
	 * @param kdBalance
	 * @throws SQLClientInfoException
	 */
	public  void updateKDStatus(KDBalance kdBalance)throws  SQLClientInfoException{
		sqlMapClient.update("express.updateKDStatus", kdBalance);
	}
	
	/**
	 * 根据FID查询网点名称
	 * @param FId
	 * @return
	 * @throws SQLClientInfoException
	 */
	public  String  queryStorebyFId(String  FId)throws  SQLClientInfoException{
		return  (String)  sqlMapClient.queryForObject("express.queryStorebyFId", FId);
	}
	
	/**
	 * 查询网点缴费详情
	 * @param FStoreId
	 * @return
	 * @throws SQLClientInfoException
	 */
	public  KDBalance  queryAllKDBalance(String  FStoreId)throws  SQLClientInfoException{
		return  (KDBalance)  sqlMapClient.queryForObject("express.queryAllKDBalance", FStoreId);
	}
}
