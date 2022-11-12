SELECT owner_id, owner_name, COUNT(category_id) AS different_category_count
FROM article NATURAL JOIN owner NATURAL JOIN category_article _mapping
ORDER BY different_category_count DSEC;