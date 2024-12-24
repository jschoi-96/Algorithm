-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, sum(b.price) as TOTAL_SALES
from USED_GOODS_BOARD b
join USED_GOODS_USER u
on b.writer_id = u.user_id
where b.status = 'DONE'
group by u.user_id
having TOTAL_SALES >= 700000
order by TOTAL_SALES