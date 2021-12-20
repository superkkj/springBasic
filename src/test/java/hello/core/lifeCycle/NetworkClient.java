package hello.core.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 , url = " + url);
        connect();
        call("초기화 연결 메시지");

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출

    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String mesasage) {
        System.out.println("call:" + url + " mesasage = " + mesasage);
    }

    //서비스 종료시 호출
    public void disConnect() {
        System.out.println("close" + url);
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.init");

        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disConnect();
    }
}
