-- 코드를 입력하세요
SELECT product_code as PRODUCT_CODE, SUM(price * sales_amount) as SALES
FROM product p 
join offline_sale o
on p.product_id = o.product_id
group by product_code
order by SALES desc, PRODUCT_CODE