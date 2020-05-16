package com.baomidou.mybatisplus.samples.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.samples.generator.conf.MyTemplateConf;

/**
 * <p>
 * mysql 代码生成器演示例子
 * </p>
 *
 * @author jobob
 * @since 2018-09-12
 */
public class MysqlGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        mpg.setGlobalConfig(gc);

        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/mybatis-plus-sample-generator/src/main/java");
        gc.setAuthor("lith");
        gc.setOpen(false);
        gc.setFileOverride(true);

        //设置后缀名，允许占位符
        gc.setMapperName("%sDAO");
//        gc.setEntityName("%sPO");
        gc.setServiceName("%sManager");
        gc.setServiceImplName("%sManagerImpl");

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/hrs_survey?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
//        dsc.setUsername("root");
//        dsc.setPassword("1119107284");
        dsc.setUrl("jdbc:mysql://192.168.1.230:3307/family_doctor?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dsc.setUsername("family_doctor");
        dsc.setPassword("family_doctorPWD");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.baomidou.mybatisplus.samples.generator");
        mpg.setPackageInfo(pc);

        //设置包名
        pc.setMapper("dao");
        pc.setEntity("po");
        pc.setService("manager");
        pc.setServiceImpl("manager.impl");

        MyTemplateConf boConf = MyTemplateConf.builder()
            .templatePath("/mytemplates/entityBO.java.ftl")
            .path("/mybatis-plus-sample-generator/src/main/java")
            .packagePath("com.baomidou.mybatisplus.samples.generator.test.bo")
            .fileNameSuffix("BO")
            .fileSuffix(StringPool.DOT_JAVA)
            .build();

        MyTemplateConf poConf = MyTemplateConf.builder()
            .templatePath("/mytemplates/entityPO.java.ftl")
            .path("/mybatis-plus-sample-generator/src/main/java")
            .packagePath("com.baomidou.mybatisplus.samples.generator.test.po")
            .fileNameSuffix("PO")
            .fileSuffix(StringPool.DOT_JAVA)
            .build();

        MyTemplateConf daoConf = MyTemplateConf.builder()
            .templatePath("/mytemplates/mapper.java.ftl")
            .path("/mybatis-plus-sample-generator/src/main/java")
            .packagePath("com.baomidou.mybatisplus.samples.generator.test.dao")
            .fileNameSuffix("DAO")
            .fileSuffix(StringPool.DOT_JAVA)
            .build();

        MyTemplateConf mapperConf = MyTemplateConf.builder()
            .templatePath("/mytemplates/mapper.xml.ftl")
            .path("/mybatis-plus-sample-generator/src/main/java")
            .packagePath("com.baomidou.mybatisplus.samples.generator.test.xml")
            .fileNameSuffix("")
            .fileSuffix(StringPool.DOT_XML)
            .build();

        MyTemplateConf managerConf = MyTemplateConf.builder()
            .templatePath("/mytemplates/manager.java.ftl")
            .path("/mybatis-plus-sample-generator/src/main/java")
            .packagePath("com.baomidou.mybatisplus.samples.generator.test.manager")
            .fileNameSuffix("Manager")
            .fileSuffix(StringPool.DOT_JAVA)
            .build();

        MyTemplateConf managerImplConf = MyTemplateConf.builder()
            .templatePath("/mytemplates/managerImpl.java.ftl")
            .path("/mybatis-plus-sample-generator/src/main/java")
            .packagePath("com.baomidou.mybatisplus.samples.generator.test.manager.impl")
            .fileNameSuffix("ManagerImpl")
            .fileSuffix(StringPool.DOT_JAVA)
            .build();

        List<MyTemplateConf> confList = new ArrayList<>();
        confList.add(boConf);
        confList.add(poConf);
        confList.add(daoConf);
        confList.add(mapperConf);
        confList.add(managerConf);
        confList.add(managerImplConf);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
                HashMap<String, Object> injectMap = new HashMap<>();
                injectMap.put("boConf", boConf);
                injectMap.put("poConf", poConf);
                injectMap.put("daoConf", daoConf);
                injectMap.put("mapperConf", mapperConf);
                injectMap.put("managerConf", managerConf);
                injectMap.put("managerImplConf", managerImplConf);
                this.setMap(injectMap);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        //自定义dao对象
//        focList.add(new FileOutConfig("/mytemplates/mapper.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                tableInfo.setMapperName(tableInfo.getEntityName() + "DAO");
//                // 自定义输入文件名称
//                String daoPath = joinPath(projectPath + "/mybatis-plus-sample-generator/src/main/java/",
//                    joinPackage(pc.getParent(), pc.getMapper()));
//                return daoPath +"/"+ tableInfo.getEntityName() + "DAO" + StringPool.DOT_JAVA;
//            }
//        });
        //自定义mapper文件
//        focList.add(new FileOutConfig("/mytemplates/mapper.xml.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return projectPath + "/mybatis-plus-sample-generator/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });

        //自定义bo对象

        for (MyTemplateConf myTemplateConf : confList) {
            focList.add(new FileOutConfig(myTemplateConf.getTemplatePath()) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输入文件名称
                    StringBuilder fileSb = new StringBuilder(projectPath)
                        .append(joinPath(myTemplateConf.getPath(), myTemplateConf.getPackagePath()))
                        .append(File.separator)
                        .append(tableInfo.getEntityName()).append(myTemplateConf.getFileNameSuffix())
                        .append(myTemplateConf.getFileSuffix());

                    return fileSb.toString();
                }
            });
        }



        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
//        mpg.setTemplate(new TemplateConfig().setXml(null));


        TemplateConfig tc = new TemplateConfig();
//        tc.setMapper("/mytemplates/mapper.java");
//        tc.setXml("/mytemplates/mapper.xml");
//        tc.setEntity("/mytemplates/entity.java");
//        tc.setService("/mytemplates/service.java");
//        tc.setServiceImpl("/mytemplates/serviceImpl.java");
        tc.setMapper(null);
        tc.setXml(null);
        tc.setEntity(null);
        tc.setService(null);
        tc.setServiceImpl(null);
        mpg.setTemplate(tc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.baomidou.mybatisplus.samples.generator.common.BaseEntity");
        strategy.setEntityLombokModel(true);
//        strategy.setSuperControllerClass("com.baomidou.mybatisplus.samples.generator.common.BaseController");
//        strategy.setInclude(scanner("表名"));
        strategy.setInclude("sys_conf_org");
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * 连接路径字符串
     *
     * @param parentDir   路径常量字符串
     * @param packageName 包名
     * @return 连接后的路径
     */
    private static String joinPath(String parentDir, String packageName) {
        if (StringUtils.isBlank(parentDir)) {
            parentDir = System.getProperty(ConstVal.JAVA_TMPDIR);
        }
        if (!StringUtils.endsWith(parentDir, File.separator)) {
            parentDir += File.separator;
        }
        packageName = packageName.replaceAll("\\.", StringPool.BACK_SLASH + File.separator);
        return parentDir + packageName;
    }

    /**
     * 连接父子包名
     *
     * @param parent     父包名
     * @param subPackage 子包名
     * @return 连接后的包名
     */
    private static String joinPackage(String parent, String subPackage) {
        if (StringUtils.isBlank(parent)) {
            return subPackage;
        }
        return parent + StringPool.DOT + subPackage;
    }

}
