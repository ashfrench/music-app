package com.ash.music.app.user.library.config

import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import liquibase.integration.spring.SpringLiquibase
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import javax.sql.DataSource


@Configuration
@EnableR2dbcRepositories
internal class R2DBCConfiguration : AbstractR2dbcConfiguration() {
    @Bean
    override fun connectionFactory(): H2ConnectionFactory {
        return H2ConnectionFactory(
            H2ConnectionConfiguration.builder()
                .url("mem:test;DB_CLOSE_DELAY=-1;")
                .username("sa")
                .build()
        )
    }
//
//    @Bean
//    fun getDataSource(): DataSource {
//        val dataSourceBuilder = DataSourceBuilder.create()
//        dataSourceBuilder.username("sa")
////        dataSourceBuilder.password("")
//        dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url("jdbc:h2:mem:testdb");
//        return dataSourceBuilder.build()
//    }

//    @Bean
//    fun liquibase(): SpringLiquibase {
//        val liquibase = SpringLiquibase()
//        liquibase.changeLog = "classpath:config/liquibase/master.xml"
//        liquibase.dataSource = DataSourceBuilder.create()
//            .username("sa")
//            .driverClassName("org.h2.Driver")
//            .url("jdbc:h2:mem:testdb")
//            .build()
//        return liquibase
//    }
}