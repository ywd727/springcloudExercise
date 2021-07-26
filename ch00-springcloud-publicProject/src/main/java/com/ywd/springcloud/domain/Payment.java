package com.ywd.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud.domain
 * @ClassName: Payment
 * @Author: 简鑫鑫
 * @Description: 交易的实体类
 * @Date: 2021/6/13 15:40
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private long id;
    private String serial;
}
