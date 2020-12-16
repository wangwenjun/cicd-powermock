package com.wangwenjun.cicd.chapter06;

public class SimpleService
{
    public int count()
    {
        SimpleDao simpleDao = new SimpleDao();
        return simpleDao.getCount();
    }

    public Simple getSimpleByName(String name)
    {
        return SimpleDaoUtils.findSimple(name);
    }

    public void saveSimple(Simple simple)
    {
        SimpleDaoUtils.saveSimple(simple);
    }

    public int deleteSimple(Simple simple)
    {
        FinalSimpleDao finalSimpleDao = new FinalSimpleDao();
        return finalSimpleDao.delete(simple);
    }
}
