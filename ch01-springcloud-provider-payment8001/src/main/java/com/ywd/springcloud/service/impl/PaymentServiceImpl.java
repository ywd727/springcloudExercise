package com.ywd.springcloud.service.impl;

import com.ywd.springcloud.dao.PaymentDao;
import com.ywd.springcloud.domain.Payment;
import com.ywd.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud.service.impl
 * @ClassName: PaymentServiceImpl
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/6/13 16:25
 * @Version: 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    @Override
    public Integer create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment queryPaymentById(Long id) {
        return paymentDao.queryPaymentById(id);
    }
}
