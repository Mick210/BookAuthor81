-- Задача
-- Есть таблица book с колонками name и author_id
-- и таблица author с колонками id и name.
-- Вывести все книги определенного автора (author.name).

SELECT b.name FROM book b
JOIN author a ON b.author_id = a.id
WHERE a.name = 'Лев Толстой';

SELECT b.name FROM book b
JOIN author a ON b.author_id = a.id
WHERE a.name = 'Фёдор Достоевский';

