package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 참고
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomiLong 사용 고려
 */

public class MemberRepository {


    //Key는 아이디 value는 Member
    private Map<Long, Member> store = new HashMap<>();

    //id가 하나씩 증가하는 sequence 사용
    private static long sequence = 0L;

    //싱글톤 제작.
    //싱글톤을 만들때는 private으로 아무나 생성 못하게 생성자를 막아야함.
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }
    private MemberRepository () {

    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        //store에 있는 value리스트를 건드리고 싶지 않아서 아래처럼 작성.
        //store자체를 보호하기 위해서.
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }



}
