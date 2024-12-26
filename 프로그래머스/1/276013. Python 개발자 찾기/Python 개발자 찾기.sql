-- 코드를 작성해주세요
select id, email, first_name, last_name
from DEVELOPER_INFOS
where 'Python' IN (SKILL_1,SKILL_2,SKILL_3)
order by id