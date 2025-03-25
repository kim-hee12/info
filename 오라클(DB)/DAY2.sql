-- 사용자별 구매 총액 계산
select userid,sum(price * amount) as 구매총액 
from buytbl
group by userid ;

-- 사용자별 구매 횟수 계산
select userid,count(*) as 구매횟수
from buytbl
group by userid;

-- 지역별 사용자 수 계산
select addr, count(*) as 사용자수
from usertbl
group by addr;

-- 제품 그룹별 판매 금액 합계(!!!!)
select groupname, sum(price * amount) as 판매액
from buytbl
where groupname is not null
group by groupname;

-- 츨생년도 기준 사용자 수
select birthyear, count(*) as 인원수
from usertbl
group by birthyear
order by birthyear;

select name , mdate from usertbl order by mdate asc;
select name , mdate from usertbl order by name;
select name , mdate from usertbl order by mdate desc;

select name , height from usertbl order by height desc, name asc;

-- 서브쿼리
select * from 
(select rownum as rn, usertbl.* from usertbl) where rn=2;

-- 서브쿼리 + rownum
select * from (select rownum as rn, usertbl.* from usertbl)
where rn>=2 and rn <=4;

-- 문제 2
-- 1userTbl에서 지역(addr)별 사용자 수를 구하는 SQL문을 작성하시오.
select addr, count(*) as 사용자수
from usertbl
group by addr;

-- 2buyTbl에서 사용자(userID)별 총 구매액을 구하는 SQL문을 작성하시오. 총 구매액은 가격(price)과 수량(amount)의 곱의 합으로 계산하시오.
select userid , sum(price * amount) as 구매총액
from buytbl
group by userid;

-- 3buyTbl에서 제품 그룹(groupName)별 판매 수량의 합계를 구하는 SQL문을 작성하시오. NULL 값은 '미분류'로 표시하시오.
select groupname , sum(price * amount) as 판매수량
from buytbl
where groupname is not null
group by groupname;

-- 4userTbl에서 출생년도(birthYear)별 평균 키(height)를 구하는 SQL문을 작성하시오.
select birthyear ,avg(height) as 평균키
from usertbl
group by birthyear
order by birthyear;

-- 5buyTbl에서 제품명(prodName)별 구매 횟수와 총 구매액을 구하는 SQL문을 작성하시오. 결과는 구매 횟수가 많은 순으로 정렬하시오.
select prodname , count(*) as 구매횟수, sum(price * amount) as 구매총액
from buytbl
group by prodname
order by 구매횟수 desc;

-- 6userTbl에서 mobile1(통신사)별 가입자 수를 구하되, NULL 값은 '미입력'으로 표시하는 SQL문을 작성하시오.
select coalesce('mobilel','미입력') as 통신사, count(*) as 가입자수 
from usertbl
group by mobilel;

-- 7userTbl과 buyTbl을 조인하여 지역(addr)별 총 구매액을 구하는 SQL문을 작성하시오.
select u.addr, sum(b.price * b.amount) as 총구매액
from userTbl u
join buyTbl b on u.userid = b.userid
group by u.addr;

-- 8buyTbl에서 사용자별 구매한 제품의 종류 수를 구하는 SQL문을 작성하시오.
select userid,groupname, count(groupname) from buytbl group by userid,groupname;

-- 9userTbl에서 가입 연도별(mDate의 연도 부분) 가입자 수를 구하는 SQL문을 작성하시오
select extract(year from mdate) as 가입연도, count(*) as 가입자수
from usertbl
group by extract(year from mdate)
order by 가입연도;

-- 10userTbl과 buyTbl을 조인하여 연령대별 구매 총액을 계산하는 SQL문을 작성하시오.
select (2025-usertbl.birthyear) as "연령" , sum(buytbl.price * buytbl.amount)
from buytbl
join usertbl
on buytbl.userid=usertbl.userid
group by (2025-usertbl.birthyear);

select 2025,birthyear,2025-birthyear
from buytbl
join usertbl
on buytbl.userid = usertbl.userid
group by birthyear;

-- 구매 금액 합계가 1000 이상인 사용자 조회
select userid, sum(price * amount) as 총구매액
from buytbl
-- where sum(price * amount) >= 1000
group by userid
having sum (price * amount) >= 1000;

-- 평균 키가 175 이상인 지역 조회
select addr, avg(height) as 평균키
from usertbl
group by addr
having avg(height) >= 175;

select userid, count(*) as 구매횟수, sum(price * amount) as 총구매액
from buytbl
group by userid;

select u.addr, nvl(b.groupname,'미분류'), sum(b.amount * b.price)
from usertbl u
join buytbl b
on u.userid=b.userid
group by u.addr, b.groupname 
order by sum(b.amount*b.price) desc;

select groupname, prodname,sum(price * amount)
from buytbl
group by cube(groupname,prodname);

select * from buytbl;

select groupname, prodname,sum(price*amount) as 판매액
from buytbl
where groupname is not null
group by cube(groupname,prodname);

-- 문제3
-- 1buyTbl에서 총 구매액이 1,000 이상인 사용자(userID)만 조회하는 SQL문을 작성하시오.
select userid,sum(price*amount) as 총구매액
from buytbl
group by userid
having sum(price*amount)>=1000;

-- 2userTbl에서 가입자 수가 2명 이상인 지역(addr)만 조회하는 SQL문을 작성하시오.
select addr,count(*) as 가입자수
from usertbl
group by addr
having count(*) >=2;

-- 3buyTbl에서 평균 구매액이 100 이상인 제품(prodName)만 조회하는 SQL문을 작성하시오.
select prodname , avg(price*amount) as 평균구매액
from buytbl
group by prodname
having avg(price*amount) >= 100;

