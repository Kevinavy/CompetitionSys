package com.kevinavy.competitionsys;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class CompetitionSysApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void decode() {
//        学院密码 123456
        System.out.println(new BCryptPasswordEncoder().upgradeEncoding("$2a$10$zfgxelVIp/hK5yr4pxxsOeTlFCMIuJzDQdk.O/AUlqFuuYGkvsJfm"));
    }

}
