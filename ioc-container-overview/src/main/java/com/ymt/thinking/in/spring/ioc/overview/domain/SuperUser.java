package com.ymt.thinking.in.spring.ioc.overview.domain;

import com.ymt.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * @author yumingtao
 * @date 2021/9/25 20:06
 */
@Super
public class SuperUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
