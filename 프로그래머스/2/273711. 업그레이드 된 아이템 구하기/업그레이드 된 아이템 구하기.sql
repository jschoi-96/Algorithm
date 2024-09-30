-- 코드를 작성해주세요
SELECT i.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO i
JOIN ITEM_TREE t
ON i.item_id = t.item_id
where t.PARENT_ITEM_ID IN (SELECT ITEM_iD
                          FROM ITEM_INFO 
                          WHERE RARITY = 'RARE')
                          order by item_id desc