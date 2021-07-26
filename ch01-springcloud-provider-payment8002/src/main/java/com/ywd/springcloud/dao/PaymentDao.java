package com.ywd.springcloud.dao;

import com.ywd.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud.dao
 * @ClassName: PaymentDao
 * @Author: 简鑫鑫
 * @Description: 交易的接口
 * @Date: 2021/6/13 16:08
 * @Version: 1.0
 */
@Mapper
public interface PaymentDao {
    public Integer create(Payment payment);

    public Payment queryPaymentById(@Param("id")Long id);
}
