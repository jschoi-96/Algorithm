-- 코드를 작성해주세요
select 
    id, IFNULL(LENGTH, 10) as LENGTH
from
    FISH_INFO
order by
    LENGTH desc, id 
limit 10