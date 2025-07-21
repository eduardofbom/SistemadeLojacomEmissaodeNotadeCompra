# Sistema de Loja com Emissão de Nota de Compra

## 1. CONTEXTO
    Uma pequena loja deseja informatizar o processo de venda. Atualmente, o atendente anota produtos
    e valores manualmente e depois calcula o total “na calculadora”. A gerência quer um sistema
    simples que permita cadastrar produtos, cadastrar clientes e emitir notas de compra contendo
    itens, subtotal e valor total. O sistema deve ser desenvolvido em Java aplicando os pilares da
    Programação Orientada a Objetos: encapsulamento, herança, polimorfismo.


   
## 3. OBJETIVOS DE APRENDIZAGEM
    Ao concluir o projeto, o(a) aluno(a) deverá ser capaz de:
    1. Modelar um domínio simples usando classes, atributos e métodos.
    2. Aplicar encapsulamento (atributos privados e acesso controlado).
    3. Criar hierarquias de herança plausíveis e saber quando preferir composição.
    4. Usar polimorfismo
    5. Implementar agregações/associações (Loja → Produtos, Cliente → Compras, Nota → Itens).
    6. Escrever código legível, testável e com tratamento básico de erros.



## 4. ESCOPO DO PROJETO
    O sistema deve permitir, via interface de linha de comando (CLI), as operações:
   
    3.1 Cadastro de Produtos
        • Criar produto com código único, nome, preço base.
        • Diferenciar tipos de produto.
        • Listar produtos cadastrados.
        • Atualizar preço/estoque.

    3.2 Cadastro de Clientes
        • Cadastrar cliente com identificador único, nome, endereço e telefone.
        • Listar clientes.
        • Atualizar clientes.

    3.3 Emissão de Nota de Compra
        • Selecionar cliente cadastrado.
        • Adicionar itens (produto + quantidade).
        • Calcular subtotal.
        • Calcular valor total.
        • Gerar número/ID da nota e data.
        • Exibir resumo formatado.


   
## 4. FLUXO DE USO
    1. Menu Principal
        1. Cadastrar Produto
        2. Alterar Produto
        2. Cadastrar Cliente
        3. Alterar Cliente
        3. Criar Nota de Compra
        4. Listar Notas Emitidas
        5. Listar Produtos
        6. Listar Clientes
        0. Sair
    2. Criar Nota
        • Selecionar cliente → listar/filtrar
        • Adicionar itens até confirmar
        • Exibir resumo: subtotal, total



## 5. ESTRUTURAS DE PACOTES (sugestão)
    loja
    ├── Main.java
    ├── model
    │   ├── produto
    │   │   ├── Produto.java
    │   │   ├── ProdutoFisico.java
    │   │   ├── ProdutoDigital.java
    │   │   └── ProdutoPerecivel.java
    │   ├── cliente
    │   │   ├── Cliente.java
    │   │   ├── PessoaFisica.java
    │   │   └── PessoaJuridica.java
    │   ├── nota
    │   │   ├── Nota.java
    │   │   └── ItemNota.java
    │
    └── ui
        ├── ConsoleMenu.java
        └── InputUtils.java


   
## 7. Requisitos Técnicos Recomendados
    • Java 17+
    • Uso de BigDecimal para valores monetários (evitar erros com double).
    • Datas com java.time (LocalDate, LocalDateTime, Period, Duration).
