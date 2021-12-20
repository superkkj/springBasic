package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration //설정 정보
@ComponentScan // 어노테이션붙은 빈을 찾아줌 ?
        (
                basePackages = "hello.core", //여기서부터부터 찾는 이걸 지정안해주면 모든 자바코드 다 찾기때문에 시간이 오래걸려

                excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION , classes = Configuration.class)
        )
public class AutoAppConfig { //베이스페키지 안하면 여기가 시작점 .

//
//        @Bean(name = "memoryMemberRepository")
//        public MemberRepository memberRepository(){
//              return  new MemoryMemberRepository();
//        }


}
