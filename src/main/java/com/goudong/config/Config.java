package com.goudong.config;

import com.goudong.controller.ApiController;
import com.goudong.controller.HelloController;
import com.goudong.controller.UserController;
import com.goudong.filter.CrossInterceptor;
import com.goudong.model._MappingKit;
import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

import java.io.File;

/**
 * Created by CTL on 2019/3/27.
 */
public class Config extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        PropKit.use("jdbc_config.txt");
        constants.setDevMode(PropKit.getBoolean("devMode", false));
        constants.setViewType(ViewType.FREE_MARKER);
        constants.setBaseUploadPath(File.separator + "pics");
        constants.setBaseDownloadPath(File.separator + "pics");
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/hello", HelloController.class);
        routes.add("/", UserController.class);
        routes.add("/api", ApiController.class);
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        DruidPlugin dp = createDBPlugin();
        plugins.add(dp);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        plugins.add(arp);

        boolean devMode = PropKit.getBoolean("devMode", true);
        if(devMode)
            arp.setShowSql(true);
        plugins.add(arp);
        _MappingKit.mapping(arp);
        dp.start();
        arp.start();
    }

    public static DruidPlugin createDBPlugin() {
        return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim(),PropKit.get("driverClassName"));
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        interceptors.add(new CrossInterceptor());
    }

    @Override
    public void configHandler(Handlers handlers) {
        handlers.add(new ContextPathHandler("contextPath"));
    }

    public static void main(String[] args) {
        UndertowServer.start(Config.class);
    }
}
