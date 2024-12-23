-- 코드를 입력하세요
SELECT ingredient_type as INGREDIENTTYPE, sum(total_order) as TOTALORDER
from first_half f
join icecream_info i
on f.flavor = i.flavor
group by ingredient_type
order by TOTALORDER