-- 코드를 작성해주세요
select sum(score) as SCORE, g.emp_no, emp_name, position, email
from HR_EMPLOYEES e
join HR_DEPARTMENT d
on e.dept_id = d.dept_id
join HR_GRADE g
on e.emp_no = g.emp_no
group by g.emp_no, e.emp_name, e.position, e.email
order by SCORE desc
limit 1