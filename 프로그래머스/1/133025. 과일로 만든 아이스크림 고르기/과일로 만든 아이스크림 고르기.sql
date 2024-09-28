-- 코드를 입력하세요
SELECT f.FLAVOR
FROM FIRST_HALF f
JOIN ICECREAM_INFO i
on f.flavor = i.flavor
where f.total_order > 3000 and ingredient_type = 'fruit_based'
order by total_order desc