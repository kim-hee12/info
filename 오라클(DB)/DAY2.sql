-- ����ں� ���� �Ѿ� ���
select userid,sum(price * amount) as �����Ѿ� 
from buytbl
group by userid ;

-- ����ں� ���� Ƚ�� ���
select userid,count(*) as ����Ƚ��
from buytbl
group by userid;

-- ������ ����� �� ���
select addr, count(*) as ����ڼ�
from usertbl
group by addr;

-- ��ǰ �׷캰 �Ǹ� �ݾ� �հ�(!!!!)
select groupname, sum(price * amount) as �Ǹž�
from buytbl
where groupname is not null
group by groupname;

-- �����⵵ ���� ����� ��
select birthyear, count(*) as �ο���
from usertbl
group by birthyear
order by birthyear;

select name , mdate from usertbl order by mdate asc;
select name , mdate from usertbl order by name;
select name , mdate from usertbl order by mdate desc;

select name , height from usertbl order by height desc, name asc;

-- ��������
select * from 
(select rownum as rn, usertbl.* from usertbl) where rn=2;

-- �������� + rownum
select * from (select rownum as rn, usertbl.* from usertbl)
where rn>=2 and rn <=4;

-- ���� 2
-- 1userTbl���� ����(addr)�� ����� ���� ���ϴ� SQL���� �ۼ��Ͻÿ�.
select addr, count(*) as ����ڼ�
from usertbl
group by addr;

-- 2buyTbl���� �����(userID)�� �� ���ž��� ���ϴ� SQL���� �ۼ��Ͻÿ�. �� ���ž��� ����(price)�� ����(amount)�� ���� ������ ����Ͻÿ�.
select userid , sum(price * amount) as �����Ѿ�
from buytbl
group by userid;

-- 3buyTbl���� ��ǰ �׷�(groupName)�� �Ǹ� ������ �հ踦 ���ϴ� SQL���� �ۼ��Ͻÿ�. NULL ���� '�̺з�'�� ǥ���Ͻÿ�.
select groupname , sum(price * amount) as �Ǹż���
from buytbl
where groupname is not null
group by groupname;

-- 4userTbl���� ����⵵(birthYear)�� ��� Ű(height)�� ���ϴ� SQL���� �ۼ��Ͻÿ�.
select birthyear ,avg(height) as ���Ű
from usertbl
group by birthyear
order by birthyear;

-- 5buyTbl���� ��ǰ��(prodName)�� ���� Ƚ���� �� ���ž��� ���ϴ� SQL���� �ۼ��Ͻÿ�. ����� ���� Ƚ���� ���� ������ �����Ͻÿ�.
select prodname , count(*) as ����Ƚ��, sum(price * amount) as �����Ѿ�
from buytbl
group by prodname
order by ����Ƚ�� desc;

-- 6userTbl���� mobile1(��Ż�)�� ������ ���� ���ϵ�, NULL ���� '���Է�'���� ǥ���ϴ� SQL���� �ۼ��Ͻÿ�.
select coalesce('mobilel','���Է�') as ��Ż�, count(*) as �����ڼ� 
from usertbl
group by mobilel;

-- 7userTbl�� buyTbl�� �����Ͽ� ����(addr)�� �� ���ž��� ���ϴ� SQL���� �ۼ��Ͻÿ�.
select u.addr, sum(b.price * b.amount) as �ѱ��ž�
from userTbl u
join buyTbl b on u.userid = b.userid
group by u.addr;

-- 8buyTbl���� ����ں� ������ ��ǰ�� ���� ���� ���ϴ� SQL���� �ۼ��Ͻÿ�.
select userid,groupname, count(groupname) from buytbl group by userid,groupname;

-- 9userTbl���� ���� ������(mDate�� ���� �κ�) ������ ���� ���ϴ� SQL���� �ۼ��Ͻÿ�
select extract(year from mdate) as ���Կ���, count(*) as �����ڼ�
from usertbl
group by extract(year from mdate)
order by ���Կ���;

