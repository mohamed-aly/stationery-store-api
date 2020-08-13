insert into category(description, image_url, name)
values ('pens category', 'url 1', 'pens');--id=1

insert into category(description, image_url, name, main_category)
values ('pencils category', 'url 2', 'pencils', 1),--id=2
       ('liquid ink pens', 'url 3', 'liquid ink pens', 1);--id=3

insert into product(description, in_stock, min_stock, price, name, category_id)
values ('prima jet pencil', '50', '10', '2', 'prima jet', 2),--id=1
       ('pencil 2', '40', '10', '3', 'pencil 2', 2),--id=2
       ('pencil 3', '40', '10', '3', 'pencil 3', 2),--id=3
       ('pencil 4', '40', '10', '3', 'pencil 4', 2),--id=4
       ('pencil 5', '40', '10', '3', 'pencil 5', 2),--id=5
       ('bic', '40', '10', '1', 'bic', 3),--id=6
       ('french', '40', '10', '2', 'french', 3),--id=7
       ('roto', '40', '10', '3', 'roto', 3);--id=8
