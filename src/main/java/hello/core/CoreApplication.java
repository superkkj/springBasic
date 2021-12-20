package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링부트를 돌리는 곳  컴포넌트 스캔 붙어잇음 스프링부트를 쓰면 다 스캔하는 이유가 여기서부터 시작하기 때문이다 .
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
