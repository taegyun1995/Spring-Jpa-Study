# Spring-Jpa-Study

@Transactional(readOnly = true)  
데이터를 단순히 조회만 하고 변경하지 않는 트랜잭션에서
``readOnly = true`` 옵션을 사용하면 플러시를 생략해서 약간의 성능 향상을 얻음