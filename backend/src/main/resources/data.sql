INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana Maria', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_genre (name) VALUES ('Ação');
INSERT INTO tb_genre (name) VALUES ('Comédia');
INSERT INTO tb_genre (name) VALUES ('Desenho');

INSERT INTO tb_movie(title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('Homem aranha', 'aranha', 2021, 'http://www.guiadosquadrinhos.com/homem-aranha', 'Aventura do aranha',1);
INSERT INTO tb_movie(title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('Homem de ferro', 'ferro', 2022, 'http://www.guiadosquadrinhos.com/homem-de-ferro', 'Aventura do homem de ferro',2);
INSERT INTO tb_movie(title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('Vingadores', 'Guerra do além', 2023, 'http://www.guiadosquadrinhos.com/vingadores', 'Muita guerra',3);

INSERT INTO tb_review(text, user_id, movie_id) VALUES ('Filme muito bom', 2, 1);
INSERT INTO tb_review(text, user_id, movie_id) VALUES ('Gostei e recomendo', 2, 2); 
INSERT INTO tb_review(text, user_id, movie_id) VALUES ('Muito top', 2, 3); 

 




