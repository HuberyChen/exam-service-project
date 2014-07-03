package com.exam.web.interceptor;


import com.core.platform.web.site.layout.ModelBuilder;
import com.exam.web.SiteContext;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author hubery.chen
 */
public class MasterTemplateModelBuilder implements ModelBuilder {
    private SiteContext siteContext;

    @Override
    public void build(Map<String, Object> model) {
        model.putAll(siteContext.getModel());
    }

    @Inject
    public void setSiteContext(SiteContext siteContext) {
        this.siteContext = siteContext;
    }

}
