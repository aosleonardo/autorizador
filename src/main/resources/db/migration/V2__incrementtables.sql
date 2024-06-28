INSERT INTO miniautorizador.cartao
(numero_cartao, senha)
VALUES('1111111111111111', '111111');

INSERT INTO miniautorizador.cartao
(numero_cartao, senha)
VALUES('2222222222222222', '222222');

INSERT INTO miniautorizador.cartao
(numero_cartao, senha)
VALUES('3333333333333333', '333333');

INSERT INTO miniautorizador.saldo
(saldo, cartao_id)
VALUES(100.00, (SELECT c.id_cartao  FROM miniautorizador.cartao c where c.numero_cartao = '1111111111111111'));

INSERT INTO miniautorizador.saldo
(saldo, cartao_id)
VALUES(200.00, (SELECT c.id_cartao  FROM miniautorizador.cartao c where c.numero_cartao = '2222222222222222'));

INSERT INTO miniautorizador.saldo
(saldo, cartao_id)
VALUES(300.00, (SELECT c.id_cartao  FROM miniautorizador.cartao c where c.numero_cartao = '3333333333333333'));