-- 10userTbl�� buyTbl�� �����Ͽ� ���ɴ뺰 ���� �Ѿ��� ����ϴ� SQL���� �ۼ��Ͻÿ�.
select (2025-usertbl.birthyear) as "����" , sum(buytbl.price * buytbl.amount)
from buytbl
join usertbl
on buytbl.userid=usertbl.userid
group by (2025-usertbl.birthyear);

select 2025,birthyear,2025-birthyear
from buytbl
join usertbl
on buytbl.userid = usertbl.userid
group by birthyear;

-- ���� �ݾ� �հ谡 1000 �̻��� ����� ��ȸ
select userid, sum(price * amount) as �ѱ��ž�
from buytbl
-- where sum(price * amount) >= 1000
group by userid
having sum (price * amount) >= 1000;

-- ��� Ű�� 175 �̻��� ���� ��ȸ
select addr, avg(height) as ���Ű
from usertbl
group by addr
having avg(height) >= 175;

select userid, count(*) as ����Ƚ��, sum(price * amount) as �ѱ��ž�
from buytbl
group by userid;

select u.addr, nvl(b.groupname,'�̺з�'), sum(b.amount * b.price)
from usertbl u
join buytbl b
on u.userid=b.userid
group by u.addr, b.groupname 
order by sum(b.amount*b.price) desc;

select groupname, prodname,sum(price * amount)
from buytbl
group by cube(groupname,prodname);

select * from buytbl;

select groupname, prodname,sum(price*amount) as �Ǹž�
from buytbl
where groupname is not null
group by cube(groupname,prodname);

-- ����3
-- 1buyTbl���� �� ���ž��� 1,000 �̻��� �����(userID)�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�.
select userid,sum(price*amount) as �ѱ��ž�
from buytbl
group by userid
having sum(price*amount)>=1000;

-- 2userTbl���� ������ ���� 2�� �̻��� ����(addr)�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�.
select addr,count(*) as �����ڼ�
from usertbl
group by addr
having count(*) >=2;

-- 3buyTbl���� ��� ���ž��� 100 �̻��� ��ǰ(prodName)�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�.
select prodname , avg(price*amount) as ��ձ��ž�
from buytbl
group by prodname
having avg(price*amount) >= 100;

-- 4userTbl���� ��� Ű�� 175cm �̻��� ����⵵�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�.
select birthyear,avg(height) as ���Ű
from usertbl
group by birthyear
having avg(height) >= 175
order by birthyear;

-- 5buyTbl���� �ּ� 2�� �̻��� ��ǰ�� ������ �����(userID)�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�.
select userid, sum(amount) as ����Ƚ��
from buytbl
group by userid
having  sum(amount) >= 2;

--6userTbl�� buyTbl�� �����Ͽ� ���� �Ѿ��� 200 �̻��� ����(addr)�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�.
select u.addr , sum(b.price * b.amount) as �����Ѿ�
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.addr
having sum(b.price * b.amount) >= 200;

-- 7buyTbl���� ���� Ƚ���� 3ȸ �̻��̰� �� ���ž��� 500 �̻��� �����(userID)�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�.
select userid, count(*) as ����Ƚ�� , sum(price * amount) �ѱ��ž�
from buytbl
group by userid
having count(*) >= 3 and sum(amount*price)>=500;

-- 8userTbl���� ��� Ű�� ���� ū ����(addr)�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�. (���������� HAVING ���)
select addr, avg(height) as ���Ű
from usertbl
group by addr;

select *
from
(select addr,avg(height) as ���Ű form usertbl group by addr)
where ���Ű=(select max(avg(height)) as ���Ű from usertbl group by addr);

-- 9buyTbl���� ���� �ݾ��� ��հ����� �� ���� �ݾ��� ����� �����(userID)�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�. 
-- (���������� HAVING ���)
select userid,avg(amount*price)
from buytbl
group by userid
having avg(price*amount)>=(select avg(amount*price)from buytbl);

