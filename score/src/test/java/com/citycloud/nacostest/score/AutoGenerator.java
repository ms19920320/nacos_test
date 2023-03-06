package com.citycloud.nacostest.score;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 代码自动生成
 *
 * @Author ms
 * @Date 2022/6/29 16:21
 */
public class AutoGenerator {

    private static final String url = "jdbc:mysql://120.48.48.87:3306/test?useSSL=false&useUnicode=true" +
            "&characterEncoding=utf-8&serverTimezone=GMT%2B8";
    private static final String username = "root";
    private static final String password = "123456";

    public static void main(String[] args) {
        String moduleName = "score";
        String packageName = "com.citycloud.nacostest";
        List<String> tables = new ArrayList<>();
        tables.add("test_score");
        generatorCode(moduleName, packageName, tables);
    }

    private static void generatorCode(String moduleName, String packageName, List<String> tables) {

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("ms")               //作者
                            .outputDir(System.getProperty("user.dir") + "\\" + moduleName + "\\src\\main\\java")
                            //输出路径
                            // (写到java目录)
                            .enableSwagger()           // 开启swagger
                            .commentDate("yyyy-MM-dd")
                            .fileOverride();            //开启覆盖之前生成的文件

                })
                .packageConfig(builder -> {
                    builder.parent(packageName)
                            .moduleName(moduleName)
                            .entity("entity")
                            .service("service")
                            .serviceImpl("serviceImpl")
                            .controller("controller")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    System.getProperty("user.dir") + "\\" + moduleName + "\\src\\main\\resources" +
                                            "\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            .addTablePrefix("p_")
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()
                            .enableLombok()
                            .logicDeleteColumnName("deleted")
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder()
                            .enableBaseResultMap()  //生成通用的resultMap
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()
                            .formatXmlFileName("%sMapper");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
