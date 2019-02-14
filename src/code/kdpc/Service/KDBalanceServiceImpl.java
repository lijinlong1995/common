package code.kdpc.Service;

import java.sql.SQLClientInfoException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import code.kdpc.Dao.KDBalanceDaoImpl;
import code.kdpc.pojo.KDBalance;
import util.PageBean;


@Service("KDBalanceService")
public class KDBalanceServiceImpl {
@Resource(name="KDBalanceDao")
private  KDBalanceDaoImpl  KDBalanceDao;


/**
 * 查询未审核列表
 * @return
 * @throws SQLClientInfoException
 */
public PageBean<KDBalance> queryToBeAudited (KDBalance kdBalance) throws SQLClientInfoException {
	PageBean<KDBalance> PageBean=new PageBean<KDBalance>();
	PageBean.setCurrentPage(Integer.valueOf(kdBalance.getBegin()));
	PageBean.setCurrentCount(Integer.valueOf(kdBalance.getEnd()));
	Integer totalCount=KDBalanceDao.queryToBeAuditedCount(kdBalance);
	PageBean.setTotalCount(totalCount);
	int totalPage= 0;
	if(totalCount% 20 == 0){
		totalPage=totalCount/ 20;
	}else {
		totalPage=totalCount/20+ 1;
	}
	PageBean.setTotalPage(totalPage);
	kdBalance.setEnd(String.valueOf(Integer.valueOf(kdBalance.getBegin())* 20));
	kdBalance.setBegin(String.valueOf((Integer.valueOf(kdBalance.getBegin()) - 1) * 20));
	PageBean.setQueryNumberList(KDBalanceDao.queryToBeAudited(kdBalance));
	return PageBean;
}

/**
 * 修改充值状态
 * @param kdBalance
 * @throws SQLClientInfoException
 */
public  void updateKDStatus(KDBalance kdBalance)throws  SQLClientInfoException{
	KDBalanceDao.updateKDStatus(kdBalance);
}

/**
 * 根据FID查询网点名称
 * @param FId
 * @return
 * @throws SQLClientInfoException
 */
public  String  queryStorebyFId(String  FId)throws  SQLClientInfoException{
	return  KDBalanceDao.queryStorebyFId(FId);
}

/**
 * 查询网点缴费详情
 * @param FStoreId
 * @return
 * @throws SQLClientInfoException
 */
public  KDBalance  queryAllKDBalance(String  FStoreId)throws  SQLClientInfoException{
	return  KDBalanceDao.queryAllKDBalance(FStoreId);
}
}