-- 4userTbl에서 평균 키가 175cm 이상인 출생년도를 조회하는 SQL문을 작성하시오.
select birthyear,avg(height) as 평균키
from usertbl
group by birthyear
having avg(height) >= 175
order by birthyear;

-- 5buyTbl에서 최소 2개 이상의 제품을 구매한 사용자(userID)를 조회하는 SQL문을 작성하시오.
select userid, sum(amount) as 구매횟수
from buytbl
group by userid
having  sum(amount) >= 2;

--6userTbl과 buyTbl을 조인하여 구매 총액이 200 이상인 지역(addr)만 조회하는 SQL문을 작성하시오.
select u.addr , sum(b.price * b.amount) as 구매총액
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.addr
having sum(b.price * b.amount) >= 200;

-- 7buyTbl에서 구매 횟수가 3회 이상이고 총 구매액이 500 이상인 사용자(userID)를 조회하는 SQL문을 작성하시오.
select userid, count(*) as 구매횟수 , sum(price * amount) 총구매액
from buytbl
group by userid
having count(*) >= 3 and sum(amount*price)>=500;

-- 8userTbl에서 평균 키가 가장 큰 지역(addr)을 조회하는 SQL문을 작성하시오. (서브쿼리와 HAVING 사용)
select addr, avg(height) as 평균키
from usertbl
group by addr;

select *
from
(select addr,avg(height) as 평균키 form usertbl group by addr)
where 평균키=(select max(avg(height)) as 평균키 from usertbl group by addr);

-- 9buyTbl에서 구매 금액의 평균값보다 더 많은 금액을 사용한 사용자(userID)를 조회하는 SQL문을 작성하시오. 
-- (서브쿼리와 HAVING 사용)
select userid,avg(amount*price)
from buytbl
group by userid
having avg(price*amount)>=(select avg(amount*price)from buytbl);

-- 10userTbl과 buyTbl을 조인하여 같은 지역(addr)에 사는 사용자들 중 구매 총액이 
-- 지역별 평균 구매액보다 높은 사용자(userID)를 조회하는 SQL문을 작성하시오. 
-- (서브쿼리와 HAVING 사용)

--select addr, u.userid , sum(amount*price) as 총액
--from usertbl u
--join buytbl b
--on u.usertbl = b.userid
--group by addr,u.userid;
--
---- 지역별 평균 구매액
--select addr,avg(amount*price) as 평균구매액
--from usetbl u
--join buytbl b
--on u.userid = b.userid
--group by addr;

--SELECT u.userID, u.name, u.addr, SUM(b.price * b.amount) AS 총구매액
--FROM userTbl u
--JOIN buyTbl b ON u.userID = b.userID
--GROUP BY u.userID, u.name, u.addr
--HAVING SUM(b.price * b.amount) > (
--    SELECT AVG(지역구매액)
--    FROM (
--        SELECT u2.addr, SUM(b2.price * b2.amount) AS 지역구매액
--        FROM userTbl u2
--        JOIN buyTbl b2 ON u2.userID = b2.userID
--        WHERE u2.addr = u.addr
--        GROUP BY u2.userID
--    ) t
--);

-- 상품을 가장 많이 구매한 회원(수량기준)
select rownum as rn,name,총수량 from(
SELECT u.name, SUM(b.amount) AS 총수량
FROM userTbl u
JOIN buyTbl b ON u.userID = b.userID
GROUP BY u.name
ORDER BY 총수량 DESC
)
where rownum=1;

-- 특정 물품을 구매한 회원 조회
SELECT DISTINCT u.name
FROM userTbl u
JOIN buyTbl b ON u.userID = b.userID
WHERE b.prodName = '책';

-- 모든 회원의 이름과 구매 내역(없는 경우 NULL) 조회
SELECT *
FROM userTbl u
LEFT JOIN buyTbl b 
ON u.userID = b.userID;

-- 구매가 없는 회원 찾기 (LEFT JOIN + WHERE NULL)
SELECT *
FROM userTbl u
LEFT JOIN buyTbl b 
ON u.userID = b.userID
WHERE b.userID IS NULL;

-- 구매 내역이 있는 모든 데이터를 기준으로 회원 정보 조회
SELECT *
FROM userTbl u
RIGHT JOIN buyTbl b 
ON u.userID = b.userID;

-- 학생 테이블
CREATE TABLE studentTbl (
  studentID CHAR(5) PRIMARY KEY,
  name VARCHAR2(20)
);

-- 시험 응시 테이블
CREATE TABLE examTbl (
  examID CHAR(5) PRIMARY KEY,
  studentID CHAR(5),
  subject VARCHAR2(20),
  score NUMBER
);

-- 학생 데이터 삽입
INSERT INTO studentTbl VALUES ('S001', '홍길동');
INSERT INTO studentTbl VALUES ('S002', '김철수');
INSERT INTO studentTbl VALUES ('S003', '이영희');
INSERT INTO studentTbl VALUES ('S004', '박지민');

-- 시험 응시 데이터 삽입
INSERT INTO examTbl VALUES ('E101', 'S001', '수학', 85);
INSERT INTO examTbl VALUES ('E102', 'S002', '영어', 90);
INSERT INTO examTbl VALUES ('E103', 'S005', '국어', 88); -- 존재하지 않는 학생

COMMIT;

select * from studenttbl;

select * from examtbl;

-- ① 모든 학생과 모든 시험 정보 출력 (누락 정보는 NULL)
SELECT *
FROM studentTbl s
FULL OUTER JOIN examTbl e 
ON s.studentID = e.studentID;
