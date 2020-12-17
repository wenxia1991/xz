package transpeed.com.transpeed.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.transpeed.dubboapi.RpcApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;


import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Slf4j
public class ClientController {

    @Reference//(check =  false)
    private RpcApi rpc;


    int addlvalue=1;
    int addrvalue=1000;
    int minuslvalue=5000;
    int minusrvalue=3;

    @Scheduled( fixedDelay=15*1000)
    private void Run()
    {

        log.debug( "addlvalue="+addlvalue+"  addrvalue="+addrvalue+"  和："+rpc.Add( addlvalue,addrvalue ) );
        //logger.debug( "addlvalue="+addlvalue+"  addrvalue="+addrvalue);
        //rpc.Add( addlvalue,addrvalue );
        addlvalue++;
        addrvalue+=2;

        log.debug( "minuslvalue="+minuslvalue+"  minusrvalue="+minusrvalue+"  差："+rpc.Minus( minuslvalue,minusrvalue ) );
        minusrvalue-=3;


        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String content="当前时间【"+ f.format(date)+"】";
        rpc.WriteLog( content );
        log.debug( "这里要求RPC写一条日志："  + content);
    }

}
