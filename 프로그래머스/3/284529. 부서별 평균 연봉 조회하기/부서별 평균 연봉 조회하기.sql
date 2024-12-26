-- 코드를 작성해주세요
select d.dept_id,  DEPT_NAME_EN, round(avg(sal)) as AVG_SAL
from hr_department d
join hr_employees e
on d.dept_id = e.dept_id
group by dept_id
order by AVG_SAL desc