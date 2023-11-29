@tag
Feature: Cliente faz saque de dinheiro como um cliente,
eu gostaria de sacar dinheiro em um caixa eletronico,
    para que eu nao tenha que esperar em uma fila do banco.

  @tag1
  Scenario: Cliente especial com saldo negativo
    Given Um cliente especial com saldo atual de 200 reais
    When for solicitado um saque no valor de 100 reais
    Then deve efetuar o saque e atualizar o saldo da conta para 300 reais
    And check more outs

  @tag2
  Scenario Outline: Cliente comum com saldo negativo
    Given um cliente com saldo atual de -200 reais
    When solicitar um saque de 200 reais
    Then nao deve efetuar o saque e deve retornar a mensagem saldo Insuficiente
    