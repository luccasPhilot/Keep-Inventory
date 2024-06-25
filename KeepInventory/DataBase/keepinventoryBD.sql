CREATE DATABASE IF NOT EXISTS keepinventoryBD;
USE keepinventoryBD;

-- Tabela Produto
CREATE TABLE Produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DOUBLE NOT NULL,
    data_de_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_de_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela Usuario
CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    data_de_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_de_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela Funcionario
CREATE TABLE Funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE,
    data_de_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_de_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela Gerente
CREATE TABLE Gerente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    funcionario_id INT,
    FOREIGN KEY (funcionario_id) REFERENCES Funcionario(id) ON DELETE CASCADE,
    data_de_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_de_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela Fornecedor
CREATE TABLE Fornecedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_de_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_de_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela associativa Fornecedor_Produto (muitos para muitos)
CREATE TABLE Fornecedor_Produto (
    fornecedor_id INT,
    produto_id INT,
    PRIMARY KEY (fornecedor_id, produto_id),
    FOREIGN KEY (fornecedor_id) REFERENCES Fornecedor(id) ON DELETE CASCADE,
    FOREIGN KEY (produto_id) REFERENCES Produto(id) ON DELETE CASCADE
);

-- Tabela Estoque
CREATE TABLE Estoque (
    id INT AUTO_INCREMENT PRIMARY KEY,
    qtdProdutos INT NOT NULL,
    data_de_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_de_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela associativa para Estoque e Produto (muitos para muitos)
CREATE TABLE Estoque_Produto (
    estoque_id INT,
    produto_id INT,
    PRIMARY KEY (estoque_id, produto_id),
    FOREIGN KEY (estoque_id) REFERENCES Estoque(id) ON DELETE CASCADE,
    FOREIGN KEY (produto_id) REFERENCES Produto(id) ON DELETE CASCADE
);

-- Criando índices para melhorar a performance
CREATE INDEX idx_usuario_email ON Usuario (email);
CREATE INDEX idx_produto_nome ON Produto (nome);

-- Trigger para inserir registros na tabela Funcionario ou Gerente com base no cargo do usuário
DELIMITER //

CREATE TRIGGER insere_funcionario_ou_gerente_after_insert_usuario
AFTER INSERT ON Usuario
FOR EACH ROW
BEGIN
    IF NEW.cargo = 'Funcionario' THEN
        INSERT INTO Funcionario (usuario_id) VALUES (NEW.id);
    ELSEIF NEW.cargo = 'Gerente' THEN
        INSERT INTO Funcionario (usuario_id) VALUES (NEW.id);
        INSERT INTO Gerente (funcionario_id) VALUES (LAST_INSERT_ID());
    END IF;
END//

DELIMITER ;
