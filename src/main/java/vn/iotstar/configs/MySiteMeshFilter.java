package vn.iotstar.configs;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class MySiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/web.jsp")
                .addDecoratorPath("/admin/*", "/admin.jsp")
                .addDecoratorPath("/user/*", "/user.jsp")
                .addDecoratorPath("/manager/*", "/manager.jsp")
                .addExcludedPath("/login/*")
                .addExcludedPath("/register/*")
                .addExcludedPath("/v1/api/*");
    }
}