-- 10userTbl�� buyTbl�� �����Ͽ� ���� ����(addr)�� ��� ����ڵ� �� ���� �Ѿ��� 
-- ������ ��� ���ž׺��� ���� �����(userID)�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�. 
-- (���������� HAVING ���)

--select addr, u.userid , sum(amount*price) as �Ѿ�
--from usertbl u
--join buytbl b
--on u.usertbl = b.userid
--group by addr,u.userid;
--
---- ������ ��� ���ž�
--select addr,avg(amount*price) as ��ձ��ž�
--from usetbl u
--join buytbl b
--on u.userid = b.userid
--group by addr;

--SELECT u.userID, u.name, u.addr, SUM(b.price * b.amount) AS �ѱ��ž�
--FROM userTbl u
--JOIN buyTbl b ON u.userID = b.userID
--GROUP BY u.userID, u.name, u.addr
--HAVING SUM(b.price * b.amount) > (
--    SELECT AVG(�������ž�)
--    FROM (
--        SELECT u2.addr, SUM(b2.price * b2.amount) AS �������ž�
--        FROM userTbl u2
--        JOIN buyTbl b2 ON u2.userID = b2.userID
--        WHERE u2.addr = u.addr
--        GROUP BY u2.userID
--    ) t
--);

-- ��ǰ�� ���� ���� ������ ȸ��(��������)
select rownum as rn,name,�Ѽ��� from(
SELECT u.name, SUM(b.amount) AS �Ѽ���
FROM userTbl u
JOIN buyTbl b ON u.userID = b.userID
GROUP BY u.name
ORDER BY �Ѽ��� DESC
)
where rownum=1;

-- Ư�� ��ǰ�� ������ ȸ�� ��ȸ
SELECT DISTINCT u.name
FROM userTbl u
JOIN buyTbl b ON u.userID = b.userID
WHERE b.prodName = 'å';

-- ��� ȸ���� �̸��� ���� ����(���� ��� NULL) ��ȸ
SELECT *
FROM userTbl u
LEFT JOIN buyTbl b 
ON u.userID = b.userID;

-- ���Ű� ���� ȸ�� ã�� (LEFT JOIN + WHERE NULL)
SELECT *
FROM userTbl u
LEFT JOIN buyTbl b 
ON u.userID = b.userID
WHERE b.userID IS NULL;

-- ���� ������ �ִ� ��� �����͸� �������� ȸ�� ���� ��ȸ
SELECT *
FROM userTbl u
RIGHT JOIN buyTbl b 
ON u.userID = b.userID;

-- �л� ���̺�
CREATE TABLE studentTbl (
  studentID CHAR(5) PRIMARY KEY,
  name VARCHAR2(20)
);

-- ���� ���� ���̺�
CREATE TABLE examTbl (
  examID CHAR(5) PRIMARY KEY,
  studentID CHAR(5),
  subject VARCHAR2(20),
  score NUMBER
);

-- �л� ������ ����
INSERT INTO studentTbl VALUES ('S001', 'ȫ�浿');
INSERT INTO studentTbl VALUES ('S002', '��ö��');
INSERT INTO studentTbl VALUES ('S003', '�̿���');
INSERT INTO studentTbl VALUES ('S004', '������');

-- ���� ���� ������ ����
INSERT INTO examTbl VALUES ('E101', 'S001', '����', 85);
INSERT INTO examTbl VALUES ('E102', 'S002', '����', 90);
INSERT INTO examTbl VALUES ('E103', 'S005', '����', 88); -- �������� �ʴ� �л�

COMMIT;

select * from studenttbl;

select * from examtbl;

-- �� ��� �л��� ��� ���� ���� ��� (���� ������ NULL)
SELECT *
FROM studentTbl s
FULL OUTER JOIN examTbl e 
ON s.studentID = e.studentID;
