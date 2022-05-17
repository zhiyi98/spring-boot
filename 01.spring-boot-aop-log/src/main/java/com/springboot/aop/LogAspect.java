package com.springboot.aop;

import com.springboot.entity.SysLog;
import com.springboot.util.HttpContextUtils;
import com.springboot.util.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogAspect {

  /**
   * 声明切点
   */
  @Pointcut("@annotation(com.springboot.annotation.Log)")
  public void pointcut() {
  }

  /**
   * 切入位置
   *
   */
  @Around("pointcut()")
  public void around(ProceedingJoinPoint point) {
    long beginTime = System.currentTimeMillis();
    try {
      // 执行方法
      point.proceed();
    } catch (Throwable e) {
      e.printStackTrace();
    }
    // 执行时长(毫秒)
    long time = System.currentTimeMillis() - beginTime;
    // 保存日志
    saveLog(point, time);
  }

  private void saveLog(ProceedingJoinPoint joinPoint, long time) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = signature.getMethod();
    // 创建一个日志实体类
    SysLog sysLog = new SysLog();
    // 请求的方法名
    String className = joinPoint.getTarget().getClass().getName();
    String methodName = signature.getName();
    sysLog.setMethod(className + "." + methodName + "()");
    // 请求的方法参数值
    Object[] args = joinPoint.getArgs();
    // 请求的方法参数名称
    LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
    String[] paramNames = u.getParameterNames(method);
    if (args != null && paramNames != null) {
      String params = "";
      for (int i = 0; i < args.length; i++) {
        params += paramNames[i] + ": " + args[i] + "  ";
      }
      sysLog.setParams(params);
    }
    // 获取request
    HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
    // 设置IP地址
    sysLog.setIp(IPUtils.getIpAddr(request));
    // 设置创建时间
    sysLog.setTime((int) time);
    Date date = new Date();
    sysLog.setCreateTime(date);
    // 打印日志
    log.info("【请求方法】" + sysLog.getMethod() + "【请求参数】" + sysLog.getParams());
    log.info("【响应时间】" + sysLog.getTime() + "ms " + "【创建时间】" + sysLog.getCreateTime() + "【IP地址】" + sysLog.getIp());
  }
}
