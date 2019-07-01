package com.std.account.dao;

import com.std.account.dao.base.IBaseDAO;
import com.std.account.domain.Jour;

/**
 * @author: xieyj 
 * @since: 2016年12月23日 上午11:25:21 
 * @history:
 */
public interface IJourDAO extends IBaseDAO<Jour> {
    String NAMESPACE = IJourDAO.class.getName().concat(".");

    /**
     * 对账结果录入
     * @param data
     * @return 
     * @create: 2016年11月10日 下午6:05:41 xieyj
     * @history:
     */
    public int checkJour(Jour data);

    /**
     * 调账后状态更新
     * @param data
     * @return 
     * @create: 2016年12月26日 下午9:29:23 xieyj
     * @history:
     */
    public int adjustJour(Jour data);

    public long selectTotalAmount(Jour data);
}
