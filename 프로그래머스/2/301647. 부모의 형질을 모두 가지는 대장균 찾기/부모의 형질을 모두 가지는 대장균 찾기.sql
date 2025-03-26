SELECT e.id, e.genotype, d.genotype as PARENT_GENOTYPE 
FROM 
    ECOLI_DATA e
INNER JOIN 
    ECOLI_DATA d ON e.parent_id = d.id
where 
    d.genotype is not null
    and (e.GENOTYPE & d.GENOTYPE) = d.GENOTYPE
order by 
    e.id