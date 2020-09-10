# Exercício 1 - Gerador de Observação

Modificações Implementadas:

1. Refactoring da Classe original GeradorObservacao:
    * Remoção do campo "texto" para dar lugar a utilização de string constants para os dois tipos de mensagens
    possíveis;
    * Separação das responsabilidades de resolver o tipo de mensagems (singular ou plural) da responsabilidade de
    formatar a lista de números em métodos diferentes;
    * Uso de string constants para os valores de separador e terminador de lista.
    
2. Implementação do design pattern Strategy para adicionar o segundo comportamento desejado:
    * A classe GeradorObservacao foi transformada numa classe estática
    * O comportamento original, bem como o novo comportamento desejado, estão implementados em classes diferentes que
    implementam uma interface em comum dando à funcionalidade principal a flexibilidade de imprimir uma lista de Faturas
    em diferentes formatos e com diferentes campos de acordo com o implementado pelo algoritimo da classe injetada.
