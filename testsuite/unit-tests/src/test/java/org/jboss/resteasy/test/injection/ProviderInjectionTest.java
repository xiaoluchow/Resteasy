package org.jboss.resteasy.test.injection;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.jboss.resteasy.test.injection.resource.ProviderInjectionProviderReader;
import org.junit.Assert;
import org.junit.Test;

/**
 * @tpSubChapter Injection tests
 * @tpChapter Unit tests
 * @tpTestCaseDetails Test for correct injection in registered custom provider.
 * @tpSince EAP 7.0.0
 */
public class ProviderInjectionTest {
    private static final String ERROR_MSG = String.format("%s provider was not successfully registered.",
            ProviderInjectionProviderReader.class.getSimpleName());

    /**
     * @tpTestDetails Test for injected HttpHeaders and Providers
     * @tpSince EAP 7.0.0
     */
    @Test
    public void testCacheControl() {
        ProviderInjectionProviderReader reader = new ProviderInjectionProviderReader();
        ResteasyProviderFactory.getInstance().registerProviderInstance(reader);

        Assert.assertNotNull(ERROR_MSG, reader.headers);
        Assert.assertNotNull(ERROR_MSG, reader.workers);
    }

}