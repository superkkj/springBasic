package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

        private String name;
        private int age;



    public static void main(String[] args){
        hello.core.HelloLombok helloLombok = new hello.core.HelloLombok();

        String name = helloLombok.getName();
        helloLombok.setName("test");

        System.out.println("name = " + name);
        System.out.println("name = " + helloLombok.toString());
    }
}
