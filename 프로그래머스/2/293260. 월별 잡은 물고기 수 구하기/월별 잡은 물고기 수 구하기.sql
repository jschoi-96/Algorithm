-- 코드를 작성해주세요
select count(*) as FISH_COUNT, month(time) as month
from fish_info
group by month
order by month 