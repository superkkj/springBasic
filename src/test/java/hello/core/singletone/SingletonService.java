package hello.core.singletone;

public class SingletonService {

    private static  final SingletonService instance = new SingletonService(); // 자기자신을 내부 프라이빗으로 하나만.. instance에 하나만 들어감 참


    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public static void main(String[] args){

    }

    public void logic(){
        System.out.println(" 싱글톤 객체 로직 호출");
    }


}
