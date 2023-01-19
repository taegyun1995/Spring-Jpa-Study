package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    List<Member> findHelloBy(); //By뒤에 아무것도 없으면 전체조회. 있으면 Where로 들어감

    List<Member> findTop3HelloBy(); //Top숫자가 붙으면 limit조건으로 검색된다.

    // @Query(name = "Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username); //NamedQuery(거의안씀)

    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    //특정 데이터를 조회
    @Query("select m.username from Member m")
    List<String> findUsernameList();

    //DTO를 조회
    @Query("select new study.datajpa.dto.MemberDto(m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();
}