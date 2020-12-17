package com.wangwenjun.cicd.chapter06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
public class SimpleServicePrivateBySpyingTest
{
    @PrepareForTest({SimpleService.class, PrivateSimpleDao.class})
    @Test
    public void testUpdateSimple() throws Exception
    {
        Simple simple = new Simple("Alex", 36);
        PrivateSimpleDao simpleDao = spy(new PrivateSimpleDao());
        whenNew(PrivateSimpleDao.class).withNoArguments()
                .thenReturn(simpleDao);
        //doCallRealMethod().when(simpleDao).updateSimple(simple);

        doReturn(1).when(simpleDao, "doUpdateSimple", simple);

        int result = new SimpleService().updateSimple(simple);

        assertThat(result, equalTo(1));
        verifyPrivate(simpleDao, times(1)).invoke("doUpdateSimple", simple);
    }
}
