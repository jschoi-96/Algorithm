-- 코드를 입력하세요
SELECT u.user_id, u.nickname, concat(city, ' ' ,STREET_ADDRESS1, ' ' , STREET_ADDRESS2) as 전체주소,
    concat(substr(TLNO, 1, 3), '-', substr(TLNO, 4, 4), '-', substr(TLNO, 8,8)) as 전화번호
from USED_GOODS_BOARD b
join USED_GOODS_USER u
on b.writer_id = u.user_id
group by writer_id
having count(*) >= 3
order by u.user_id desc