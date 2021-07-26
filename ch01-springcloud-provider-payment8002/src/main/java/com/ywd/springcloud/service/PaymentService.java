package com.ywd.springcloud.service;

import com.ywd.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud.service
 * @ClassName: PaymentService
 * @Author: 简鑫鑫
 * @Description: 交易的接口
 * @Date: 2021/6/13 16:24
 * @Version: 1.0
 */
public interface PaymentService {
    public Integer create(Payment payment);

    public Payment queryPaymentById(@Param("id") Long id);
}
