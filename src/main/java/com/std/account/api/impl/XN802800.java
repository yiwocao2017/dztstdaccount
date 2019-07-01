package com.std.account.api.impl;

import com.std.account.ao.IJourAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802800Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/** 
 * 人工对账
 * @author: xieyj 
 * @since: 2016年12月25日 下午3:48:54 
 * @history:
 */
public class XN802800 extends AProcessor {
    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN802800Req req = null;

    @Override
    public synchronized Object doBusiness() throws BizException {
        Long checkAmount = StringValidater.toLong(req.getCheckAmount());
        jourAO.checkJour(req.getCode(), checkAmount, req.getCheckUser(),
            req.getCheckNote(), req.getSystemCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802800Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCheckNote(),
            req.getCheckUser(), req.getSystemCode());
        StringValidater.validateAmount(req.getCheckAmount());
    }
}
