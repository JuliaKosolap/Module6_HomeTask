SELECT top 1 WITH TIES concat('Project', ' ', id) AS name, diff AS month_count
FROM
(SELECT id, datediff(month, start_date, finish_date) AS diff
FROM project)
ORDER BY month_count DESC