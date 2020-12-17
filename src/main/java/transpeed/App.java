package transpeed;

//import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableDubboConfiguration
@EnableScheduling//表示启用计划任务
@Slf4j
public class App {
    public static void main(String[] args)
    {
        //以下修改qos配置，否则会因为端口冲突导致异常
        //配置dubbo.qos.port端口
        //System.setProperty( Constants.QOS_PORT,"33333");
        //配置dubbo.qos.accept.foreign.ip是否关闭远程连接
        //System.setProperty(Constants.ACCEPT_FOREIGN_IP,"false");

        //consumerConfig.setCheck(false);

        log.debug( "################################################# 程序启动 ########################################################" );
        //TranSpeed_ResetFilesHelper.setLogPath();//获取日志文件跟目录
        SpringApplication.run(App.class, args);
    }

}
