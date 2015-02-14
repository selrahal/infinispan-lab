package com.rhc.jdg.interceptor;

import org.infinispan.commands.VisitableCommand;
import org.infinispan.context.InvocationContext;
import org.infinispan.interceptors.base.BaseCustomInterceptor;


public class LoggingCacheInterceptor extends BaseCustomInterceptor{
	@Override
	protected Object handleDefault(InvocationContext ctx,
			VisitableCommand command) throws Throwable {
		System.out.println("Intercepting! " + ctx + ":" + command);
		return super.handleDefault(ctx, command);
	}
}
