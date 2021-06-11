package com;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.asn1.ocsp.ResponseData;


import java.util.ArrayList;
import java.util.List;

public class IpFilter extends ZuulFilter {
    List<String> iplist = null;
     {
        iplist = new ArrayList<>();
          iplist.add("192.168.56.1");
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        String ip = IpUtils.getIpAddr(ctx.getRequest());
        if(StringUtils.isNotBlank(ip)&&iplist.contains(ip)){
                ctx.setSendZuulResponse(false);
                ctx.setResponseBody("非法ip请求");
            ctx.getResponse().setContentType("application/json; charset=utf-8");

        }
        return null;
    }
}
