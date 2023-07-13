package hello.servlet.domain.member;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Member {

    private Long id;
    private String username;
    private int age;

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public Member(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Member() {

    }


}
