package com.std.account.api.impl;

import com.std.account.ao.ISYSDictAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802001Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 删除数据字典
 * @author: xieyj 
 * @since: 2016年9月17日 下午1:47:19 
 * @history:
 */
public class XN802001 extends AProcessor {
    private ISYSDictAO sysDictAO = SpringContextHolder
        .getBean(ISYSDictAO.class);

    private XN802001Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        sysDictAO.dropSYSDict(StringValidater.toLong(req.getId()));
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802001Req.class);
        StringValidater.validateBlank(req.getId());
    }
}
