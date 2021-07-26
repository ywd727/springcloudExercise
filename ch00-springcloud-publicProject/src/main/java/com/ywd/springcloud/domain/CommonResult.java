package com.ywd.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud.domain
 * @ClassName: CommonResult
 * @Author: 简鑫鑫
 * @Description: 用来将结果装换成特定的json串
 * @Date: 2021/6/13 15:43
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer num;
    private String message;
    private T data;

    public CommonResult(Integer number,String mes){
        this(number,mes,null);
    }
}
