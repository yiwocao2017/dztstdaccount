/**
 * @Title XN802182.java 
 * @Package com.std.account.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月23日 上午9:23:43 
 * @version V1.0   
 */
package com.std.account.api.impl;

import com.std.account.ao.IWeChatAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN002501Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/** 
 * 微信H5支付请求接口，返回预付单信息
 * @author: haiqingzheng 
 * @since: 2016年12月23日 上午9:23:43 
 * @history:
 */
public class XN002501 extends AProcessor {
    private IWeChatAO weChatAO = SpringContextHolder.getBean(IWeChatAO.class);

    private XN002501Req req = null;

    /** 
     * @see com.std.account.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Long transAmount = StringValidater.toLong(req.getAmount());
        return weChatAO.getPrepayIdH5(req.getApplyUser(), req.getOpenId(),
            req.getToUser(), req.getPayGroup(), req.getRefNo(),
            req.getBizType(), req.getBizNote(), transAmount, req.getBackUrl());
    }

    /** 
     * @see com.std.account.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN002501Req.class);
        StringValidater.validateAmount(req.getAmount());
        StringValidater.validateBlank(req.getApplyUser(), req.getOpenId(),
            req.getToUser(), req.getPayGroup(), req.getRefNo(),
            req.getBizType(), req.getBizNote(), req.getBackUrl());

    }
}
