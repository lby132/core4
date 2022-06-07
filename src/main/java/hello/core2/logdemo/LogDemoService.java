package hello.core2.logdemo;

import hello.core2.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

     private final MyLogger myLogger; // @Scope 에서 proxy 사용시
 //   private final ObjectProvider<MyLogger> myLoggerProvider; ObjectProvider 사용시

    public void logic(String id) {
  //      final MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
