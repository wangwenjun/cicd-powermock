package com.wangwenjun.cicd.chapter06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
public class SimpleServiceFinalTest
{

    @PrepareForTest({
            SimpleService.class,
            FinalSimpleDao.class
    })
    @Test
    public void testDeleteSimple() throws Exception
    {
        FinalSimpleDao finalSimpleDao = mock(FinalSimpleDao.class);

        whenNew(FinalSimpleDao.class)
                .withNoArguments().thenReturn(finalSimpleDao);
        when(finalSimpleDao.delete(any(Simple.class))).thenReturn(1);

        SimpleService simpleService = new SimpleService();
        int effected = simpleService.deleteSimple(new Simple("Alex", 36));

        assertThat(effected, equalTo(1));
        verify(finalSimpleDao, times(1)).delete(isA(Simple.class));
    }
}
