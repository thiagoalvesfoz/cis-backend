CREATE TABLE Endereco (
  id BIGINT NOT NULL,
  bairro VARCHAR(255) NULL,
  numero BIGINT NULL,
  logradouro VARCHAR(255) NULL,
  cep BIGINT NULL,
  PRIMARY KEY (`id`)
  );
  
alter table usuario add CONSTRAINT fk_usuario_Endereco
FOREIGN KEY (Endereco_id) REFERENCES Endereco (id);