package com.wangwenjun.cicd.chapter06;

public class PrivateSimpleDao
{
    public int updateSimple(Simple simple)
    {
        assert simple != null && simple.getUsername() != null;
        return this.doUpdateSimple(simple);
    }

    private int doUpdateSimple(Simple simple)
    {
        throw new RuntimeException();
    }
}